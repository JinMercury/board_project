package board.model.service;

import java.sql.Connection;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.vo.BoardVo;
import comment.model.dao.CommentDao;
import common.jdbc.JdbcTemplate;

public class BoardService {

	public List<BoardVo> getList() {
		List<BoardVo> result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().getList(conn);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public BoardVo getPost(int idx) {
		BoardVo result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().getPost(conn, idx);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public int postDel(int idx) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().postDel(conn, idx);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public int postWrite(BoardVo vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().postWrite(conn, vo);
		JdbcTemplate.close(conn);
		return 0;
	}

	public int postAmend(BoardVo vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().postAmend(conn, vo);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public void viewCntUp(int idx) {
		Connection conn = JdbcTemplate.getConnection();
		new BoardDao().viewCntUp(conn, idx);
		JdbcTemplate.close(conn);
	}

	public List<BoardVo> getSearchList(String boardDiv, String searchInp) {
		List<BoardVo> result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().getSearchList(conn, boardDiv, searchInp);
		JdbcTemplate.close(conn);
		
		return result;
	}

}
