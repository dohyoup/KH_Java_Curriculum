package exam01;

import java.util.Random;

public class Sample12 {

	public static void main(String[] args) {
		/*
		 * 임의의 값(난수,랜덤값)을 생성하기 위해 사용하는 모듈 
		 * 	import java.util.Random;
		 */
		Random random = new Random();
		
		for(int i = 0; i<=10; i++) {
		int num = random.nextInt(10); // 0~9 사이의 난수값 생성
		System.out.println(num);
		}
		
		System.out.println("--------------------");
		
		for(int i = 0; i < 10; i++) {
			int num = random.nextInt(9)+1;
			System.out.println(num);
		}
		
		// 'A'~'z' 사이의 임의의 문자 생성 // 강의 한번더 봐라
		char start = 'A' , end = 'Z';
		for(int i = 0; i < 10; i++) {
			char c = (char)(random.nextInt(end-start+1) + start);
			System.out.println(c);
		}
		
		// 12자의 시리올 넘버를 생성하시오. (시리얼 넘버는 'A'~'z' 사이의 문자로만 이루어져 있는 것으로 한다.)
		String serial = "";
		start = 'A';  
		end = 'Z';
		for(int i = 0; i < 10; i++) {
			char c = (char)(random.nextInt(end-start+1) + start);
			serial += c;
		}
		System.out.println(serial);
	}
	

}
