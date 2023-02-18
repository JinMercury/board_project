package comment.model.vo;

import java.sql.Date;

public class CommentVo {
	
//	 commentIdx number primary key not null,
//	 boardIdx number not null references board_tbl(boardIdx),
//	 commentWriter varchar2(20 BYTE) not null,
//	 commentContent clob,
//	 commentDate timestamp default(CURRENT_TIMESTAMP)
	
	private int commentIdx;
	private int boardIdx;
	private String commentWriter;
	private String commentContent;
	private Date commentDate;
	
	@Override
	public String toString() {
		return "CommentVo [commentIdx=" + commentIdx + ", boardIdx=" + boardIdx + ", commentWriter=" + commentWriter
				+ ", commentContent=" + commentContent + ", commentDate=" + commentDate + "]";
	}

	public int getCommentIdx() {
		return commentIdx;
	}

	public void setCommentIdx(int commentIdx) {
		this.commentIdx = commentIdx;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

}
