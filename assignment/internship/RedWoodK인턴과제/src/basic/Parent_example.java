package basic;

public class Parent_example {
	// default constructor
	public Parent_example(){
		System.out.println("부모클래스 생성자 생성");
	}
	
	public void parent_method(String s){
		System.out.println("부모클래스에 있는 함수 >>> : ");
		System.out.println("부모클래스에 들어온 String s >>> : "+s);
	}
}
