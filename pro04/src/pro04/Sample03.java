package pro04;

public class Sample03 {

	public static void main(String[] args) {
		//문자열 배열
		String[] arr1 = new String[3];
		arr1[0] = "문자열"; arr1[1] = "배열"; arr1[2] = "사용";
		
		for(int i=0; i < 3; i++) {
			System.out.println(arr1[i] + "");
		}
		
		
		
		String[] arr2 = {"문자열" , " 배열", " 생성"};
		
		for(int i = 0; i < 3; i++) {
			System.out.print(arr2[i] + "");
		}
		System.out.println("\n");
		
		String[] arr3 = new String[3];
		
		for(int i = 0; i < 3; i++) {
			System.out.print(arr3[i] + "\t");
			
			//System.out.println(arr3[i].length());
			
		}
		System.out.println("\n");
	}

}
