package basic;

public class Operator_example {
	public static void main(String args[]){
		int x=0;
		boolean b;
		char c;
		
		System.out.println(x);
		
		// 증감 연산자
		x++;
		System.out.println(x);
		
		// 관계연산자
		b= x==1;
		System.out.println(b);
		
		// 삼항 연산자
		c = (x==1)? 'T':'F';
		System.out.println(c);
		
		// 논리 곱 연산자
		b= x==1&&x<0;
		System.out.println(b);
		
		// 논리 합 연산자
		b= x==1||x<0;
		System.out.println(b);
	}
}
