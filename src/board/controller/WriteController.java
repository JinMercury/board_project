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
 * Servlet implementation class WriteController
 */
@WebServlet("/write")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/board/write.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVo vo = new BoardVo();
		String boardDiv = request.getParameter("boardDiv");
		String boardWriter = ((MemberVo)request.getSession().getAttribute("lgnss")).getNickname();
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		
		vo.setBoardDiv(boardDiv);
		vo.setBoardWriter(boardWriter);
		vo.setBoardSubject(boardSubject);
		vo.setBoardContent(boardContent);
		
		int result = new BoardService().postWrite(vo);
		
		response.sendRedirect(request.getContextPath() + "/");
	}

}
