package basic;

import java.util.HashMap;

public class HashMap_example {
	public static void main(String args[]){
		HashMap hMap=new HashMap();
		
		hMap.put("���","apple");
		hMap.put("�ٳ���","banana");
		hMap.put("���","melon");
		hMap.put("������","peach");
		
		System.out.println("\n ����� ����� >>>> : "+hMap.get("���"));
        
        System.out.println("\n �ٳ����� ����� >>>> : "+hMap.get("�ٳ���"));
		System.out.println("\n ����� ����� >>>> : "+hMap.get("���"));
		System.out.println("\n �����ƴ� ����� >>>> : "+hMap.get("������"));
	
		hMap.put("���","���ִ�.");
		
		System.out.println("\n Value�� apple���� ���ִ� �Է� �� , ����� >>>> : "+hMap.get("���")+"\n");
	}
}
