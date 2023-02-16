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

}
