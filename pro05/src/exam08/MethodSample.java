package exam08;

public class MethodSample {
	
	public int num1; //인스턴스 변수 = 멤버 변수
	public static int num2; // 클래스 변수 = 정적 변수 = 정적 멤버 변수(필드)
	
	public void method01() {
		System.out.println("일반(인스턴스) 메서드 실행됨");
	}
	public static void method02() {
		System.out.println("static(정적/클래스) 메서드 실행됨");
		
	}
	public int method03() { //반환타입은 int void String 등등 다 사용가능
		return 0;
	}
	public int[] method04() {
		int[] result = new int[3];
		
		return result;
	}
	public String method05() {
		String result = new String();
		
		return null; // 스트링과같은 클래스 기본타입은 null로도 리턴 시킬 수 있다. result써도되고 필요에따라 null도 사용.
	}
	
	public int[] method06(int[] arr) {
		System.out.println(arr);
		arr[0] = 10;
		return arr;
	}
	public void method07(int ... nums) {// ... 가변인자 표기방법 //가변은 항상마지막에 둬라
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	
	
	
}
