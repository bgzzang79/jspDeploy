package kr.or.ddit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/pic")
public class PicDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//<img src="/pic?id=2/">
		int id = Integer.parseInt(request.getParameter("id"));
		
		//물리 파일명을 이용하여 사진 다운로드
		
		//사용자 정보 조회
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudent2(id);
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+studentVo.getPic()+"\"");
		response.setContentType("application/octet-stream");
		
		//FileUtil.fileUploadPath : rabbit.jpg
		//파라미터로 파일명이 제공
		// /fileDownLoad?fileName=rabbit.jpg
		String fileName = request.getParameter("fileName");
		
		//D:\A_TeachingMaterial\7.JspSpring\fileUpload\rabbit.jpg
		String file = studentVo.getPicpath() + File.separator + studentVo.getPicname();
		
		//file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[512];
		int len = 0;
		while((len = fis.read(b)) != -1){
			sos.write(b,0,len);
		}
		sos.close();
		fis.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
