package member.model.vo;

public class MemberVo {
	
	private String memberId;
	private String memberPw;
	private String nickname;

	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPw=" + memberPw + ", nickname="
				+ nickname + "]";
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
