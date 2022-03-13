package exam01;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		double rate, won, doller;
		int menu;
		Scanner sc = new Scanner(System.in);
		System.out.println("원달러 환율 값 입력 : ");
		rate = sc.nextDouble();
		String m; String result ="";
		
		
		System.out.println("달러를 원화로 계산하시겠습니까? 아니면 원화를 달러로 계산하겠습니까?");
		System.out.print("(1:달러->원화, 2:원화->달러) -> ");
		menu = sc.nextInt();
		
		m = menu == 1 ? "달러" : "원화";
		System.out.print(m + "값 입력 : ");
		won = sc.nextDouble();
		
		
		if(menu == 1) {//달러를 원화로 변환
			doller = won * rate;
			result = "%,.0f 달러는 %,.0f 원 입니다.";
		}else {
			doller = won / rate;
			result = "%,.0f 원은 약 %,.2f 달러 입니다.";
		}
		System.out.printf(result, won, doller);
	}

}
