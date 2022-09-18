## day4-Java 문법 

작성일 2022.07.14

작성자 윤요섭 인턴

## day4과제

<hr>

java 언어의 기본문법에 대해 보고서를 제출하세요.
참고: 프로그래밍 기초 문법(제어문, 배열, 연산자 등),  예외처리(사용자예외 포함), 클래스, 상속(OverLoading/Overriding 포함), 추상클래스, 인터페이스

## java 기본 문법

### 1. java의 예약어와 객체지향 프로그래밍 소개

<hr>

**✔ [Java Language Keywords](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html) **

<img src="/image/javalanguagekeywods.PNG" alt="no-image">

Java 키워드 예약어는 기능이 있는 영어 단어로 : 자바 엔진에서 읽어서 일을 시키는 명령어이다.

```
pacakge
import
class
public 
static
new 
void 
byte
char
short
int 
long
float
double
if
else
for
while
do
break
```

Java는 java.lang.Object 클래스가 루트이면서 모든 클래스에게 상속 되어 있다.

- [객체 지향 프로그래밍이란?](https://jslee-tech.tistory.com/28)

Java는 미리 만들어진 프로그램 또는 클래스를 가지고 새로운 프로그램 또는 클래스를 만드는 것이다.

- 미리 만들어진 클래스 : 빌트인 클래스
- 사용자 정의 클래스는 빌트인 클래스를 가지고 만든다.
- java.lang.Object 클래스를 상속해서 만든다.

Java 프로그램을 구성하는 최소 단위는 클래스로 클래스는 변수와 함수로 이루어져 있다.

**✔ 클래스**

클래스는 자바 프로그램의 최소 단위이다.

Class 종류

```	
일반 클래스 
		class 사용자정의클래스이름 {}
	-----------------
	추상 클래스
		abstract class 사용자정의클래스이름 {}
	인터페이스 클래스 
		interface 사용자정의클래스이름 {}
	파이널 클래스 
		final class 사용자정의클래스이름 {}
	익명 클래스 
	어뎁터 클래스 
	인너 클래스 
	중첩 클래스 
	-----------------
```

클래스는 접근 제한자에 따라 사용 범위가 다르다.

Access Modifier

```
public : 다른 패키지에 있는 클래스 및 클래스 자원(변수, 메서드)을 사용할 수 있다.

protected : potected가 붙은 변수, 메서드는 동일 패키지의 클래스 또는 해당 클래스를 상속받은 다른 패키지의 클래스에서만 접근이 가능하다.

default(package) : 같은 패키지에 있는 클래스 및 클래스 자원(변수, 메서드)을 사용할 수 있다.

private : 클래스 안에 있는 클래스 및 클래스 자원(변수, 메서드)을 사용할 수 있다.

```

**✔ 변수**

자바의 변수는 크게 기초자료형 변수와 참조 자료형 변수로 나눌 수 있다.

기초 자료형 변수는 자바에서 사용하는 도구 중 유일하게 객체가 아니며, 래퍼 클래스(Wrapper Class)의 상수로 존재한다.

- 기초 자료형 변수는 크게 숫자, 문자, 논리로 나눌 수 있으며, 숫자는 byte, short, int, long 변수가 있고, 실수에는 float, double 변수가 있다. 문자에는 char 변수가 있으며, 논리에는 boolean 변수가 있다. 

- 참조 자료형 변수는 기초 자료형을 제외한 모든 것이라고 할 수 있다.


클래스에서 클래스에게 상속을 할 수 있다.

클래스에서 상속 관계를 가지면

```
부모 클래스, 자식 클래스가 성립된다.
상속을 해주는 클래스를 부모 클래스라고 하고
상속을 받는 클래스를 자식 클래스라고 부른다.
```

한편, 변수는 선언 위치에 따라 멤버 변수와 지역변수로도 나눌 수 있다.

```
	멤버변수 : Fields
		클래스 블럭 안 과 함수 블럭 외부 사이에 선언하는 변수 
			상수 : Constatnt Variable
				public static final 데이터타입(자료형) 변수명 = 값;
			클래스 변수 : class Variable, static Variable 			
				[pubilc] static 데이터타입(자료형) 변수명 = 값;
				[public] static 데이터타입(자료형) 변수명;
			전역 변수 : Grobal Varialbe
				public 데이터타입(자료형) 변수명;
			멤버 변수 : member Varialbe
				데이터타입(자료형) 변수명;
	지역변수 : local variable 
		함수 블럭 안에서 선언하는 변수 
		1. 함수 블럭에서 태어나서 함수 블럭에서 죽는다.
		2. 함수 블럭 밖으로는 나갈 수 없다.
		3. 지역 변수를 사용할 때는 항시 초기화가 되어 있어야 한다.
			데이터타입(자료형) 변수명 = 값;
			데이터타입(자료형) 변수명;
			변수명 = 값;
```

**👩‍💻 실습 코드**

```java
package basic;

public class Hello_Java {

	public static void main(String[] args) {
		System.out.println("Hello Java");
	}
}

// 출력 결과 : Hello Java
```

Hello_Java 프로그램을 편집기에서 만들면 해당 클래스를 컴파일한 뒤, java 명령어로 실행합니다.

**👨‍🏫 코드 설명**

```
package : 자바 디렉토리 또는 클래스 파일을 모아두는 곳이다.
package 구분자는 . (도트 연산자)를 사용한다.
클래스에 package를 사용하면 항시 패키지 컴파일 및 패키지+클래스임으로 실행 시켜야 한다.

static : 프로그램이 시작할 때 생성되고, 자바 버철머신(JVM)이 static 키워드가 붙어 있는 해당 자원을 메모리에 올려주는 것을 요청한다. 

void : 리턴형이 없는 함수에 붙이는 키워드

main : Java로 구현된 프로그램이 시작될 때 가장 먼저 실행되는 메서드

{} : Java는 블록언어이므로, 클래스, 함수, if문 등에 블록을 지정할 때 사용한다.
```

### 2. java의 기초 문법 : 연산자

연산자의 종류는 크게 증감 연산자와 삼항 연산자, 논리 연산자, 관계 연산자가 있습니다.

**✔ 증감 연산자**

```java
++x
// x를 먼저 1 증가 시킨 후 그 값을 사용
--x
// x를 먼저 1 감소 시킨 후 그 값을 사용
x++
// x 값을 먼저 사용한 후 1 증가
x--
// x 값을 먼저 사용한 후 1 감소
```
**✔ 삼항 연산자**

```
사용방법
조건식 ? 결과 1 : 결과 2

true면 결과 1
false면 결과 2
```

**✔ 논리 연산자**

[참고자료 : 비트 연산](https://ko.wikipedia.org/wiki/%EB%B9%84%ED%8A%B8_%EC%97%B0%EC%82%B0)

```
논리 곱(&&) 연산

T AND T -> T
T AND F -> F
F AND T -> F
F AND F -> F

논리 합(&&) 연산

T OR T -> T
T OR F -> T
F OR T -> T
F OR F -> F
```

**✔ 관계 연산자**

두 값의 관계를 비교하는 연산자

```
> , <, >=, <=, ==, !=
```

**👩‍💻 실습 코드**

```java
package basic;

public class Operator_example {
	public static void main(String args[]){
		int x=0;
		boolean b;
		char c;
		
		System.out.println(x);
        // 출력 결과 : 0
		
		// 증감 연산자
		x++;
		System.out.println(x);
        // 출력 결과 : 1
		
		// 관계연산자
		b= x==1;
		System.out.println(b);
        // 출력 결과 : true
		
		// 삼항 연산자
		c = (x==1)? 'T':'F';
		System.out.println(c);
        // 출력 결과 : T
		
		// 논리 곱 연산자
		b= x==1&&x<0;
		System.out.println(b);
        // 출력 결과 : false
		
		// 논리 합 연산자
		b= x==1||x<0;
		System.out.println(b);
        // 출력 결과 : true
	}
}
```

### 3. java의 기초 문법 :제어 흐름 이해하기(Flow Control)

<hr>

**✔ 조건문**

if문과 if-else 문

if문은 조건 분기문으로 if 절에는 참인 경우 실행이 된다.

else절에는 if 절의 참의 반대인 거짓일 때 실행된다.

if  절은 () 소괄호에 사용하는 표현식의 결과가 참(true)인 경우만 수행된다.

**👩‍💻 실습 코드**

```java
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


/*
 * 출력 결과
 * true
 * true
 * false
 * a==1 true
 * a==b true
*/
```

**👨‍🏫 코드 설명**

```
변수 a,b는 1이고, c는 2입니다.

출력 결과를 본다면, a==1이 true이므로 a==1 true가 출력되는 것을 볼 수 있습니다.

마찬가지로, a==b가 true이므로 a==b true가 출력되는 것을 볼 수 있습니다.

그러나, a==c는 false이므로, if문에 있는 내용이 출력되지 않는 것을 볼 수 있습니다.
```

추가적으로 if-else 문으로 if문이 true가 아닐 때, else문으로 출력시킬 수도 있습니다.

**👩‍💻 실습 코드**

```java
package basic;

public class Ifelse_example {
	public static void main(String[] args) {
		int a=1;
		int b=2;
		
		boolean b1;
		boolean b2;
		boolean b3;
		
		b1= a>b;
		b2= a==b;
		b3= a<b;
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		if (a>b){
			System.out.println("a>b입니다.");
		}else if(a==b){
			System.out.println("a==b입니다.");
		}else{
			System.out.println("a>b가 아닙니다.");
		}

	}

}


/*
 * 출력 결과
 * 
 *  false
 *  false
 *   true
 *   a>b가 아닙니다.
 * 
*/
```

출력 결과를 보면, if문이 false이고 else if문도 false여서 else문에 있는 내용이 출력된 것을 확인할 수 있습니다.

조건문을 구현할 때, if문이 너무 많아 번거로울 경우, switch-case문을 사용할 수도 있습니다.

**👩‍💻 switch-case문 실습 코드**

```java
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

/*
 출력 결과 : medalColor >>> : G
*/
```

- break는 실행을 중단할 때 쓰는 키워드 입니다. (반대로 continue는 반복문을 이어나갈 때 쓰는 키워드입니다.)

**✔ 반복문**

반복되는 일을 처리하기 위해 사용하는 것이 반복문입니다.

반복문에는 for문, while문, do while문이 있습니다.

for문의 경우, 다음과 같이 구성되어 있습니다.

```java
for(초기화식; 조건식; 증감식){
    수행문;
}
```

초기화식에서 작성한 식이 조건식을 만족한다면, 수행문이 이루어지고, 증감식에 의해 변수가 증감합니다.

while문의 경우, 다음과 같이 구성되어 있습니다.

```java
while(조건식){
    수행문;
}
```

조건식이 true일 경우, 수행문이 수행되고 false일 경우, 수행문이 실행되지 않습니다.

do while문은 while의 조건식이 될 때까지 수행됩니다. (do while문의 경우 최소 한 번은 실행되어야 합니다.)

```java
do{
    수행문;
}while(조건식)
```

**👩‍💻 실습 코드**

```java
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

/*

 출력 결과
*
**
***
****
*****
****
***
**
*

*/
```

각 반복문이 실행되면서 *가 출력되는 것을 확인 할 수 있습니다.

### 4. java의 기초 문법 : 예외처리문

<hr>

java에서 예외가 생길 경우, try-catch문으로 예외를 처리할 수 있습니다.

java에서 Trowable클래스의 하위클래스인 Exception 클래스는 예외처리의 최상위 클래스입니다.

java에서 오류는 크게 컴파일하는 과정에서의 오류와 java 실행시 오류가 있습니다. 

|구분|	Checked Exception	|Unchecked Exception|
|:--:|:--:|:--:|
|처리 여부|	반드시 예외를 처리해야 함	|명시적인 처리를 강제하지 않음|
|확인 시점|	컴파일 단계	|실행 단계|
|예외발생시 트랜잭션 처리|	roll-back 하지 않음	|roll-back 함|
|대표 예외|	Exception 클래스를 상속받은 하위클래스 중 Runtime Exception을 제외한 모든 예외 클래스 (IOException, SQLException)|	RuntimeException 하위 예외 클래스 (NullPointerException, IllegalArgumentException, IndexOutOfBoundException, SystemException)|

**✔ try ~ catch ~ finally 구문 구성**

```java
try{
    수행문;
}catch(Exception 참조변수){
    예외시 수행문;
}finally{
    마지막에 수행되는 수행문;
}
```
**👩‍💻 실습 코드**

```java
package basic;

public class TryCatchFinally {

	public static void main(String[] args) {
		String s[]= new String[3];
		try{
			System.out.println(s[4]);
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
            // error >>> : 4
		}finally{
			System.out.println("무조건 마지막에 실행된다.");
            // 무조건 마지막에 실행된다.
		}

	}

}
```

try문 수행시 에러가 발생하여 catch문에 있는 수행문이 실행되었고,
finally문이 마지막으로 수행되었습니다.

**✔ 사용자 예외 처리문**

사용자가 예외를 따로 지정하여 처리 할 수 있습니다.

**👩‍💻 실습 코드**

```java
package basic;

public class Exception_example extends Exception{
	public Exception_example(String message){
		super(message);
	}
}
```

```java
package basic;

public class Exception_example_1{

	public static void main(String args[]){
		try{
			throw new Exception_example("사용자 예외 처리입니다.");
		}catch(Exception_example e){
			System.out.println("error >>> : "+e.getMessage());
            // error >>> : 사용자 예외 처리입니다.
		}
	}
}
```

### 5. java의 기초 문법 : 배열과 HashMap

<hr>

**✔ 배열**

Java에서 배열은 크게 정적 배열과 동적 배열이 있습니다.

정적 배열은 배열의 크기와 타입을 정해놓고 사용하며, 동적 배열의 경우 배열에 들어간 값에 따라 크기와 타입이 결정됩니다.

**✔ 정적 배열**

정적 배열의 경우 다음과 같은 특징이 있습니다.

```
1. 자바에서 배열은 같은 데이터형(타입)을 순차적으로 나열해 놓은 것이다.
2. 자바에서 배열은 데이터 형이 같아야 한다.
3. 자바에서 배열은 배열의 갯수를 정해 놓고 사용한다.
4. 자바에서 배열은 객체이다.(참조 자료형이다.)
5. 자바에서 배열은 1차원 배열, 2차원 배열(다차원 배열을 지원한다.)
6. 자바에서 배열의 연산자는 [] 대괄호이다.
```

**✔ 1차원 배열 3가지 출력 방법**

```java
데이터형 참조변수[] 배열 연산자 = new 데이터형 [배열이 들어갈 공간] 배열연산자;
데이터형 참조변수[] = new 데이터형[]{};
데이터형 참조변수[] = {};
```

**✔ 2차원 배열 출력 방법**

```java
자료형 배열참조변수[][] = new 자료형[배열의 갯수][배열의 갯수];
자료형[][] 배열참조변수 = new 자료형[배열의 갯수][배열의 갯수];
자료형[] 배열참조변수[] = new 자료형[배열의 갯수][배열의 갯수];
```

**👩‍💻 실습 코드**

```java
package basic;

public class Array_example {
	public static void main(String args[]){
		try {
		    int[] arr =new int[] {1,2};
		    System.out.println(arr[0]);
            // 1
		    System.out.println(arr[1]);
            // 2
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
            // System.out.println(arr[2]); 주석을 해제하면
            // error >>> : 2
		}
	}
}
```

**🤔 System.out.println(arr[2]); 실행시 error가 발생하는 이유?**

java에서 배열은 인덱스가 0부터 시작합니다. 위에 코드는 0번째 인덱스에 1이라는 값이 들어갔고, 1번재 인덱스는 2라는 값이 들어갔습니다. 따라서, 2번째 인덱스에 있는 값을 출력시켰을 때, 2번째 인덱스는 없기 때문에 에러가 발생하였습니다.

**✔ 동적 배열**

동적배열의 경우 크기와 데이터 타입을 따로 정해놓지 않고, 데이터를 입력한 다음, 출력할 수 있습니다.

**👩‍💻 실습 코드**

```java
package basic;

import java.util.ArrayList;

public class ArrayList_example {

	public static void main(String[] args) {
		ArrayList lArr=new ArrayList();
		lArr.add(1);
		lArr.add(2);
		lArr.add("삼");
		lArr.add(1.0);
		lArr.add(false);
		lArr.add('c');
		lArr.add(1234l);
		lArr.add(1.000f);
		lArr.add(2.000d);
		
		for (int l=0; l<lArr.size(); l++) {
			System.out.print(lArr.get(l)+", ");
            // 1, 2, 삼, 1.0, false, c, 1234, 1.0, 2.0, 
		}

	}
}
```

Array의 경우 배열의 크기를 사전에 정해놓고 사전에 정의해놓은 배열의 크기 규칙에 맞춰 사용해야 하지만, ArrayList는 초기에 10개로 세팅해놓은 다음, 값이 추가되면 10개씩 배열의 크기를 늘려줍니다.

**✔ HashMap**

HashMap은 Key와 Value로 구성되어 있습니다. 

<img src="/image/HashMap.PNG" alt="no-image">

Key와 Value는 한 쌍입니다. Key를 통해서 Key에 해당하는 Value를 출력하므로, Key는 해당 프로그램에서 항상 유니크해야 합니다.
- 동일한 Key에 Value를 다른 것으로 또 입력할 경우, 마지막에 저장된 Value가 나오게 됩니다. 

**👩‍💻 실습 코드**

```java
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
        // 사과는 영어로 >>>> : apple
        
        System.out.println("\n 바나나는 영어로 >>>> : "+hMap.get("바나나"));
        //  바나나는 영어로 >>>> : banana

		System.out.println("\n 멜론은 영어로 >>>> : "+hMap.get("멜론"));
        //  멜론은 영어로 >>>> : melon

		System.out.println("\n 복숭아는 영어로 >>>> : "+hMap.get("복숭아"));
        //  복숭아는 영어로 >>>> : peach
	
		hMap.put("사과","맛있다.");
		
		System.out.println("\n Value로 apple에서 맛있다 입력 후 , 사과는 >>>> : "+hMap.get("사과")+"\n");
        //  Value로 apple에서 맛있다 입력 후 , 사과는 >>>> : 맛있다.
	}
}
```

Key에 해당하는 값이 출력되며, "사과"라는 키의 경우 "맛있다"라는 Value를 마지막에 입력했으므로, 마지막에 "맛있다"라는 Value가 나옵니다.

### 6. java의 기초 문법 : 상속과 인터페이스

<hr>

**생성자**

java에서 클래스를 사용하려면 생성자를 만들어서 해당 자원을 사용합니다.

생성자 규칙은 다음과 같습니다.

1. 생성자는 클래스 이름에 () 소괄호를 붙이고 {}을 가지고 있는 함수이다.
2. 생성자는 클래스를 메모리에 올릴 때, 해당 객체에 있는 해당 객체에 있는 멤버 변수를 초기화 한다.
3. 생성자는 일반 함수의 오버로딩처럼 생성자 오버로딩을 할 수 있다.
4. 생성자 안에서 사용하는 this, super 키워드, this(), super() 함수를 사용할 수 있다.
- this 키워드, this() 함수는 자기자신 클래스에서 사용한다. super 키워드, super() 함수는 상속 관계에서 부모 클래스에 있는 자원 및 생성자를 호출 할 때 사용한다.
5. 생성자를 호출할 때는 매개변수가 같은 것을 호출해야 한다.
6. Default Constructor : 소스 코드에 매개 변수가 없는 생성자를 구현 하지 않으면 JVM이 만들어 주는 기본 생성자
- 클래스에 생성자가 두 개 이상 제공되는 경우를 생성자 오버로드(constructor overload)라고 합니다.
- 이름이 같은 함수의 매개변수만 다른 경우는 메소드 오버로드(method overload)라고 합니다.

**✔ 상속**

java는 객체 지향 프로그래밍입니다. java는 미리 만들어진 프로그램 또는 클래스를 가지고, 새로운 프로그램 또는 클래스를 만듭니다.

이 때, JAVA에서 빌트인 클래스(미리 만들어진 프로그램 또는 클래스)의 최고 우두머리는 java.lang.Object 클래스로, 사용자 정의 클래스는 java.lang.Object 클래스를 상속하여 만듭니다.

<img src="/image/직계혈연의_호칭.jpg" alt="no-image">

인간사회에서는 상속은 부모가 자식에게 넘겨주는 것을 의미합니다.

JAVA와 같은 객체 지향 언어에서 상속의 개념은 인간사회와 비슷하지만, 차이는 자식은 부모의 재산을 다 사용할 수 있습니다. (단, 부모가 자식에서 상속을 해주면 부모는 자식의 재산을 부모 맘대로 사용할 수 없습니다.)

객체지향에서 상속을 하는 이유는 부모의 자원을 자식이 사용하기 위함입니다.

상속은  ```extends``` 키워드를 사용하여 부모의 클래스를 상속받아 사용할 수 있습니다. 이 때, 상속을 받아 함수를 재정의 할 때에는 어노테이션 @Override를 사용하여 재정의함을 명시하여 줍니다.

**👩‍💻 실습 코드**
 
- 부모 클래스
```java
package basic;

public class Parent_example {
	// default constructor
	public Parent_example(){
		System.out.println("부모클래스 생성자 생성");
	}
	
	public void parent_method(String s){
		System.out.println("부모클래스에 있는 함수 >>> : ");
		System.out.println("부모클래스에 들어온 String s >>> : "+s);
	}
}
```

- 부모 클래스를 상속받은 자식 클래스

```java
package basic;

public class Child_example extends Parent_example{

	public static void main(String[] args) {
		Parent_example prnt=new Child_example();
		String child_str="자식클래스";
		prnt.parent_method(child_str);
	}
}
```

- 출력 결과

```
부모클래스 생성자 생성
부모클래스에 있는 함수 >>> : 
부모클래스에 들어온 String s >>> : 자식클래스
```

**✔ 인터페이스**

1. 인터페이스는 클래스이다. 키워드 ```interface```로 선언하고 클래스를 만들어서 컴파일 하면 .class가 만들어진다.

2. 인터페이스는 완벽한 추상 클래스로, 추상 함수만 와야한다. 멤버변수는 모두 상수이다. 
- 추상 함수 : 구현부가 없다. 즉, {}가 없는 함수이다.

3. 인터페이스에 선언한 추상함수는 무조건 다 오버라이딩 해야한다. 
4. 인터페이스를 사용할 때는 부모 인터페이스를 먼저 선언해서 상속한 자식클래스를 인스턴스 해서 사용한다.


**👩‍💻 실습 코드**

- 인터페이스

```java
package basic;

public interface Language {
	public void korea();
	public void japan();
	public void china();
	public void america();
}
```

- 인터페이스를 구현한 클래스

```java
package basic;

public class LanguageImpl implements Language {

	@Override
	public void korea() {
		System.out.println("안녕하세요.");
	}

	@Override
	public void japan() {
		System.out.println("오하이요");
	}

	@Override
	public void china() {
		System.out.println("니하오");
	}

	@Override
	public void america() {
		System.out.println("헬로");
	}

}
```

- 인터페이스 사용하는 일반 클래스

```java
package basic;

public class Interface_example {

	public static void main(String[] args) {
		Language lan=new LanguageImpl();
		lan.china();
		lan.korea();
		lan.japan();
		lan.america();
	}

}
```

- 출력 결과

```
니하오
안녕하세요.
오하이요
헬로
```

**🤔 Overload와 Override 차이?**

Overload : 메서드의 이름만 같고 매개변수의 갯수나 타입이 다른 함수를 정의

Override : 상위 클래스의 메서드를 하위 클래스가 재정의하는 것으로 메서드의 이름은 물론 파라미터의 갯수나 타입도 동일해야 한다.

### 7. 추상클래스

<hr>

추상클래스

1. 자원을 사용하려고 하는 클래스
2. 추상함수를 갖는다. ```접근제한자 abstract 리턴형 함수이름();```9
3. 추상클래스는 abstract 키워드를 가져야 한다.
4. new 연산자를 사용할 수 없고, 추상클래스를 상속할 때 extends 키워드를 사용한다.


**👩‍💻 추상클래스 실습 코드 첫 번째 사례**

- 추상클래스

```java
package basic;

public abstract class AbstractClass_example {
	abstract int add();
	int add_1(){
		return 1;
	}
}
```

- 추상클래스 상속 받은 클래스

```java
package basic;

public class AbstractClass2_example extends AbstractClass_example {
	int add(){
		return 0;
	}
}
```

- 추상클래스 사용하는 일반 클래스

```java
package basic;

public class Abstract_example {

	public static void main(String[] args) {
		AbstractClass_example ac=new AbstractClass2_example();
		int i1=ac.add();
		int i2=ac.add_1();
		System.out.println("int i1 >>> : "+i1);
        // int i1 >>> : 0
		System.out.println("int i2 >>> : "+i2);
        // int i2 >>> : 1
	}
}
```

**👩‍💻 추상클래스 실습 코드 두 번째 사례**

- 추상클래스

```java
package basic;

public abstract class AbstractClass_example2 {
	public static final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String JDBC_USER="scott";
	public static final String JDBC_PASSWORD="tiger";
	
	public static String getConnection(){
		String conn="connect";
		
		try{
			if(conn.equals("connect")){
				System.out.println("Connect DataBase");
			}
		}catch(Exception e){
			System.out.println("Can't Connect DataBase >>> : "+e.getMessage());
		}
		return conn;
	}
}
```

- 추상클래스에 있는 변수, 함수 사용하기

```java
package basic;

public class Abstract_example2 {

	public static void main(String[] args) {
		String jdbc_driver=null;
		String jdbc_password=null;
		String jdbc_url=null;
		String jdbc_user=null;
		String connect=null;
		
		jdbc_driver=AbstractClass_example2.JDBC_DRIVER;
		jdbc_password=AbstractClass_example2.JDBC_PASSWORD;
		jdbc_url=AbstractClass_example2.JDBC_URL;
		jdbc_user=AbstractClass_example2.JDBC_USER;
		
		System.out.println("jdbc_driver >>> : "+jdbc_driver);
		System.out.println("jdbc_password >>> : "+jdbc_password);
		System.out.println("jdbc_url >>> : "+jdbc_url);
		System.out.println("jdbc_user >>> : "+jdbc_user);
		
		connect=AbstractClass_example2.getConnection();
		System.out.println("connect >>> : "+connect);
	}
}
```

이처럼 보안에 민감한 정보의 경우, 추상클래스에 static 변수로 저장후, 일반 클래스에서 가져와서 사용할 수 있다.