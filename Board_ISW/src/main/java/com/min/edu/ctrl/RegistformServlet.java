package com.min.edu.ctrl;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.min.edu.dto.EmpInfoDto;
import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegistformServlet extends HttpServlet {

	private static final long serialVersionUID = -3384690622749333778L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RegistformServlet GET요청");
		req.getRequestDispatcher("/WEB-INF/views/registForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RegistServlet POST 요청");
		req.setCharacterEncoding("UTF-8");
		
		String saveDirectory = "C:\\Programming_IDE\\eclipse\\workspace_web\\Board_ISW\\src\\main\\webapp\\upload";
		
		log.info("상대경로 : {}", saveDirectory);
		
		File directory = new File(saveDirectory);
		if (!directory.exists()) {
			boolean created = directory.mkdirs();
			if (created) {
				log.info("디렉토리가 생성되었습니다. {}", saveDirectory);
			} else {
				log.info("디렉토리가 생성이 실패하였습니다");
			}
		}
		
		
		// 파일저장을 위한 DiskFileItemFactory
		FileItemFactory factory = new DiskFileItemFactory();
		// 파일 업로드 핸들러 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 업로드 메모리 크기 제한 설정
		upload.setSizeMax(5 * 1024 * 1024); // 5MB		
		
		try {
			FileItemIterator iter = upload.getItemIterator(req);
			EmpInfoDto dto = new EmpInfoDto();
			
			while (iter.hasNext()) {
				FileItemStream item = iter.next();
				if (item.isFormField()) { //받은 데이터가 글일 경우.
					String fileName = item.getFieldName();
					String fileValue = Streams.asString(item.openStream());
					log.info("파일이 아닌 경우 처리  - fileName : {}, fileValue :{}", fileName, fileValue);
					
					if ("id".equals(fileName)) {
						dto.setId(fileValue);
					} else if ("name".equals(fileName)) {
						dto.setName(fileValue);
					} else if ("password".equals(fileName)) {
						dto.setPassword(fileValue);
					} else if ("phone".equals(fileName)) {
						dto.setPhone(fileValue);
					}
					
					log.info("최종 DB에 입력되는 From 필드 값 : {}", dto);
					
				}else {
					String file_name = item.getName();
					
					if (file_name != null && !file_name.isEmpty()) {
						
						String stored_fname = UUID.randomUUID().toString().replace("-", "")
								+ file_name.substring(file_name.lastIndexOf("."));
						
						File uploadedFile = new File(saveDirectory, stored_fname);
						
						InputStream inputStream = null;
						OutputStream outputStream = null;
						inputStream = item.openStream();
						outputStream = new FileOutputStream(uploadedFile);
						
						inputStream.transferTo(outputStream);
						
						dto.setPhoto(stored_fname);
						
						log.info("최종 DB에 입력되는 From 필드 값 : {}", dto);
					}
				}
			}
			
			IUserInfoDao dao = new UserInfoDaoImpl();
			int n = dao.insertUser(dto);
			
			if(n == 0) {
				resp.setContentType("text/html; charset=UTF-8");
			    PrintWriter out = resp.getWriter();
			    out.println("<script>alert('파일에 이상이 있습니다.'); location.href='/WEB-INF/views/errpr/html';</script>");
			    out.flush();
			}else {
				resp.setContentType("text/html; charset=UTF-8");
			    PrintWriter out = resp.getWriter();
			    out.println("<script>alert('가입이 성공적으로 이뤄졌습니다. 관리자 승인 후 로그인 가능합니다.'); location.href='./loginServlet.do';</script>");
			    out.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		
		
		
		
	}
	
}




