package javaz.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
	private List<MemberVO> members = null;

	public MemberDAO() {
	    members = new ArrayList<>();
    }
    // 회원 가입
	public boolean insertMember(String id, String pw, String name, String email, String photo, String gender) {
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setEmail(email);
		member.setPhoto(photo);
		member.setGender(gender);
		member.setJoinDate(new Date());
		return members.add(member);
	}
	public boolean insertMember(MemberVO member) {
		member.setJoinDate(new Date());
		return members.add(member);
	}
	// 전체 회원 목록
	public List<MemberVO> selectAllMember() {
		return members;
	}
}
