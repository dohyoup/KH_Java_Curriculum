package exam01;

import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		/*
		 * 24시 표기를 12시 표기로 출력으로 변환하는 프로그램
		 *   23시 30분 은 오후 11시 30분 이다.
		 *   00시 15분 은 오전 12시 15분 이다.
		 * 	 12시 20분 은 오후 12시 20분 이다.
		 * 	 11시 59분 은 오전 11시 59분 이다.
		 * 
		 * 시간입력 : 23
		 * 분 입력 : 30
		 * 변환된 시간 : 오후 11시 30분
		 */
		Scanner sc = new Scanner(System.in);
		String ampm = "오전";
		
		
		System.out.print("시간 입력 :");
		int h = sc.nextInt();
		
		System.out.print("분 입력 : ");
		int m = sc.nextInt();
		
		if(h >= 12 && h <= 23) {
			ampm = "오후";
////        h = h != 12 ? h -12 : 12;
			if(h != 12) {
			   h -= 12;
			}
		} else if (h == 00) {
				h += 12;
		}     if (h > 24) {
			   System.out.println("시간을 잘못 입력하였습니다.");
		}       else
			     System.out.printf("변환된 시간 : %s %d시 %d분", ampm, h, m);
	} 
	
//----------------------------------------------------------------------------------------------
	
	// 스위치구문 사용	
//	Scanner sc = new Scanner(System.in);
//	String ampm = "오전";
//	
//	
//	System.out.print("시간 입력 :");
//	int h = sc.nextInt();
//	
//	System.out.print("분 입력 : ");
//	int m = sc.nextInt();
//	//h/12 = 케이스번호임
//	switch(h / 12) {
//	   case 0 :
//		   if(h == 0) {
//			   h = 12; 
//		   }
//		   break;
//	   case 1:
//		   ampm = "오후";
//		   if(h != 12) {
//	          h -= 12;
//		   }
//	}
//		System.out.printf("변환된 시간 : %s %d시 %d분", ampm, h, m);
	 
}
