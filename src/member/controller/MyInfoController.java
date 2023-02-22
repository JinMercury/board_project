package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import comment.model.service.CommentService;
import member.model.service.MemberService;
import member.model.vo.MemberVo;

/**
 * Servlet implementation class MyInfoController
 */
@WebServlet("/myinfo")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVo vo = new MemberVo();
		vo.setMemberId(((MemberVo)request.getSession().getAttribute("lgnss")).getMemberId());
		String currNickname = (((MemberVo)request.getSession().getAttribute("lgnss")).getNickname());
		vo.setMemberPw(request.getParameter("memberPw"));
		vo.setNickname(request.getParameter("nickname"));
		
		int result = new MemberService().infoChange(vo);
		if(result == 1) {
			new BoardService().boardWriterChange(currNickname, vo.getNickname());
			new CommentService().commentWriterChange(currNickname, vo.getNickname());
		}
		
		if(result < 1) {
			request.setAttribute("infoErr", "정보수정이 실패하였습니다. 다시 시도해주세요");
			request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+"/logout");
		}
	}

}
