package basic;

public class Ifelse_example {
	public static void main(String[] args) {
		int a=1;
		int b=2;
		
		boolean b1;
		boolean b2;
		boolean b3;
		
		b1= a>b;
		b2= a==b;
		b3= a<b;
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		if (a>b){
			System.out.println("a>b입니다.");
		}else if(a==b){
			System.out.println("a==b입니다.");
		}else{
			System.out.println("a>b가 아닙니다.");
		}

	}
}
