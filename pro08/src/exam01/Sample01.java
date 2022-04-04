package exam01;

import java.util.Arrays;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * String 생성자
		 */
		String s1 = new String();
		String s2 = new String("생성자");
		
		char[] cArr = new char[] {'A','B','C','D'};
		String s3 = new String(cArr);
		
		byte[] bArr = new byte[] {65, 66, 67, 68};
		String s4 = new String(bArr);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		/*
		 * String 관련 메서드
		 */
		// 문자열 같은지 비교
		String s5, s6;
		s5 = new String("동일문자열비교");
		s6 = new String("동일문자열비교");
		
		boolean isEqual = s5.equals(s6);
		System.out.println("s5.equals(s6) -> " + isEqual);
		//문자열 길이출력
		int len = s5.length();
		System.out.println("s5.length() ->" + len);
		
		//해당 인덱스번호에 있는 문자 출력
		for(int i = 0; i < s5.length(); i++) {
		char c1 = s5.charAt(i);
		System.out.printf("s5.length(%d) -> %c\n", i, c1); 
		}
		//지정한 문자열을 포함하고 있는지 트로, 폴스로 확인
		boolean isContains;
		s5 = "Java Programming Language";
		isContains = s5.contains("Program");
		System.out.println("s5.contains(\"Program\") ->"  + isContains);
		
		isContains = s5.contains("Program");
		System.out.println("s5.contains(\"Program\") ->"  + isContains);
		
		//지정한 문자열이 처음등장하는 인덱스번호 출력
		int location;
		location = s5.indexOf("Program");
		System.out.println("s5.indexOf(\"Program\") -> "  + location);
		
		//지정한 문자열과 원하는 문자열로 교체
		s5 = s5.replace("Program", "프로그렘");
		System.out.println("s5.replace(\"Program\", \"프로그램\") - > " + s5);
		
		s5 = s5.replace("Java", "자바");
		System.out.println("s5.replace(\"Java\", \"자바\") - > " + s5);
		//스플릿 : 공백을 기준으로 분리시켜주고 반환은 문자열배열로 반환시켜준다.
		String[] sArr;
		sArr = s5.split(" ");
		System.out.println("s5.split(\" \") - > " + Arrays.toString(sArr));
		
		s5 = String.join("_", sArr); // 문자열배열을 다시 언더바기준으로 합쳐줌
		System.out.println("String.join(\"_\", sArr) - > " + s5);
		
		s5 = "    앞/뒤로 공백이 존재하는 문자열    ";
		System.out.println(s5);
		
		s5 = s5.trim();// 공백매꿔주기
		System.out.println("s5.trim() -> " + s5);
		
		s5 = "Strong Methods"; //소문자 대문자 구분
		System.out.println("s5.toUpperCase() -> " + s5.toUpperCase());
		System.out.println("s5.toUpperCase() -> " + s5.toLowerCase());
		
		//원하는 위치 잘라주는기능
		System.out.println("s5.substring(3.6) -> " + s5.substring(3,6));
		System.out.println("s5.substring(7.11) -> " + s5.substring(7,11));
		
		s6 ="Meth";
		System.out.println("s5.substring(7.11) -> " + s5.substring(s5.indexOf(s6), s5.indexOf(s6) + s6.length()));
		
		//System.out.printf)"포멧형식이 있는 문자열", 포멧형식에사용할값...) 이랑 같은것
		s6 = String.format("%d / %s %.1f", 10, "포멧문자열", 10.123);
		System.out.println(s6);
		
		//전화번호 형식과같은것들이 있다고 가정했을때 지정한 변수가 그 형식에 메치가되는지 알아볼수 있게 도와주는 메서드/ 매치가되면 트루값이나오고 다르면 펄스가 출력된다.
		s6 = "010-1234-5678";
		boolean isMatch = s6.matches("\\d{3}-\\d{4}-\\d{4}");
		System.out.println("전화번호 형식과 일치합니까? ->" + isMatch);

}
}
//자바에서 문자열에 사용하는 \(역슬래쉬)는 어디에 사용되나? -> 이스케이프 문자에 사용.
//정규표현식 -> \d로 표기한다. 그런데 이렇게 그냥써버리면 자바에서는 정규표현삭이아니라 이스케이프문자로 인식하게때문에 역슬레시를 두개써서 \d로 인식하게끔 만들어 준다.
//\d는 숫자를 나따낸다. \d{3}이라하면 숫자가 3자  \d{4}라 하면 숫자가 4자 라는 의미이다.