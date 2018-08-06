package jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocaleSelect
 */
@WebServlet("/localeSelect")
public class LocaleSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locale =request.getParameter("locale");
		locale = locale == null ? "ko" : locale;
		System.out.println("locale : "+locale);
		
		request.setAttribute("locale", locale);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/jstl/locale/localeSelect.jsp");
		rd.forward(request, response);
	}
}
