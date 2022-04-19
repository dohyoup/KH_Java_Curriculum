package game;

import java.util.Random;

public class GuessNum {
	private Random rand = new Random();
	private int number;
	private int limitCun = 10;
	/*
	 *  GuessNum 클래스
	 * 		-생성하면 바로 임의의 숫자를 만든다.
	 * 		-생성할 떄 맞출 수 있는 횟수를 제한한다.
	 * 		-임의의 정수값을 전달하면 Up,Down 을 반환한다.
	 * 		-정답을 맞춘 경우 Correct를 반환한다.
	 * 		-횟수를 초과하여 실패한 경우 Fail을 반환한다.
	 */
 
	public GuessNum() {
        this.number = rand.nextInt(100) + 1;
	}
	//내가 최대 범위를 자유롭게 바꾸기위한 생성자
	public GuessNum(int rangeMax) {
        this.number = rand.nextInt(rangeMax) + 1;
	}
	//내가 최대 범위랑 횟수 자유롭게 바꾸기위한 생성자
	public GuessNum(int rangeMax, int count) {
		this.number = rand.nextInt(rangeMax) + 1;
		this.limitCun = count;
		}
	//내가 범위랑 횟수 자유롭게 바꾸기위한 생성자
	public GuessNum(int rangeMin, int rangeMax, int count) {
		this.number = rand.nextInt(rangeMax - rangeMin) + (rangeMin + 1);
		this.limitCun = count;
		}
	
	public Result guessing(int num) {
		Result res = new Fail();
		this.limitCun--;
		if(this.limitCun > 0) {
			if(this.number > num) {
				res = new Up();
			}else if(this.number < num) {
				res = new Down();
			}else if(this.number == num) {
				res = new Correct();
			}
		}else if(this.limitCun == 0) {
			if(this.number == num) {
				res = new Correct();
			}
		}
		return res;
	}
}     


