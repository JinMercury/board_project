package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.BoardVo;
import member.model.vo.MemberVo;

/**
 * Servlet implementation class AmendController
 */
@WebServlet("/amend")
public class AmendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmendController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardVo result = new BoardService().getPost(idx);
		
		if(result == null) {
			response.sendRedirect(request.getContextPath() + "/");
		}
		
		request.setAttribute("vo", result);
		request.getRequestDispatcher("/WEB-INF/view/board/amend.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVo vo = new BoardVo();
		int boardIdx = Integer.parseInt(request.getParameter("boardIdx"));
		String boardDiv = request.getParameter("boardDiv");
		String boardWriter = ((MemberVo)request.getSession().getAttribute("lgnss")).getNickname();
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		
		vo.setBoardIdx(boardIdx);
		vo.setBoardDiv(boardDiv);
		vo.setBoardWriter(boardWriter);
		vo.setBoardSubject(boardSubject);
		vo.setBoardContent(boardContent);
		
		int result = new BoardService().postAmend(vo);
		
		response.sendRedirect(request.getContextPath() + "/post?idx=" + boardIdx);
	}

}
