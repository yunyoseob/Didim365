package basic;

public class ForWhlieDoWhile_example {
	public static void main(String args[]){
		int i=1;
		int j;

		do{	
			j=0;
			while(j<i){
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}while(i<5);

		for(int k=5; k>0; k--){
			for(int h=0; h<k; h++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
