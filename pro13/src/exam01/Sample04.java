package exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * FileReader
		 * 	- 문자 기반 스트림으로 문자 단위로 파일을 읽는다.
		 * 	- 보통 텍스트 파일을 읽기 위해 사용
		 */
		File f = new File("C:/Users/dohyoup/file_test.txt");
		try {
			FileReader fis = new FileReader(f);
			/*
			while(true) {
				int i = fis.read(); //i값이 정수이면 읽은 바이트데이터 값이 저장된다. 우리는 이 i값을 출력하려는 것이다.
				if(i == -1) {
					break;
				}
				System.out.print((char)i);
			}
			*/
			char[] buffer = new char[4]; // 여기서 지정한 크기만큼 읽는것이다 즉 4바이트씩 읽는것
			char[] chars = new char[0];
			while(true) {
				int i = fis.read(buffer); //i값이 정수이면 읽은 바이트데이터 값이 저장된다. 우리는 이 i값을 출력하려는 것이다.
				//얼만큼 읽었는지가 i값에 저장된다.몇바이트 읽었다.
				if(i == -1) {
					break;
				}
				chars= Arrays.copyOf(chars, chars.length + i);
				System.arraycopy(buffer, 0, chars, chars.length - i, i);
			}
			System.out.print(new String(chars));
			
			fis.close(); //파일읽기 끝나면 반드시 close를 해줘야한다. 안하면 메모리 누수의 원인이 됌.
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("해당 팡닐을 읽는 과정에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}
		
		

	}


