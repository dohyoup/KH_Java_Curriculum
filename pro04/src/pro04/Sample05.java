package pro04;

import java.util.Arrays;
import java.util.Scanner;

public class Sample05 {

	public static void main(String[] args) {

		/*
		 * 카이사르 암호 만들기.
		 * 	-사용자 입력으로 영단어를 입력 받는다.
		 *  -입력받은 영단어는 문자 배열로 생성한다.
		 *  -생선된 문자 배열에 대해 암호화된 배열을 저장하기 위한 배열을 새로 만든다.
		 *  -문자 쉬프트는 3으로 하고 만약 'z' 문자에 대한 쉬프트가 필요한 경우 'a' 로 넘어가게 해야 한다.
		 *  
		 *  
		 * 출력형식
		 * 	암호화 전 : apple
		 * 	암호화 후 : dssoh
		 */
		Scanner sc = new Scanner(System.in);
//		System.out.println("알파벳을 입력해주세요.");
//		char ch = sc.nextLine().charAt(0);
//		int num = (int)ch;
//		System.out.println(num);
		//Scanner sc = new Scanner(System.in);
		System.out.print("영단어 입력 : ");
		String eng = sc.nextLine();
		
//		char[] origin = new char[eng.length()]; // 소괄호 사용하면 메서드
//		for(int i = 0; i < eng.length(); i++) {
//			origin[i] = eng.charAt(i);
//		}
		
		char[] origin = eng.toCharArray();
		
		
		
		char[] crypto = new char[origin.length]; // 소괄호 사용안하면 속성
		for(int i = 0; i < origin.length; i++) {
			if(origin[i]+3 >'z') {
				crypto[i] = (char)(origin[i]+3-26);
			}else {
				crypto[i] = (char)(origin[i]+3);
			}
		}
		
		String res1 = new String(origin);
		String res2 = new String(crypto);
		
		
//		for(int i = 0; i<eng.length(); i++) {
//			res1 += origin[i];
//			res2 += crypto[i];
//		}
			System.out.println("암호화 전 : " + res1);
			System.out.println("암호화 후 : " + res2);
			//			if((int)eng.charAt(i)>67) {
//				System.out.print("암호화 후 : "+(char)((int)eng.charAt(i)+3));
//			}else if((char)eng.charAt(i)> 'z'){
//				System.out.println((char)(eng.charAt(i)-26));
//			}
//		}
		
	}

}
