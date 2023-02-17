package board.model.vo;

import java.sql.Date;

public class BoardVo {
//	boardIdx number primary key not null,
//	boardWriter varchar2(20 BYTE) not null,
//	boardDiv varchar2(20 byte) not null,
//	boardSubject varchar2(255 byte) not null,
//	boardContent clob,
//	boardDate timestamp default(CURRENT_TIMESTAMP),
//	viewCount number default(0)
	private int boardIdx;
	private String boardWriter;
	private String boardDiv;
	private String boardSubject;
	private String boardContent;
	private Date boardDate;
	private int viewCount;
	
	@Override
	public String toString() {
		return "BoardVo [boardIdx=" + boardIdx + ", boardWriter=" + boardWriter + ", boardDiv=" + boardDiv
				+ ", boardSubject=" + boardSubject + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", viewCount=" + viewCount + "]";
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardDiv() {
		return boardDiv;
	}

	public void setBoardDiv(String boardDiv) {
		this.boardDiv = boardDiv;
	}

	public String getBoardSubject() {
		return boardSubject;
	}

	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

}
