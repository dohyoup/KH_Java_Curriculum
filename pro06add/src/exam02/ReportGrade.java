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
		int len =  this.subjects.length;
		this.subjects = Arrays.copyOf(this.subjects, len + 1);
		this.grades = Arrays.copyOf(this.grades, len + 1);
		
		this.subjects[len] = subject;
		this.grades[len] = grade;
	}
	
	
	private int _findIndex(String subject) {
		int idx = 0;
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