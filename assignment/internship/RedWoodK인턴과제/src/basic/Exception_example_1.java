package basic;

public class Exception_example_1{

	public static void main(String args[]){
		try{
			throw new Exception_example("����� ���� ó���Դϴ�.");
		}catch(Exception_example e){
			System.out.println("error >>> : "+e.getMessage());
		}
	}
}
