package basic;

public class Operator_example {
	public static void main(String args[]){
		int x=0;
		boolean b;
		char c;
		
		System.out.println(x);
		
		// ���� ������
		x++;
		System.out.println(x);
		
		// ���迬����
		b= x==1;
		System.out.println(b);
		
		// ���� ������
		c = (x==1)? 'T':'F';
		System.out.println(c);
		
		// �� �� ������
		b= x==1&&x<0;
		System.out.println(b);
		
		// �� �� ������
		b= x==1||x<0;
		System.out.println(b);
	}
}
