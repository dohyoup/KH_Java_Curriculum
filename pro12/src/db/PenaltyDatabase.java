package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class PenaltyDatabase {

	public void add(String input) {
		File file = new File("C:/Users/dohyoup/penalty.db");
		
		try (FileWriter fw = new FileWriter(file, true)) {
			fw.write(input + "\n");
			fw.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String load() {//파일읽기
		File file = new File("C:/Users/dohyoup/penalty.db");
		
		if(file.exists()) {//파일 읽기전에 존재하는 파일인지 먼저 확인
			
		try (FileReader fr = new FileReader(file)) {
			StringBuilder sb = new StringBuilder();
			char[] buff = new char[1024];
			while(true) {
				int size = fr.read(buff);
				if(size == -1) {
					break;
				}
				sb.append(buff, 0, size);
			}
		}catch (FileNotFoundException e) {
			 e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	  }
		
		return "";	
	}

	public void modify(int number, String input) {
		File file = new File("C:/Users/dohyoup/penalty.db");
		
		if(file.exists()) {//파일 읽기전에 존재하는 파일인지 먼저 확인
			
			try (FileReader fr = new FileReader(file)) {
				StringBuilder sb = new StringBuilder();
				char[] buff = new char[1024];
				while(true) {
					int size = fr.read(buff);
					if(size == -1) {
						break;
					}
					sb.append(buff, 0, size);
				}
				String[] data = sb.toString().split("\n");
				data[number - 1] = input;
				
				try (FileWriter fw = new FileWriter(file)) {
					for(int i = 0; i < data.length; i++) {
						fw.write(data[i] + "\n");
					}
					fw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}catch (FileNotFoundException e) {
				 e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
	  }
	}

	public void remove(int number, String input) {
		File file = new File("C:/Users/dohyoup/penalty.db");
		
		if(file.exists()) {//파일 읽기전에 존재하는 파일인지 먼저 확인
			
			try (FileReader fr = new FileReader(file)) {
				StringBuilder sb = new StringBuilder();
				char[] buff = new char[1024];
				while(true) {
					int size = fr.read(buff);
					if(size == -1) {
						break;
					}
					sb.append(buff, 0, size);
				}
				String[] data = sb.toString().split("\n");
				
				
				number -= 1;
				String[] temp = Arrays.copyOf(data, data.length - 1); // 여기서 부터 삭제작업
				System.arraycopy(data, 0, temp, 0, number);
				System.arraycopy(data, number + 1, temp, number, temp.length - number);
				data = temp;                                          //여기까지 삭제작업
				
				try (FileWriter fw = new FileWriter(file)) {
					for(int i = 0; i < data.length; i++) {
						fw.write(data[i] + "\n");
					}
					fw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}catch (FileNotFoundException e) {
				 e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
	  }
	}
}
