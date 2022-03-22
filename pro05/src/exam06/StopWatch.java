package exam06;

public class StopWatch { //시 / 분 / 초 단위 구현
  private int hour;   
  private int min;
  private int sec;

  public void setHour(int h) { //setter
	  hour = h;   //간접적으로 은닉된 정보(멤버변수)에 접근시키기 위해 만들어 주는 접근 메서드
  }
  public int getHour() { // getter
	  return hour;
  }
  
  public void start() {}
  public void stop() {}
  public void pause() {}
  public void reset( ) {}
}
