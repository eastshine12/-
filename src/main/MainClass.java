package main;

import java.util.Scanner;

import controller.Controller;


public class MainClass {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Controller con = new Controller();
		
		while(true) {
			System.out.println("--------사원 관리 프로그램---------");
			System.out.println("1. 등록");
			System.out.println("2. 삭제");
			System.out.println("3. 수정");
			System.out.println("4. 검색");
			System.out.println("5. 전체출력");
			System.out.println("6. 종료");
			System.out.print(">>");
			int select = sc.nextInt();
			
			switch(select) {
			
			case 1 :
				con.addMember();
				break;
			case 2 :
				con.deleteMember();
				break;
			case 3 :
				con.updateMember();
				break;
			case 4 :
				con.searchMember();
				break;
			case 5 :
				con.allMember();
				break;
			case 6 :
				System.exit(0);
				break;
			default :
				System.out.println("숫자 1 ~ 6을 눌러주세요.");
				break;
			}
			
			
		}
		

	}

}
