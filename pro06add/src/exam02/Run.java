package exam02;

import javax.sql.rowset.serial.SQLOutputImpl;

public class Run {

	public static void main(String[] args) {
		ReportGrade report = new ReportGrade();
		String[] subjects = new String[] {
				"국어", "영어", "수학", "과학"
		};
		System.out.println(report.getName("홍길동"));
		double[] grades = new double[] 
				{80, 75.5, 68, 90};
		
		report.setSubjects(subjects);
		report.setGrades(grades);//report에 setGrades(grades)값을 저장=설정해라
		
		report.setGrades("영어",88.5);
		report.add("사회", 80);
		String[] s = report.getSubjects();
		double[] g = report.getGrades();
		
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i] + ": " + g[i] + " 점");
			
		//	report.add("사회", 80);
			
			
		}
	}

}
