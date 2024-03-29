package exam03;

import java.util.Arrays;

public class PersonList {
	private Person[] pList;
	
	public void add(Person person) {
		this.pList = Arrays.copyOf(this.pList, this.length() + 1);
		this.pList[this.length() - 1] = person;
	}
	public void addFirst(Person person ) {
		Person[] temp = new Person[this.length() + 1];
		System.arraycopy(this.pList, 0, temp, 1, this.length());
		this.pList = temp;
		this.pList[0] = person;
	}

	public void remove(int index) {
		Person[] temp = new Person[this.length() - 1];
		int idx = 0;
		for(int i = 0; i < this.length(); i++) {
			if(i != index) {
			temp[idx++] = this.pList[i];
			}
		}
		this.pList = temp;
	}
	
	public void remove(String name) {
		this.remove(this.findIndex(name));
	}
	
	public PersonList( ) {
		this.pList = new Person[0];
	}
	
	public PersonList(Person[] data) {
		this.pList = data;
	}
	
	public Person get(int index) {
		return pList[index];
	}
	
	public int findIndex(String name) {
		for(int i = 0; i < this.pList.length; i++) {
			Person p = this.pList[i];
			if(p.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean existsName (String name) {
	/*	for(int i = 0; i < this.pList.length; i++) {
			Person p = this.pList[i];
			if(p.getName().equals(name)) {
				return true;
			}
		}
		return false;
	*/	
	if(this.findIndex(name) == -1) {
		return false;
	}else {// 결과가 false면 if문은 종료되기떼문에 else는 굳이 안적어도된다.
	    return true;
		}
	}
	
	
	public int length() {
		return this.pList.length;
	}
	
	
	
	
}

