package test;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		// pro04 - Sample08해당
		/* 사용자가 입력한 영문자열에 서 입력된 문자의 수를 구하는 코드를 작성
		 *  1. 영문자를 제외한 다른 문자는 무시한다.
		 * 	2. 영문자의 대/소문자를 구분하지 않고 문자 수를 구한다.
		 * 
		 * 
		 * 
		 * 예제
		 * 		영문자 입력 : hello java programming
		 * 
		 * 
		 * 
		 * 		입력한 영문자 분포
		 * 		a(3), e(1), g(2), h(1), i(1)
		 * 		j(1), l(2), m(2), n(1), o(2)
		 * 		p(1), r(2), v(1)
		 */
		for(char c = 'A'; c<= 'Z'; c++) {
			System.out.printf("%c <-> %d\n",c, (int)c);
		}
		
		Scanner sc = new Scanner(System.in);
			System.out.println("영문자 입력 : ");
			String input = sc.nextLine();
			
			int[] cArr = new int[26]; // 측정하고자 하는 배열의 크기가 정해져있다. 알파벳 갯수 26자
									// 알파벳 사용 횟수를 저장하기 위한 배열
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if((c <= 'A' && c <= 'Z') || (c >= 'a' && c<= 'z')) {
				cArr[c % 32 - 1] += 1;
			}        // 아스키코드 규칙인데 각문자의 아스키코드를 32로나눈 나머지값은 모두~~모두!! 1이나온다 그래서 거기에서 -1을해주면 0으로 보정댐
			if((c <= 'A' && c <= 'Z')) {
				cArr[c-'A'] += 1 ; // c-'A' 는 사용자 입력알파벳에서 A의 아스키코드값을 빼줘소 보정을해주고 
									//	문제가 사용 알파벳 사용횟수를 구하는거니 += 1로 횟수를 누적시켜서 세게한다.
			
			}else if ((c >= 'a' && c<= 'z')) {
				cArr[c - 'a'] += 1;
				// 'A' 아스키코드값이 65인가 그런데 만약 사용자가 A를 입력하면 배열에서 0값을 맞춰줘야해서 -A를 해줘서 65-65=0으로 보정해주는것
				//알바벳 아스키코드 감이 안잡히면 스위치문으로 노가다해야하는데 그냥 아스키코드 연습해라.
						//참고로 소문자 a값은 97이다.
						
			}
		}
		
	}

}
