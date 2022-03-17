package exam02.pack1;
//import exam02.pack1.*; // *은 이 페키지 안에 있는 모든 클래스를 지칭
import exam02.pack1.PublicAccessTest;
import exam02.pack1.DefaultAccessTest;


public class Sample02 {

	public static void main(String[] args) {
		PublicAccessTest p = new PublicAccessTest();
		DefaultAccessTest d = new DefaultAccessTest();
//다른 패키지에서는 퍼블릭은 가능하지만 디폴트는 접근 불가
	}

}
