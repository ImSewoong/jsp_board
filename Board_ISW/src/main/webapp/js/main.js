function checkAll(bool){
	console.log("chkbox의 상태", bool);
	var chs = document.getElementsByName("ch");
	for(let i=0; i<chs.length; i++){
		chs[i].checked = bool;
	}
}

window.onload = function(){
	console.log("javascript onload");
	var chs = document.getElementsByName("ch");
	var chkbox = document.getElementById("chkbox");
	
	for(let i=0; i<chs.length; i++){
		chs[i].onclick=function(){
			if(chs.length == chCheckedCount()){
				chkbox.checked = true;
			}else{
				chkbox.checked = false;
			}
		}
	}
	
}


var chCheckedCount = function(){
	var chs = document.getElementsByName("ch");
	let cnt = 0;
	for(let i=0; i<chs.length; i++){
		if(chs[i].checked){
			cnt++;
		}
	}
	return cnt;
}

function chSubmit(){
	var cnt = chCheckedCount();
	if(cnt == 0){
		alert("선택된 글이 없습니다.");
	}else{
		document.querySelector("form").submit();
	}
	return false;
}


// 입력 버튼 유효성 검사
function writeForm(){
	var form = document.forms[0];
	
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	
	console.log(title , content);
	if(title.value == "" ){
		alert("제목을 입력해주세요");
		return;
	}else if(content.value ==""){
		alert("내용을 입력해주세요");
		return;
	}else{
		
		var titleStr = title.value;
		var contentStr = content.value;
		
		titleStr = titleStr.replace(/\r\n|\r|\n|\n\r/gim, "<br>");
		titleStr = titleStr.replace(/</gim, "&lt;");
		titleStr = titleStr.replace(/>/gim, "&gt;");
		titleStr = titleStr.replace(/\'/gim, "&#39");
		
		
		contentStr = contentStr.replace(/\r\n|\r|\n|\n\r/gim, "<br>");
		contentStr = contentStr.replace(/</gim, "&lt;");
		contentStr = contentStr.replace(/>/gim, "&gt;");
		contentStr = contentStr.replace(/\'/gim, "&#39");
		
		content.value = contentStr;
		title.value = titleStr;
		
		form.submit();
	}
}

// 입력 버튼 유효성 검사(수정)
function modifyForm(){
	var form = document.forms[0];
	
	var content = document.getElementById("content");
	
	if(content.value ==""){
		alert("내용을 입력해주세요");
		return;
	}else{
		var contentStr = content.value;
		
		contentStr = contentStr.replace(/\r\n|\r|\n|\n\r/gim, "<br>");
		contentStr = contentStr.replace(/</gim, "&lt;");
		contentStr = contentStr.replace(/>/gim, "&gt;");
		contentStr = contentStr.replace(/\'/gim, "&#39");
		
		content.value = contentStr;
		
		form.submit();
	}
}

// 삭제 기능
function deleteBoard(){
	var frm = document.forms[0];
	var con = confirm("선택된 글이 삭제 됩니다.");
	if(con){
		frm.action = "./realDelete.do";
		frm.method = "post";
		frm.submit();
	}else{
		alert("삭제가 취소되었습니다.");
	}
	
}

function modify(){
	var frm = document.forms[0];
	
	var seq = document.querySelector("input[name=seq]").value;
	
	frm.action = "./modifyBoard.do?seq="+seq;
	frm.method = "get";
	frm.submit();
}



