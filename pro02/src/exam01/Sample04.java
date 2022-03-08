package exam01;
import java.util.Scanner;
public class Sample04 {

	public static void main(String[] args) {
		/*환률 계산 프로그램
		 * 		원달러 환율 값 입력 : 1235.00
		 * 
		 *  	달러값 입력 :100
		 * 		100 달러는 123500 원 입니다.
		 * 
		 * 		원화값 입력 : 100000
		 * 		100000 원은 약 80.97 달러 입니다.
		 */
//------------------------------------------------------------------------------------------		
//		double num1, num2, num3;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("원달러 환율 값 입력 : ");
//		num1 = sc.nextDouble();
//				
//		System.out.println("달러값 입력 : ");
//		num2 = sc.nextDouble();
//		System.out.println(num2 + "달러는" + num1*num2 + " 원 입니다.");
//		
//		System.out.println("원화값 입력 : ");
//		num3 = sc.nextDouble();
//		System.out.println(num3 + "원은 약" + num3/num1 + "입니다.");
	//--------------------------------------------------------------------------------------
//		
//		double rate, doller;
//		int menu, won;
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("원달러 환율 값 입력 :");
//		rate = sc.nextDouble();
//		
//		System.out.println("달러를 원화로 계산하겠습니까? 아니면 원화를 달러로 계산하겠습니까?");
//		System.out.print("(1:달러 ->원화, 2:원화->달러) -> ");// 이런식으로 메뉴 형식의 로직을 짜서 구성하면 한결 깔끔해진다.
//		menu = sc.nextInt();
//		
//		if(menu == 1 ) {//달러를 원화로 변환
//			System.out.println("달러값 입력 : ");
//			doller = sc.nextInt();
//			won = (int)(doller*rate);
//			System.out.printf("%,d 달러는 %,d 원 입니다.",(int)doller,won);//서식에 쉼표있으면 천단위 마다 찍힘
//		}else if(menu==2) { // 원화를 달러로 변환
//			System.out.println("원화값 입력 : ");
//			won = sc.nextInt();
//			doller = won/rate;
//			System.out.printf("%,d 원은 약 %,.2f 달러 입니다.",won,doller);
//		}
			
	//----------------------------------------------------------------------------------------	
		double rate, sMoney, dMoney;
		int menu;
		String mStr, result;
		//else if 문으로 할시엔 선언시 초기화도 시켜줘야한다.
		//String mStr  String result = ""; (둘다 초기화해도된다.)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("원달러 환율 값 입력 :");
		rate = sc.nextDouble();
		
		System.out.println("달러를 원화로 계산하겠습니까? 아니면 원화를 달러로 계산하겠습니까?");
		System.out.print("(1:달러 ->원화, 2:원화->달러) -> ");// 이런식으로 메뉴 형식의 로직을 짜서 구성하면 한결 깔끔해진다.
		menu = sc.nextInt();
	
		mStr = menu == 1 ? "달러" : "원화";
		System.out.println(mStr + "값 입력 : ");
		sMoney = sc.nextDouble();
		
		
		if(menu == 1 ) {//달러를 원화로 변환
			dMoney = sMoney*rate;
			result = "%,.0f 달러는 %,.0f 원 입니다.";
		} else { // 원화를 달러로 변환
			dMoney = sMoney / rate;
			result = "%,.0f 원은 약 %,.2f 달러 입니다.";
		}
		
		System.out.printf(result, sMoney, dMoney);
		//String.format()과 printf는 문법이 유사하나 포멧은 저장하고 후에 프린트로 다시해야하고 프린트에프는 저장 출력을 동시에한다.
		
	}
	
	

}
