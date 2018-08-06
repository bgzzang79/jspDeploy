package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* Method : doGet
	* 최초작성일 : 2018. 7. 3.
	* 작성자 : PC09
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 :
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	* Method : doPost
	* 최초작성일 : 2018. 7. 3.
	* 작성자 : PC09
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 :
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 받아서 sysout으로 console창에 출력
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		//로그인 프로세스
		//가짜(fake) service, dao객체를 생성
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.getUser(userId);
		
		//PrintWriter pw = response.getWriter();
		/*userService에서 받아온 userVo의 정보와 사용자가 입력한 정보가 동일할 경우 [로그인 성공] 메시지를 화면에 출력
		정보가 틀릴경우 [로그인 실패] 메시지를 화면에 출력*/
		
		//로그인 성공시 userVo객체를 저장하여(적당한 영역에) main.jsp에서 사용자 아이디를 화면에 출력
		//단 새로운 탭에서 main.jsp를 직접 접속해도 사용자 아이디가 화면에 나와야한다.
		if(userVo.validateUser(userId, userPw)){
			HttpSession session = request.getSession();
			session.setAttribute("userVo",userVo);
			request.getRequestDispatcher("/jsp/info.jsp").forward(request, response);
		}else{
//			response.sendRedirect("/jsp/login.jsp");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
		
		System.out.println("userId : "+userVo.getUserId());
		System.out.println("userPw : "+userVo.getUserPw());
		
		//pw.close();
	}

}
