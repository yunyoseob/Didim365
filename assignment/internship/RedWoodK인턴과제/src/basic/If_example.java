package basic;

public class If_example {
	public static void main(String args[]){
	    int a=1;
	    int b=1;
	    int c=2;
	    boolean b1;
	    boolean b2;
	    boolean b3;
	    
	    b1 = a==1;
	    b2 = a==b;
	    b3 = a==c;
	    
	    System.out.println(b1);
	    System.out.println(b2);
	    System.out.println(b3);
	    
	    
	    if(a==1){
	    	System.out.println("a==1 true");
	    }
	    if(a==b){
	    	System.out.println("a==b true");
	    }
	    if(a==c){
	    	System.out.println("a==c false");
	    }
	}
}
