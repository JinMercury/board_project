package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static common.jdbc.JdbcTemplate.*;

import member.model.vo.MemberVo;

public class MemberDao {
	
	// 로그인
	public MemberVo login(Connection conn, MemberVo vo) {
		MemberVo result = null;
		String query = "select memberid, nickname from member_tbl where memberid=? and memberpw=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new MemberVo();
				result.setMemberId(rs.getString("memberId"));
				result.setNickname(rs.getString("nickname"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	public int enroll(Connection conn, MemberVo vo) {
		int result = -1;
		String query = "insert into member_tbl values(?, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPw());
			pstmt.setString(3, vo.getNickname());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int infoChange(Connection conn, MemberVo vo) {
		int result = -1;
		
		String query = "update member_tbl set memberPw=?, nickname=? where memberId=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, vo.getMemberPw());
			pstmt.setString(2, vo.getNickname());
			pstmt.setString(3, vo.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
