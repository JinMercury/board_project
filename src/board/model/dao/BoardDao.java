package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.model.vo.BoardVo;
import common.jdbc.JdbcTemplate;

public class BoardDao {

	public List<BoardVo> getList(Connection conn) {
		List<BoardVo> result = null;
		String query = "select * from board_tbl order by boarddate desc";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<>();
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoardContent(rs.getString("boardContent"));
				vo.setBoardDate(rs.getDate("boardDate"));
				vo.setBoardDiv(rs.getString("boardDiv"));
				vo.setBoardIdx(rs.getInt("boardIdx"));
				vo.setBoardSubject(rs.getString("boardSubject"));
				vo.setBoardWriter(rs.getString("boardWriter"));
				vo.setViewCount(rs.getInt("viewCount"));
				result.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

}
