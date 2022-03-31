package exam04;

public class Main {

	public static void main(String[] args) {
		/*
		 * 다형성
		 * 	-객체지향 프로그램의 3대 특징중 하나
		 * 	-하나의 객체가 여러 형태를 가질수 있다는 의미
		 * 	-하나의 객체(부모)를 사용하여 여러 형태의 객체(자식)를 다룰 수 있는 기능 제공
		 * 	-
		 */
		
		/*
		 * 업 캐스팅
		 * 	-상위 객체로 변환하는 것
		 * 	-자식 클래스가 부모 클래스로 변화하는 것
		 *  -부모 타입의 참조변수에 자식 타입의 참조변수를 저장할 수 있다.
		 *  -자동으로 변환이 이루어 진다.
		 * 
		 */
		
		Person s1 = new Student("홍길동", 16);
		Person t1 = new Teacher("홍길동", 16);
		
		System.out.println(s1.getName() + " | " + s1.getAge());
		System.out.println(t1.getName() + " | " + t1.getAge());
		
		Person[] p1 = new Person[3]; // 한객체배열에 여러객체를 담을 수 있음
		p1[0] = new Teacher("김철수", 28);
		p1[1] = new Student("최강민", 16);
		p1[2] = new Teacher("김철수", 28);
		//상위객체 < -----//하위객체 자동 업캐스팅
		
		for(int i = 0; i < p1.length; i++) {
			System.out.println(p1[i].getName() + " | " + p1[i].getAge());
		}
		/*
		 * 다운 캐스팅
		 * 	-하위 객체로 변환하는 것
		 *  -부모 클래스로 업 캐스팅한 객체를 다시 자식 타입으로 변환하는 것
		 *  -부모 타입의 참조변수에 저장된 자식 타입의 참조값을 다시 원래의 자식 타입으로 변환한다.
		 *  -캐스팅 연산자를 사용하여 수동으로 변환시켜 주어야 한다.
		 * 
		 */
		Person s2 = new Student("홍길동", 16);
		Student s3 = (Student)s2; //다운캐스팅
		s3.setClassLevel(1);
		s3.setClassRoom(2);
		
		Person t2 = new Teacher("김철수",28);
		Teacher t3 =((Teacher)t2); // 이렇게 따로 저장해주고 하는게 편하다
		((Teacher)t2).setClassLevel(1);
		t3.setClassRoom(2);
		t3.setSubject("국어");
		
		Person[] p2 = new Person[2];
		p2[0] = s3;  p2[1] = t3;
		
		for(int i = 0; i < p2.length; i++) {
			if(p2[i] instanceof Student) {// 하나의 배열에 학생,선생님 두가지객체가 들어가있기때문에 활용시에 구분을 해주어야한다.
			Student s = (Student) p2[i];
			System.out.println(s.getClassLevel() + "학년" + s.getClassRoom() + "반");
		} else {
			Teacher t = (Teacher) p2[i];
			System.out.println(t.getClassLevel() + "학년" + t.getClassRoom() + "반" + t.getSubject() + "담당 선생님");
		}
 	}
	}
}
