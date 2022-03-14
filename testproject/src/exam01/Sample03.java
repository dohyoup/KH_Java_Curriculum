package exam01;

import java.util.Scanner;
import java.util.Random;


public class Sample03 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사용자 이름을 입력하세요. : ");
		String name ="";
		name =sc.nextLine();
		
		while(true) {
			System.out.println("컴퓨터와 가위바위보를 시작합니다.");
			int num = (int)(Math.random()*3)+1;
			System.out.print("1. 가위\n2. 바위\n3. 보\n: ");	
			int num2 = sc.nextInt();
			
			if((num==1)&&(num2==1)||(num==2)&&(num2==2)||(num==3)&&(num2==3)) {
				System.out.println("비겼습니다.");
				System.out.println("게임을 다시 시작합니다.");
				continue;
			}else if((num==1)&&(num2==2)||(num==2)&&(num2==3)||(num==3)&&(num2==1)){
				System.out.println("이겼습니다.");
				System.out.println("게임을 다시 시작합니다.");
				break;
			}else if((num==1)&&(num2==3)||(num==2)&&(num2==1)||(num==3)&&(num2==2)) {
				System.out.println("졌습니다.");
				System.out.println("게임을 다시 시작합니다.");
				break;
			}else {
				System.out.println("입력오류");
				continue;
			}
				
			
		}	
		String str1 ="";
		String str2 = "exit";
		if(str2.equals(str1)) {
			str1 = sc.nextLine();
			 System.out.println("게임이 종료됩니다.");
			 } 	
				
	}
}
