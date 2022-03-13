package exam01;

import java.util.Scanner;

public class Sample10 {

	public static void main(String[] args) {

		/*
		 * 2. 사용자가 입력한 영단어에서 'a', 'e', 'i', 'o', 'u' 문자의
		 * 수를 구해 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		String input = sc.nextLine();
		int cnt = 0;
		for(int i = 0; i < input.length(); i++ ) {
			if(input.charAt(i) == 'a') {
				cnt++;
			}else if (input.charAt(i) == 'e') {
				cnt++;
			}else if (input.charAt(i) == 'i') {
				cnt++;
			}else if (input.charAt(i) == 'o') {
				cnt++;
			}else if (input.charAt(i) == 'u') {
				cnt++;
			}
		}
		System.out.printf("'a', 'e', 'i', 'o', 'u' 문자가 총 %d 개 있습니다.", cnt);
	}

}
