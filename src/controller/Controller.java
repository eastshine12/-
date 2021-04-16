package controller;

import java.util.List;
import java.util.Scanner;

import dao.MemberDao;
import dto.MemberDto;

public class Controller {
	
	
	Scanner sc = new Scanner(System.in);
	MemberDao dao = MemberDao.getInstance();
	
	
	public void addMember() {
		
		System.out.println("1. 사원 등록");
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("생년월일 : ");
		String birth = sc.next();
		System.out.print("전화번호 : ");
		String phoneNum = sc.next();
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		System.out.print("부서이름 : ");
		String deptID = sc.next();
		
		MemberDto dto = new MemberDto(name, age, birth, phoneNum, salary, deptID);
		boolean b = dao.addMember(dto);
		if(b) {
			System.out.println("사원 등록 완료");
		} else {
			System.out.println("사원 등록 실패");
		}
		
	}
	
	
	public void deleteMember() {
		
		System.out.println("2. 사원 삭제");
		System.out.print("삭제할 사원의 사원번호 : ");
		int empID = sc.nextInt();
		
		boolean b = dao.deleteMember(empID);
		if(b) {
			System.out.println("사원 삭제 완료");
		} else {
			System.out.println("사원 삭제 실패");
		}
		
	}
	
	
	public void updateMember() {
		
		System.out.println("3. 사원 정보 수정");
		System.out.print("수정할 사원의 사원번호 : ");
		int empID = sc.nextInt();
		MemberDto dto = dao.getMember(empID);
		System.out.println("수정할 사항");
		System.out.println("1. 이름");
		System.out.println("2. 나이");
		System.out.println("3. 생년월일");
		System.out.println("4. 전화번호");
		System.out.println("5. 급여");
		System.out.println("6. 부서이름");
		System.out.print(">>");
		int select = sc.nextInt();
		switch(select) {
		case 1 :
			System.out.println("수정할 이름");
			System.out.print(">>");
			dto.setName(sc.next());
			break;
		case 2 :
			System.out.println("수정할 나이");
			System.out.print(">>");
			dto.setAge(sc.nextInt());
			break;
		case 3 :
			System.out.println("수정할 생년월일");
			System.out.print(">>");
			dto.setBirth(sc.next());
			break;
		case 4 :
			System.out.println("수정할 전화번호");
			System.out.print(">>");
			dto.setPhoneNum(sc.next());
			break;
		case 5 :
			System.out.println("수정할 급여");
			System.out.print(">>");
			dto.setSalary(sc.nextInt());
			break;
		case 6 :
			System.out.println("수정할 부서이름");
			System.out.print(">>");
			dto.setDeptID(sc.next());
			break;
		}
		
		boolean b = dao.updateMember(dto);
		if(b) {
			System.out.println("사원 수정 완료");
		} else {
			System.out.println("사원 수정 실패");
		}
		
		
	}
	
	
	public void searchMember() {
		System.out.println("4. 사원 정보 검색");
		System.out.print("검색할 사원의 사원번호 : ");
		int empID = sc.nextInt();
		MemberDto dto = dao.getMember(empID);
		System.out.println(dto.toString());
	}
	
	
	
	public void allMember() {
		System.out.println("5. 모든 사원 정보");
		List<MemberDto> list = dao.getAllMember();
		
		for (MemberDto dto : list) {
			System.out.println(dto.toString());
		}
	}
	

}
