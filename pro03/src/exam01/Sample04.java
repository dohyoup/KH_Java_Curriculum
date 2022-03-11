package exam01;

import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
//엑시티드 플레이그 하나도 이해못했음
Scanner sc = new Scanner(System.in);
int menu;

boolean exited = false;

for(int i = 0; i<3; i++) {	
		System.out.println("다음에 나열된 메뉴중 하나의 번호를 선택하시오.");
		System.out.print("1. 조회\n2. 추가\n3. 수정\n4. 삭제\n9. 종료\n : ");
		menu = sc.nextInt();
		
			switch(menu) {
			case 1:
				System.out.println("조회 메뉴를 선택했습니다.");
				exited = true;
				break;
			case 2:
				System.out.println("추가 메뉴를 선택했습니다.");
				exited = true;
				break;
			case 3:
				System.out.println("수정 메뉴를 선택했습니다.");
				exited = true;
				break;
			case 4:
				System.out.println("삭제 메뉴를 선택했습니다.");
				exited = true;
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				exited = true;
				break;
			default:
					System.out.println("잘못된 메뉴 번호입니다.");
		    }
			if(exited) {
				break;
		}
		
  
      }

	}
	

}

	
  

