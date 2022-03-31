package exam02;

import java.util.Arrays;

public class ReportGrade {
	private String name;
	private String[] subjects;
	private double[] grades;
	
	public void ReportGrade(String name) {
		this.name = name;
	}
	
	public void ReportGrade(String name, String[] subjects ) {
		this.name = name;
		this.subjects = subjects;
	}
	
	
	
	
	public String getName(String name) {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	
	

	public double[] getGrades(double[] grades) {
		
		return grades;
	}
	
	public double[] getGrades() {
		return grades;
	}

	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	public void setGrades(String subject, double grade) {
		int idx = this._findIndex(subject);
		this.grades[idx] = grade;
	}
	public double getGrades(String subject) {
		int idx = this._findIndex(subject);
		return this.grades[idx]; // 어떤과목에 대한 점수인지에대한 반환
	}
	
	public void add(String subject, double grade) {
		int len =  this.subjects.length; // 이때 len은 인덱스 번호다 헤깔리지 말자
		this.subjects = Arrays.copyOf(this.subjects, len + 1);
		this.grades = Arrays.copyOf(this.grades, len + 1);
		this.subjects[len] = subject;
		this.grades[len] = grade;
	}
	public void remove(String subject) {
		//기본 배열에 저장되어 있는 과목 정보와 점수 정보를 삭제.
		//인덱스의 범위를 벗어나는 경우. "해당과목이 존재하지 않습니다." 출력
		int index = this._findIndex(subject); //검색한 과목의 인덱스 값을 저장
		if(index == -1) { // 만약 존재하지 않는 과목(-1)값일 경우
			System.out.println("해당 과목이 존재하지 않습니다.");//출력
		}else {//존재하는 과목일경우
		this.remove(index);//입력한 인덱스번호의 과목을 삭제해라
	}
	}	
	
	
	public void remove(int index) {
		if(index < 0 && index >= this.subjects.length) {
			System.out.println("인덱스 범위를 벗어났습니다.");
			return;
			//인덱스의 범위는 0부터 배열의 길이-1 까지이다. 
			//그러니 0보다 작아도 안되고 길이랑 같거나 커서도 안된다.
		}
		
		String[] temp1 = new String[this.subjects.length - 1];
		double[] temp2 = new double[this.grades.length - 1];
		int idx = 0;
		for(int i = 0; i < this.subjects.length; i++) {
			if(idx != i) {
				temp1[idx] = this.subjects[i];
				temp2[idx] = this.grades[i];
				idx++;
			}
		}
		this.subjects = temp1;
		this.grades = temp2;
	}
	
	private int _findIndex(String subject) {
		int idx = -1;
		for(int i = 0; i < this.subjects.length; i++) {
			String s = this.subjects[i];
			if(subject.equals(s)) {
			idx = i;
			break;
		   }
		
	    }
		return idx;
	}

}