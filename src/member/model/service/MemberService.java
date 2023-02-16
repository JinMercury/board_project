package member.model.service;

import java.sql.Connection;

import static common.jdbc.JdbcTemplate.*;

import member.model.dao.MemberDao;
import member.model.vo.MemberVo;

public class MemberService {

	// 로그인
	public MemberVo login(MemberVo vo) {
		MemberVo result = null;
		Connection conn = getConnection();
		result = new MemberDao().login(conn, vo);
		close(conn);
		
		return result;
	}
	
	

}
