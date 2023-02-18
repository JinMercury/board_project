package home.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.BoardVo;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({ "/", "/main", "/index", "/home" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> paraMap = request.getParameterMap();
		if(paraMap.size() == 0) {
			List<BoardVo> result = new BoardService().getList();
			
			request.setAttribute("getList", result);
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		} else {
			String boardDiv = request.getParameter("selDiv");
			String searchInp = request.getParameter("searchInp");
			
			List<BoardVo> result = new BoardService().getSearchList(boardDiv, searchInp);
			
			request.setAttribute("getList", result);
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardDiv = request.getParameter("selDiv");
		String searchInp = request.getParameter("searchInp");
		
		List<BoardVo> result = new BoardService().getSearchList(boardDiv, searchInp);
		
		request.setAttribute("getList", result);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

}
