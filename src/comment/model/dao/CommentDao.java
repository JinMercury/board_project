package comment.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import comment.model.vo.CommentVo;
import common.jdbc.JdbcTemplate;

public class CommentDao {
	
	public List<CommentVo> getComm(Connection conn, int idx) {
		List<CommentVo> result = null;
		String query = "select * from comment_tbl where boardIdx=? order by commentdate desc";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<>();
			while(rs.next()) {
				CommentVo vo = new CommentVo();
				vo.setBoardIdx(rs.getInt("boardIdx"));
				vo.setCommentContent(rs.getString("commentContent"));
				vo.setCommentDate(rs.getDate("commentDate"));
				vo.setCommentIdx(rs.getInt("commentIdx"));
				vo.setCommentWriter(rs.getString("commentWriter"));
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

	public int setComm(Connection conn, CommentVo vo) {
		int result = -1;
		String query = "insert into comment_tbl values(seq_comm.nextval, ?, ?, ?, default)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getBoardIdx());
			pstmt.setString(2, vo.getCommentWriter());
			pstmt.setString(3, vo.getCommentContent());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int commentDel(Connection conn, int commIdx) {
		int result = -1;
		String query = "delete from comment_tbl where commentIdx=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, commIdx);
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}

	public int postCommDel(Connection conn, int idx) {
		int result = -1;
		String query = "delete from comment_tbl where boardIdx=?";
		
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

}
