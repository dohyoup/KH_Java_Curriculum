package exam01;

public class Parent {
	private int number = 10;
	private int s = 10;
	public Parent(int number) {//생성자는 상속이안된다.
		this.number = number; //매개변수가 있는 생성자를 만들면 더이상 기본생성자를 만들어 주지 않기때문에
	}//자식 쪽에도 만들어주지 않는다.
	
	public int getNumber() { //겟 셋 = 요청하면 해주겠다.
		System.out.println("부모의 getNumber 메서드 시작");
		System.out.println("부모의 getNumber 메서드 끝");
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;// 허락맞는 과정 프리베이트 변수 쓰겠다고
	}
}
