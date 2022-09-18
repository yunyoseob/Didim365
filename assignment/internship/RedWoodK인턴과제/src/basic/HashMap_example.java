package basic;

import java.util.HashMap;

public class HashMap_example {
	public static void main(String args[]){
		HashMap hMap=new HashMap();
		
		hMap.put("사과","apple");
		hMap.put("바나나","banana");
		hMap.put("멜론","melon");
		hMap.put("복숭아","peach");
		
		System.out.println("\n 사과는 영어로 >>>> : "+hMap.get("사과"));
        
        System.out.println("\n 바나나는 영어로 >>>> : "+hMap.get("바나나"));
		System.out.println("\n 멜론은 영어로 >>>> : "+hMap.get("멜론"));
		System.out.println("\n 복숭아는 영어로 >>>> : "+hMap.get("복숭아"));
	
		hMap.put("사과","맛있다.");
		
		System.out.println("\n Value로 apple에서 맛있다 입력 후 , 사과는 >>>> : "+hMap.get("사과")+"\n");
	}
}
