package basic;

public class Child_example extends Parent_example{

	public static void main(String[] args) {
		Parent_example prnt=new Child_example();
		String child_str="자식클래스";
		prnt.parent_method(child_str);
	}
}
