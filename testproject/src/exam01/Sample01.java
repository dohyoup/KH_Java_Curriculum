package exam01;

import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor , eng, mth, tot;
		double avg;
		System.out.println("국어 점수를 입력하세요. : ");
		kor = sc.nextInt();
		System.out.println("영어 점수를 입력하세요. : ");
		eng = sc.nextInt();
		System.out.println("수학 점수를 입력하세요. : ");
		mth = sc.nextInt();
		
		tot = kor + eng + mth;
		avg = (kor + eng + mth)/3.0;
		
		if(kor< 40 || eng < 40 || mth < 40) {
			System.out.println("과락된 과목이 있어 불합격 되었습니다.");
		}else{
			System.out.println("축하 합니다. 합격입니다.");
			System.out.printf (" 총점 : %d 점\n", tot);
			System.out.printf (" 국어 : %d 점\n", kor);
			System.out.printf (" 영어 : %d 점\n", eng);
			System.out.printf (" 수학 : %d 점\n", mth);
			System.out.printf (" 평균 : %.1f 점\n", avg);
				if(avg < 60) {
					System.out.println("평균 점수가 미달하였습니다.");
				}
		}
	}

}
