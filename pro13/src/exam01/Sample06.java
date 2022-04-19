package exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Sample06 {
	public static void main(String[] args) {
		
		
		
		File f = new File("C:/Users/dohyoup/file_test.txt");
		try {
			FileInputStream fis = new FileInputStream(f);
		
			byte[] buffer = new byte[4]; // 여기서 지정한 크기만큼 읽는것이다 즉 4바이트씩 읽는것
			byte[] bytes = new byte[0];
			while(true) {
				int i = fis.read(buffer); //i값이 정수이면 읽은 바이트데이터 값이 저장된다. 우리는 이 i값을 출력하려는 것이다.
				//얼만큼 읽었는지가 i값에 저장된다.몇바이트 읽었다.
				if(i == -1) {
					break;
				}
				bytes = Arrays.copyOf(bytes, bytes.length + i);
				System.arraycopy(buffer, 0, bytes, bytes.length - i, i);
				
			}
			System.out.print(new String(bytes));
			
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
			
			
