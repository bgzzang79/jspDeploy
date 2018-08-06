package kr.or.ddit.student.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//StudentService 객체를 생성, 학생 전체 리스트를 조회
		//학생 전체 리스트 request객체에 속성으로 설정
		//studentList.jsp로 forward

		//page, pagesize 파라미터, 파라미터 값이 없을 경우
		//기본 값으로 page: 1, pagesize: 10
		int page = request.getParameter("page").isEmpty() ? 1 : Integer.parseInt(request.getParameter("page"));
		int pagesize = request.getParameter("pagesize").isEmpty() ? 10 : Integer.parseInt(request.getParameter("pagesize"));

		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pagesize", pagesize);

		StudentServiceInf service = new StudentService();

		//학생 조회
//		Map<String, Object> resultMap = service.getStudentPageList(paramMap);
		List<StudentVo> studentList = service.getStudentPageList(paramMap);
		List<StudentVo> studentAll = service.selectAllStudent();
		
		request.setAttribute("studentAll", studentAll);
		request.setAttribute("studentList", studentList);
		
		//페이지 네비게이션 문자열
//		String pageNavi = (String)resultMap.get("pageNavi");
//		request.setAttribute("pageNavi", pageNavi);
		
		RequestDispatcher rd = request.getRequestDispatcher("/student/studentList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}