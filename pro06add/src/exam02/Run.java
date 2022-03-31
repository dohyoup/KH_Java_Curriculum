package exam02;

import java.util.Arrays;

import javax.sql.rowset.serial.SQLOutputImpl;

public class Run {

	public static void main(String[] args) {
		ReportGrade report = new ReportGrade();
		String[] subjects = new String[] {
				"국어", "영어", "수학", "과학"
		};
		double[] grades = new double[] 
				{80, 75.5, 68, 90};
		
		report.setSubjects(subjects);
		report.setGrades(grades);//report에 setGrades(grades)값을 저장=설정해라
		
		report.setGrades("영어",88.5);

		String[] s = report.getSubjects();
		double[] g = report.getGrades();
		
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i] + ": " + g[i] + " 점");
		}	
		//	report.add("사회", 80);
			System.out.println(report.getGrades("국어"));
			System.out.println(report.getGrades("수학"));
			System.out.println(report.getGrades("영어"));
			System.out.println(report.getGrades("과학"));

			report.add("사회",80.2);
			System.out.println(report.getGrades("사회"));
	//	report.add("사회",85.4);
	//		System.out.println(report.getGrades("사회"));
			
			//remove
			System.out.println(Arrays.toString(report.getSubjects()));
			report.remove(1);
			System.out.println(Arrays.toString(report.getSubjects()));
			report.remove("과학");
			System.out.println(Arrays.toString(report.getSubjects()));
	}

}
