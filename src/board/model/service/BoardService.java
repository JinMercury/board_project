package board.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.model.dao.BoardDao;
import board.model.vo.BoardVo;
import comment.model.dao.CommentDao;
import common.jdbc.JdbcTemplate;
import page.Paging;

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

	public Paging getPage(int pNum) {
		Connection conn = JdbcTemplate.getConnection();
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", (pNum - 1) * 10 + 1);
		page.put("end", pNum * 10);
		
		BoardDao dao = new BoardDao();
		List<BoardVo> dataList = dao.selectPage(conn, page);
		
		int totalRowCount = dao.selectTotalRowCount(conn);
		int mod = totalRowCount % 10 == 0 ? 0 : 1;
		int pageCount = (totalRowCount / 10) + mod;
		
		Paging paging = new Paging(dataList, pNum, pageCount, 10, 5);
		JdbcTemplate.close(conn);
		return paging;
	}

	public Paging getSearchListPage(int pNum, String boardDiv, String searchInp) {
		Connection conn = JdbcTemplate.getConnection();
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", (pNum - 1) * 10 + 1);
		page.put("end", pNum * 10);
		
		BoardDao dao = new BoardDao();
		List<BoardVo> dataList = dao.getSearchListPage(conn, page, boardDiv, searchInp);
		
		int totalRowCount = dao.selectSearchRowCount(conn, boardDiv, searchInp);
		int mod = totalRowCount % 10 == 0 ? 0 : 1;
		int pageCount = (totalRowCount / 10) + mod;
		
		Paging paging = new Paging(dataList, pNum, pageCount, 10, 5);
		JdbcTemplate.close(conn);
		return paging;
	}

	public void boardWriterChange(String currNickname, String nickname) {
		Connection conn = JdbcTemplate.getConnection();
		new BoardDao().boardWriterChange(conn, currNickname, nickname);
		JdbcTemplate.close(conn);
	}

}
