package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/defCompServlet")
public class DefCompServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//view로 위임
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/defCompResult.jsp");
		rd.forward(request, response);
	}

}
