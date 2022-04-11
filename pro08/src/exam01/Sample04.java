package exam01;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * StringTokenizer -> 분리가된 문자열들을 Token이라고 부른다.
		 * 		-String  클래스에서 제공하는 split()메서드와 유사한 기능을 제공하는 클래스
		 */
		String phone = "010-1234-5678";
		StringTokenizer token = new StringTokenizer(phone, "-");
		System.out.println("토큰 수 : " + token.countTokens());
	//	int iArr[] = new int[token.countTokens()];
	//	int idx = 0;
		//spilt과 다르게 토크나이저는 배열에 따로 저장을하지않고 반복문으로 바로 문자열 나눔을 한다.
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		//	iArr[idx++] = Integer.parseInt(token.nextToken());
		//	System.out.println(Arrays.toString(iArr));
		}
	}

}
