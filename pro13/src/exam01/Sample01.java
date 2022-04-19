package exam01;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 입출력(IOM Input/Output)
		 * 		-컴퓨터 내부/외부 장치간에 데이터를 주고받는 것 
		 * 		-프로그램을 기준으로 내부/외부 장치에서 데이터가 현재 동작하는 프로그램으로 들어오면 입력
		 * 		 현재 동작하는 프로그램이 내부/외부 장치로 데이터를 보내면 출력
		 * 
		 * 
		 * 스트림(Stream)
		 * 	- 입력스트림, 출력스트림으로 나누어서 부른다.
		 *  - 두 장치간에 데이터를 지속적으로 입/출력하기 위해 생성된 연결 통로
		 *  - 단방향 통신을 지원하기 때문에 입력/출력을 동시에 핧 수 없다.
		 *    동시에 하기 위해서 입력스트림, 출력스트림을 개별적으로 만든다.
		 *  - 스트림을 통해 데이터를 입/출력 할 떄 문자기반스트림과 바이트기반스트림
		 * 	  으로 분류한다. 
		 * 	- 문자기반스트림의 경우 일반 텍스트 문서를 입/출력하기 위해 사용(보통 txt 확장자를 가지는 파일)
		 * 	- 바이트기반스트림의 경우 일반 텍스트 문서를 제외한 모든 파일을 입/출력하기 위해 사용
		 * 	  (영상, 음향, 이미지, 각종 실행파일 등...)
		 * 	  무얼기반으로할지 헤깔리면 입/출력하고자하는 파일에 대해서 연결프로그램에 우클릭 메모장클릭해서 
		 * 	  읽을 수 있는 문자의 내용이 나오면 문자기반으로 하면되고 아니면 바이트기반으로한다.
		 */
		
		 /*
		  * File 클래스 
		  * 	- 파일의 크기, 이름, 정보 등을 알아내기 위한 클래스로 사용 
		  * 	- 파일 생성, 삭제 및 폴더 생성 삭제 기능을 제공
		  */
		File f = new File("C:/Users/dohyoup/eclipse/jee-2022-03/eclipse/eclipse.ini");
		// 역슬래쉬는 그냥 슬래쉬로 바꿔준다.
		
//		System.out.println(f.length()); // 기본적으론 바이트크기
//		System.out.println(f.length() / 1024.0); // = 키로바이트 계산
//		System.out.printf("파일 크기 : %d Byte\n", f.length()); // 기본적으론 바이트크기
//		System.out.printf("파일 크기 : %.2f KByte\n", f.length()); // = 키로바이트 계산
//		System.out.printf("수정 날짜 : %d\n" , f.lastModified());
		
	//	GregorianCalender g = new GregorianCalender(); 
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		String strDate = sFormat.format(new Date(f.lastModified()));// lastModified를 사용하면 파일의 마지막 수정 날짜를 얻을 수 있다.
		System.out.printf("수정 날짜 : %s\n",  strDate);
		
		System.out.printf("실행 파일 : %s\n" , f.canExecute());
		System.out.printf("읽기 가능 : %s\n" , f.canRead());
		System.out.printf("쓰기 가능 : %s\n" , f.canWrite());
		
		System.out.printf("파일 : %s\n", f.isFile());
		System.out.printf("폴더 : %s\n", f.isDirectory());
		System.out.printf("숨김 : %s\n", f.isHidden());
		
		System.out.printf("파일/폴더명 : %s\n", f.getName());
		System.out.printf("상위 폴더명 : %s\n", f.getParent());
		System.out.printf("전체 경로명 : %s\n", f.getPath());
		
		System.out.printf("실제 존재하는 파일/폴더 유무 : %s\n", f.exists());//어지간하면 가장먼저 확인할것
		
		File f2 = new File("C:/Users/dohyoup/eclipse/jee-2022-03/eclipse/my_file.wav");
		try {
			f2.createNewFile();
		} catch (IOException e) {
			System.out.println("my_file.txt 파일 생성문 에러 발생!");
			e.printStackTrace();
		}
		
		File f3 = new File("C:/Users/dohyoup/eclipse/jee-2022-03/eclipse/my_forder");
		f3.mkdir();
		
		File f4 = new File("C:/Users/dohyoup/eclipse/jee-2022-03/eclipse/my_file.wav");
		f4.delete();
		
		File f5 = new File("C:/Users/dohyoup/eclipse/jee-2022-03/eclipse");
		String[] strFiles = f5.list(); //폴더안의 모든 정보를 파일명 폴더명만 문자열로 저장하느냐
		File[] fFiles = f5.listFiles();//폴더안의 모든 정보를 파일 객체로 저장하느냐 
		
		System.out.println(Arrays.toString(strFiles));
		System.out.println(Arrays.toString(fFiles));
		
		for(int i = 0; i < fFiles.length; i++) {
			String name = fFiles[i].getName();
			if(name.startsWith("my_")) {//스타트위드 내가지정한 문자열로 시작하는걸 확인하는 메소드
				System.out.println(fFiles[i].getPath() + " 파일을 삭제하였습니다.");
				fFiles[i].delete();
					
			}
		}
	}

}

