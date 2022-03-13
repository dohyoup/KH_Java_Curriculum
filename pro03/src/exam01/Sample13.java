package exam01;

import java.util.Random;
import java.util.Scanner;
public class Sample13 {

	public static void main(String[] args) {
		/*
		 * 12자의 시리올 넘버를 생성하시오. (시리얼 넘버는 'A'~'z' 사이의 문자로만 이루어져 있는 것으로 한다.)
		 * 사용자 입력을 통해 생성할 시리얼 넘버의 수량을 파악하고 해당 수만큼 출력한다.
		 * 그리고 시리얼 번호의 출력 형상은 다음과 같다.
		 *  "LFLH-BQJN-XCUG"
		 */
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("필요 수량 입력 : ");
		String serial = "";
		int num = sc.nextInt();
		char start = 'A' , end = 'Z';
		
		for(int j = 1; j <= num; j++) {
		  for(int i = 0; i < 12; i++) {
			 char c = (char)(random.nextInt(end-start+1) + start);
			 serial += c;
			 if(i % 4 == 3 && i != 11) {
				 serial += "-";
			 }
		    }
		  System.out.println(serial);
		  serial = ""; // 이거 모르겠음
		}		
		
	}

}
