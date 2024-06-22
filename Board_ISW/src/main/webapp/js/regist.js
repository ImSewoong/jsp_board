var idConfirm = function(){
	var idChecked = document.getElementsByName("id")[0];
	if(idChecked.title == "n"){
		alert("아이디 중복검사를 먼저 진행해 주세요");
		idChecked.focus()
	}
}
/*
function idCheck(){
	var id = document.getElementsByName("id")[0];
	console.log("입력된 id 값 : "+ id);
	if(id.value == ""){
		alert("아이디를 입력 후 중복검사를 진행해 주세요");
		id.focus();
		return;
	}
	window.open("./duplicateId.do?id="+id.value,"","width=500px, height=600px");
}
*/
function idCheck(){
	var id = document.getElementById("id");
	$.ajax({
				url:"./idCheckAjax.do", // 요청주소
				type:"post", // 요청 protocol
				data:{id:id.value}, // 서버전달 값
				dataType:"json", // 서버에서 반환 결과의 반환 타입
				success:function(msg){ //msg의 변수는 서버에서 JSON형태로 전달된 값. state 4 이고 state가 200인 경우
					console.log(typeof msg, msg.isc);
					console.log(typeof msg, msg);
					
					if(msg.isc == false){
						document.getElementById("idChk").innerHTML
						= "<span style='color:green;'>사용가능한 아이디 입니다.</span>";
						id.title ="y";
						id.disabled = "disabled";
					}else{
						document.getElementById("idChk").innerHTML
						= "<span style='color:red;'>이미 있는 아이디 입니다.</span>";
					}	
				},
				error:function(){
					alert("잘못된 요청 처리 입니다.");
				}
			});
}

window.onload = function() {
	document.querySelector("input[type=submit]").onclick = function(e){
		
		
		var idIsc = document.getElementsByName("id")[0].title;
		var frm = document.forms[0];
		var id = document.getElementById("id").value.trim();
		var name = document.getElementById("name").value.trim();
		var password = document.getElementById("password").value.trim();
		var phone = document.getElementById("phone").value.trim();
		var imgName = document.getElementById("imgName").value.trim();
		
		var inputText = document.querySelectorAll("input[type=text], input[type=password], input[type=file]");
		console.log(inputText.length);
		
		for(let i=1; i<inputText.length; i++){
			inputText[i].onclick = idConfirm;
		}
		
		if(id ===''){
			alert("아이디를 입력해주세요");
			e.preventDefault();
			return;
		}
		
		if(name === ''){
			alert("이름을 입력해주세요");
			e.preventDefault();
			return;
		}else if(password === ''){
			alert("비밀번호를 입력해주세요");
			e.preventDefault();
			return;
		}else if(phone === ''){
			alert("핸드폰를 입력해주세요");
			e.preventDefault();
			return;
		}else if(imgName === ''){
			alert("파일를 입력해주세요");
			e.preventDefault();
			return;
		}
		
		
		if(idIsc == 'y'){
			document.getElementsByName("id")[0].disabled="";
			frm.enctype="multipart/form-data";
			frm.action="./registform.do";
			frm.submit();
		}else{
			e.preventDefault();
			return false;
		}
		
	}
}




