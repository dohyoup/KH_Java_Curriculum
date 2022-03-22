package exam07;

public class BookOrganization {
	private String name; //도서명
	private String number; //책 시리얼번호
	private int rantDate; // 대출일
	private int returnDate; // 반납일
	private int over; // 연체일
	private int disadvantage; //불이익 대출불가 제한일
	private int money = 5000; // 벌금
	
	

 public BookOrganization() {}
 public BookOrganization(int rantDate, int returnDate) {
	 this.rantDate = rantDate;
	 this.returnDate = returnDate;
 }
 public BookOrganization(String name, String number) {
	 this.name = name;
	 this.number = number;
 }
 public BookOrganization(int over, int disadvantage, int money ) {
	 this.over = over;
	 this.disadvantage = disadvantage;
	 this.money = money;
	 
 }
}