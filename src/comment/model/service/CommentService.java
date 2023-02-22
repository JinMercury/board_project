package comment.model.service;

import java.sql.Connection;
import java.util.List;

import board.model.dao.BoardDao;
import comment.model.dao.CommentDao;
import comment.model.vo.CommentVo;
import common.jdbc.JdbcTemplate;

public class CommentService {
	
	public List<CommentVo> getComm(int idx) {
		List<CommentVo> result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new CommentDao().getComm(conn, idx);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public int setComm(CommentVo vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new CommentDao().setComm(conn, vo);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public int commentDel(int commIdx) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new CommentDao().commentDel(conn, commIdx);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public int postCommDel(int idx) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new CommentDao().postCommDel(conn, idx);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public void commentWriterChange(String currNickname, String nickname) {
		Connection conn = JdbcTemplate.getConnection();
		new CommentDao().commentWriterChange(conn, currNickname, nickname);
		JdbcTemplate.close(conn);
	}

}
