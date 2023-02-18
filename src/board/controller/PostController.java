package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.BoardVo;
import comment.model.service.CommentService;
import comment.model.vo.CommentVo;
import member.model.vo.MemberVo;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardVo postResult = new BoardService().getPost(idx);
		List<CommentVo> commResult = new CommentService().getComm(idx);
		
		new BoardService().viewCntUp(idx);
		
		request.setAttribute("getPost", postResult);
		request.setAttribute("getComm", commResult);
		request.getRequestDispatcher("/WEB-INF/view/board/post.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = ((MemberVo)request.getSession().getAttribute("lgnss")).getNickname();
		String commentContent = request.getParameter("commentContent");
		int boardIdx = Integer.parseInt(request.getParameter("boardIdx"));
		
		CommentVo vo = new CommentVo();
		vo.setCommentContent(commentContent);
		vo.setCommentWriter(nickname);
		vo.setBoardIdx(boardIdx);
		int result = new CommentService().setComm(vo);
		
		if(result < 1) {
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			response.sendRedirect(request.getContextPath() + "/post?idx=" + boardIdx);
		}
	}

}
