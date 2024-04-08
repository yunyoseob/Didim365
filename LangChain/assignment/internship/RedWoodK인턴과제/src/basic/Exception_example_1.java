package basic;

public class Exception_example_1{

	public static void main(String args[]){
		try{
			throw new Exception_example("사용자 예외 처리입니다.");
		}catch(Exception_example e){
			System.out.println("error >>> : "+e.getMessage());
		}
	}
}
