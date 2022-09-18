package basic;

public class Array_example {
	public static void main(String args[]){
		try {
		    int[] arr =new int[] {1,2};
		    System.out.println(arr[0]);
		    System.out.println(arr[1]);
		    // System.out.println(arr[2]);
		    
		    int[][] arr2=new int[][] {{1,2},{3,4}};
		    System.out.println(arr2[0][0]);
		    // 1
		    System.out.println(arr2[0][1]);
		    // 2
		    System.out.println(arr2[1][0]);
		    // 3
		    System.out.println(arr2[1][1]);
		    // 4
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}
	}
}
