package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Sample05 {

	public static void main(String[] args) {
		File f = new File("C:/Users/dohyoup/file_test.txt");
		
		try (FileWriter fw = new FileWriter(f, true)) {//f를 true =무한반복시키겠다.
			
			fw.write(65);
			
			char[] cArr = new char[] {66, 67, 68, 69};
			fw.write(cArr);
			
			fw.write("\nFileOutputStream\n");
			
			fw.write("한글 쓰기"); //get바이트는 바이트형식으로 바꿔서 입력하겠다는의미로 사용한것
			
			fw.flush(); //버퍼에 남아있는거 다써버려라 비워라 플러쉬는 마지막에 항상해준다. 입력시에
			}catch (FileNotFoundException e) { 
				System.out.println("해당 파일을 찾지 못하였습니다.");
				e.printStackTrace();
			}catch (IOException e) {
				System.out.println("파일 쓰기 작업중 문제가 발생하였스빈다.");
				e.printStackTrace();
			}
		
}
	}


