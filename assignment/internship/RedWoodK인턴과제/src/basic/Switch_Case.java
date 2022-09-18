package basic;

public class Switch_Case {
	public static void main(String[] args) {
		char medalColor;
		
		int rank=1;
		
		switch(rank){
			case 1: medalColor ='G';
				System.out.println("medalColor >>> : "+medalColor);
		       	break;
		    case 2: medalColor='S';
		    	System.out.println("medalColor >>> : "+medalColor);
		       	break;
		    case 3: medalColor='B';
		    	System.out.println("medalColor >>> : "+medalColor);
		       	break;
		    case 4: medalColor='A';
		    	System.out.println("medalColor >>> : "+medalColor);
		    	break;
		    default : medalColor ='A';
		    	System.out.println("medalColor >>> : "+medalColor);
		 }
	}
}
