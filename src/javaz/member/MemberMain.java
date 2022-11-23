package javaz.member;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MemberMain {
	private Scanner sc = new Scanner(System.in);
	private MemberDAO members = new MemberDAO();
	private LoginCheck lc = new LoginCheck();

	public static void main(String[] args) {
		new MemberMain().menu();
	}

	public void menu() {
		while (true) {
			System.out.println("----------- Member only SYSTEM MAIN -----------");
			System.out.println("  1. 가입\t\t 2. 로그인\t 3. 시스템 종료");
			System.out.println("-----------------------------------------------");
			System.out.print(">> 선택 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch (select) {
				case 1:
					join();
					break;
				case 2:
					login();
					break;
				case 3:
					System.out.println(">> 시스템을 종료합니다.");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println(">> 1 ~ 3 중에 하나만 입력해 주세요.");
					break;
			}
		}
	}

	public void join() {
		MemberVO member = new MemberVO();
		System.out.println("----------- Member only SYSTEM 회원 가입 -----------");
		System.out.print(">> 아이디 : ");
		member.setId(sc.nextLine());
		System.out.print(">> 비밀번호 : ");
		member.setPw(sc.nextLine());
		System.out.print(">> 이름 : ");
		member.setName(sc.nextLine());
		System.out.print(">> 이메일 : ");
		member.setEmail(sc.nextLine());
		System.out.print(">> 사진 : ");
		member.setPhoto(sc.nextLine());
		System.out.print(">> 성별(F/M) : ");
		member.setGender(sc.nextLine());
		System.out.println("-----------------------------------------------");
		if (members.insertMember(member))
			lc.putMember(member.getId(), member.getPw());
		System.out.println(">> 회원 가입이 완료되었습니다.\n 로그인 후 이용해 주세요.\n");
	}

	public void login() {
		System.out.println("----------- Member only SYSTEM 로그인 -----------");
		System.out.print(">> 아이디 : ");
		String id = sc.nextLine();
		System.out.print(">> 비밀번호 : ");
		String pw = sc.nextLine();
		if (lc.checkMember(id, pw)) {
			System.out.println(">> 로그인에 성공하였습니다.");
			if (id.equals("admin"))
				adminMenu(); // 관리자 아이디로 로그인
			else
				memberMenu(id); // 일반 사용자 로그인
		} else {
			System.out.println(">> 아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		System.out.println("-----------------------------------------------\n");
	}

	public void adminMenu() {
		while (true) {
			System.out.println("----------- Member only SYSTEM 관리자 모드 -----------");
			System.out.println("\t 1. 회원 목록\t\t 2. 로그아웃");
			System.out.println("---------------------------------------------------\n");
			System.out.print(">> 선택 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch (select) {
				case 1:
					printMembers();
					break;
				case 2:
					System.out.println(">> 로그아웃합니다.");
					return;
				default:
					System.out.println(">> 1, 2 중에 하나만 입력해 주세요.");
					break;
			}
		}
	}

	public void printMembers() {
		List<MemberVO> mems = members.selectAllMember();
		if (mems == null || mems.size() < 1) {
			System.out.println(">> 가입된 목록이 없습니다.");
		} else {
			System.out.println("------------------ 회원 목록 ------------------");
			System.out.println("아이디|\t이름|\t이메일|\t\t가입날짜|");
			mems.forEach(
					o -> System.out.println(
							o.getId() + "\t"
									+ o.getName() + "\t"
									+ o.getEmail() + "\t"
									+ new SimpleDateFormat("yyyy년 mm월 dd일").format(o.getJoinDate())));
			System.out.println("---------------------------------------------");
		}
		System.out.println();
	}

	public void memberMenu(String id) {
		while (true) {
			System.out.println("---------- Member only SYSTEM 회원 모드 ----------");
			System.out.println("   1. 내 정보\t 2. 비밀번호 변경\t 3.로그아웃");
			System.out.println("------------------------------------------------");
			System.out.print(">> 선택 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch (select) {
				case 1:
					System.out.println("------------------ 회원 정보 ------------------");
					List<MemberVO> mems = members.selectAllMember();
					for (MemberVO m : mems) {
						if (m.getId().equals(id)) {
							System.out.println("   아이디 : " + m.getId());
							System.out.println("   비밀번호 : " + m.getPw());
							System.out.println("   이름 : " + m.getName());
							System.out.println("   이메일 : " + m.getEmail());
							System.out.println("   사진 : " + m.getPhoto());
							System.out.println("   성별 : " + m.getGender());
							System.out.println("   가입날짜 : "
									+ new SimpleDateFormat("yyyy년 mm월 dd일 hh:mm:ss").format(m.getJoinDate()));
						}
					}
					System.out.println("---------------------------------------------");
					System.out.println();
					break;
				case 2:
					changePw(id);
					break;
				case 3:
					System.out.println(">> 로그아웃합니다.");
					return;
				default:
					System.out.println(">> 1 중에 하나만 입력해 주세요.");
					break;
			}
		}
	}

	public void changePw(String id) {
		List<MemberVO> mems = members.selectAllMember();
		MemberVO member = null;
		for (MemberVO m : mems) {
			if (m.getId().equals(id)) {
				member = m;
			}
		}
		System.out.println(">> 비밀번호를 변경합니다.");
		System.out.print(">> 기존 비밀번호 : ");
		String oldPw = sc.nextLine();
		System.out.print(">> 신규 비밀번호 : ");
		String newPw = sc.nextLine();
		if (member != null && !member.getPw().equals(oldPw)) {
			System.out.println("비밀번호를 확인해 주세요.");
		} else if (member.getPw().equals(newPw)) {
			System.out.println("기존 비밀번호와 같은 번호입니다.");
		} else {
			member.setPw(newPw);
			lc.putMember(id, newPw);
			System.out.println("비밀번호가 변경되었습니다.");
		}
	}
}
