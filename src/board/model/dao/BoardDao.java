package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	public BoardVo getPost(Connection conn, int idx) {
		BoardVo result = null;
		String query = "select * from board_tbl where boardIdx=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new BoardVo();
				result.setBoardContent(rs.getString("boardContent"));
				result.setBoardDate(rs.getDate("boardDate"));
				result.setBoardDiv(rs.getString("boardDiv"));
				result.setBoardIdx(rs.getInt("boardIdx"));
				result.setBoardSubject(rs.getString("boardSubject"));
				result.setBoardWriter(rs.getString("boardWriter"));
				result.setViewCount(rs.getInt("viewCount"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int postDel(Connection conn, int idx) {
		int result = -1;
		String query = "delete from board_tbl where boardIdx=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int postWrite(Connection conn, BoardVo vo) {
		int result = -1;
		String query = "insert into board_tbl values(seq_board.nextval, ?, ?, ?, ?, default, default)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getBoardWriter());
			pstmt.setString(2, vo.getBoardDiv());
			pstmt.setString(3, vo.getBoardSubject());
			pstmt.setString(4, vo.getBoardContent());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int postAmend(Connection conn, BoardVo vo) {
		int result = -1;
		String query = "update board_tbl set boardWriter=?, boardDiv=?, boardSubject=?, boardContent=? where boardIdx=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getBoardWriter());
			pstmt.setString(2, vo.getBoardDiv());
			pstmt.setString(3, vo.getBoardSubject());
			pstmt.setString(4, vo.getBoardContent());
			pstmt.setInt(5, vo.getBoardIdx());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public void viewCntUp(Connection conn, int idx) {
		String query = "update board_tbl set viewCount=(select viewCount from board_tbl where boardIdx=?)+1 where boardIdx=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, idx);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
	}

	public List<BoardVo> getSearchList(Connection conn, String boardDiv, String searchInp) {
		List<BoardVo> result = null;
		String query = "select * from board_tbl where boarddiv=? and boardSubject like ? order by boarddate desc";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, boardDiv);
			pstmt.setString(2, "%"+searchInp+"%");
			
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

	// 페이징 처리
	public List<BoardVo> selectPage(Connection conn, Map<String, Integer> page) {
		List<BoardVo> result = null;
		String query = "SELECT * FROM "
				+ "(SELECT ROWNUM AS N, boardIdx, boardWriter, boardDiv, "
				+ "boardSubject, boardContent, boardDate, viewCount "
				+ "FROM (SELECT * FROM board_tbl ORDER BY boardDate DESC)) "
				+ "WHERE N BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, page.get("start"));
			pstmt.setInt(2, page.get("end"));
			
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

	public int selectTotalRowCount(Connection conn) {
		int result = -1;
		String query = "select count(*) from board_tbl";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<BoardVo> getSearchListPage(Connection conn, Map<String, Integer> page, String boardDiv,
			String searchInp) {
		List<BoardVo> result = null;
		String query = "SELECT * FROM "
				+ "(SELECT ROWNUM AS N, boardIdx, boardWriter, boardDiv, "
				+ "boardSubject, boardContent, boardDate, viewCount "
				+ "FROM (select * from board_tbl where boarddiv=? and boardSubject like ? order by boarddate desc)) "
				+ "WHERE N BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, boardDiv);
			pstmt.setString(2, "%"+searchInp+"%");
			pstmt.setInt(3, page.get("start"));
			pstmt.setInt(4, page.get("end"));
			
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

	public int selectSearchRowCount(Connection conn, String boardDiv, String searchInp) {
		int result = -1;
		String query = "select count(*) from board_tbl where boarddiv=? and boardSubject like ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, boardDiv);
			pstmt.setString(2, "%"+searchInp+"%");
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public void boardWriterChange(Connection conn, String currNickname, String nickname) {
		String query = "update board_tbl set boardWriter=? where boardWriter=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, nickname);
			pstmt.setString(2, currNickname);
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
	}

}
