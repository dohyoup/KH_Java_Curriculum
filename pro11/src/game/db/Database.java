package game.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import game.player.UserPlayer;
import game.record.Record;

public class Database {
	UserPlayer tot = new UserPlayer();
	private File file;
	
	public Database() {
		this.file = new File("C:/Users/dohyoup/data_write");
	}
	
	public Database(File file) {
		this.file = file;
	}
	
	public int[] load() {
		// 파일을 읽고 배열로 반환
		try (FileReader fr = new FileReader(file)) {
			char[] buff = new char[16];
			char[] data = new char[0];
			
			while(true) {
				int rSize = fr.read(buff);
				
				if(rSize == -1) {
					break;
				}
				
				data = Arrays.copyOf(data, data.length + rSize);
				System.arraycopy(buff, 0, data, data.length - rSize, rSize);
			}
				StringTokenizer st = new StringTokenizer(new String(data), " ");
				int[] iArr2 = new int[st.countTokens()];
				int i = 0;
				
			while(st.hasMoreTokens()) {
				iArr2[i++] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(Arrays.toString(iArr2));
			
          				
			} catch (FileNotFoundException e) {
				System.out.println("해당 파일이 존재하지 않습니다.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
				e.printStackTrace();
			}
		return null;
	}
	
	
	public void save(int[] record) {
		// 정수 배열을 파일로 저장
	}
}
