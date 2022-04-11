package exam01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sample05 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력으로 정수값 입력을 받을 때 한번의 입력으로 1개 이상의 정수값을
		 * 받을 수 있도록 한다.(nextLine() 메서드를 사용해야 함)
		 * 
		 * 예)
		 *     정수값 입력 : 10 20 30 40 50
		 *     
		 *     다음의 값을 입력하였습니다.
		 *     10, 20, 30, 40, 50
		 */
//		Scanner sc = new Scanner(System.in);
//		System.out.print("정수값 입력 : ");
//		String input = sc.nextLine();
//		Wrapper, StringTokenizer 활용하여 정수배열에 저장.
//		String phone = input;
//		
//		StringTokenizer token = new StringTokenizer(input, " ");
//		int iArr[] = new int[token.countTokens()];
//		int idx = 0;
//		while(token.hasMoreTokens()) {
//			iArr[idx++] = Integer.parseInt(token.nextToken());
//		}
//		System.out.println("다음의 값을 입력하였습니다.");
//		System.out.println(Arrays.toString(iArr));
//	}
		
		
		/*
		 * Wrapper 클래스
		 * 		-기본 자료형을 객체로 만들어서 객체로 다룰수 있게 해주는 클래스
		 * 		-문자열 값을 기본 자료형으로 변환할 수 있는 기능을 제공
		 * 
		 * Boolean, Byte, Character, Short, Integer, Long, Float, Double 이 Wrapper 클래스이다.
		 * 
		 * byte 소문자는 기본자료형  Byte 대문자는 래퍼 대소문자 구분 정말중요 
		 */
		
		// 문자열을 기본 자료형으로 변경(Wrapper 사용)
		boolean bool = Boolean.parseBoolean("true");
		byte b1 = Byte.parseByte("100");
		short s1 = Short.parseShort("100");
		char c1 = "문자열".charAt(0);
		char[] cArr = "문자열".toCharArray();
		int i1 = Integer.parseInt("100");
		long l1 = Long.parseLong("100");
		float f1 = Float.parseFloat("100");
		double d1 = Double.parseDouble("100");

		// 기본 자료형을 문자열로 변경
		String s3;
		s3 = Boolean.valueOf(true).toString();
		s3 = Byte.valueOf((byte)100).toString();
		s3 = Short.valueOf((short)100).toString();
		s3 = Character.valueOf('a').toString();
		s3 = Integer.valueOf(100).toString();
		s3 = Long.valueOf(100).toString();
		s3 = Float.valueOf(100.0f).toString();
		s3 = Double.valueOf(100.0).toString();
	
		s3= ""+ 100 + 10.0 + 'c';
	}
}


