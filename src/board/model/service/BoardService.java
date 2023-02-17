package board.model.service;

import java.sql.Connection;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.vo.BoardVo;
import common.jdbc.JdbcTemplate;

public class BoardService {

	public List<BoardVo> getList() {
		List<BoardVo> result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().getList(conn);
		JdbcTemplate.close(conn);
		
		return result;
	}

}
