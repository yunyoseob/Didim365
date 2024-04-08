package basic;

public class TryCatchFinally {

	public static void main(String[] args) {
		String s[]= new String[3];
		try{
			System.out.println(s[4]);
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}finally{
			System.out.println("무조건 마지막에 실행된다.");
		}

	}

}
