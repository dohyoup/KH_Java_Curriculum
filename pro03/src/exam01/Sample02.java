package exam01;

public class Sample02 {

	public static void main(String[] args) {

		//감소 시키면서 반복
			for(int i = 99; i > 0; i--) {
				System.out.println(i);
			}
			
			for(char c = 'A'; c <= 'Z'; c++) {
				System.out.printf("%c <-> %d\n", c, (int)c);
			}
			
			for(char c = 'a'; c <= 'z'; c++) {
				System.out.printf("%c <-> %d\n", c, (int)c);
			}
	}

}
