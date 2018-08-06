package kr.or.ddit.lprod.web;

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

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceInf;

/**
 * Servlet implementation class LprodServlet
 */
@WebServlet("/lprodList")
public class LprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = request.getParameter("lpage").isEmpty() ? 1 : Integer.parseInt(request.getParameter("lpage"));
		int pagesize = request.getParameter("lpagesize").isEmpty() ? 10 : Integer.parseInt(request.getParameter("lpagesize"));
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("lpage", page);
		paramMap.put("lpagesize", pagesize);
		
		LprodServiceInf service = new LprodService();
		
		List<LprodVo> lprodList = service.getStudentPageList(paramMap);
		List<LprodVo> lprodAll = service.selectAllLprod();
		
		request.setAttribute("lprodAll", lprodAll);
		request.setAttribute("lprodList", lprodList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lprod/lprodList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
