## day2-linux명령어

작성일 2022.07.13

작성자 윤요섭 인턴

## day2 과제

<hr>

linux command를 실습하고 각각의 기능에 대해 보고서를 제출하세요.

**📃 참고링크**

✔ [리눅스 쉘 기본 명령어(Basci Shell Commands)](https://velog.io/@devmin/%EB%A6%AC%EB%88%85%EC%8A%A4-%EC%89%98-%EA%B8%B0%EB%B3%B8-%EB%AA%85%EB%A0%B9%EC%96%B4Basic-Shell-Commands)

✔ [[리눅스] 쉘 스크립트(SHELL SCRIPT) 기본 문법, 작성방법(변수, 반복문, 비교문, 종료상태 등)](https://reakwon.tistory.com/136)

✔ [왕초보를 위한 vim 사용방법](https://zeddios.tistory.com/122)

## 1. 리눅스 쉘 기본 명령어(Basic Shell Commands)

<hr>

**✔ cd**

cd : "change directory"의 약자로 특정 디렉토리로 이동하고 싶을 때 사용한다.

**👩‍💻 실습 코드**

```
# imyoseob@DESKTOP-5T12B9D:~$
# dir 입력하여 디렉토리, 파일 목록을 출력
dir
# RedWoodK 디렉토리로 이동하기 위해 cd RedWoodK 입력 후, cd . 명령어로 현재 디렉토리 확인
cd RedWoodK
cd .
# imyoseob@DESKTOP-5T12B9D:~/RedWoodK$
# 다시 한 번 dir 입력하여디렉토리, 파일 목록을 출력
dir

# 하위 디렉토리인 image 디렉토리로 이동 후, 현재 디렉토리 확인
cd image
cd .
# imyoseob@DESKTOP-5T12B9D:~/RedWoodK/image$ 

# 이전 디렉토리로 이동 후, 현재 디렉토리 확인
cd ..
cd .
# imyoseob@DESKTOP-5T12B9D:~/RedWoodK$

# 최상위 디렉토리로 이동 후, 현재 디렉토리 확인
cd /
cd .
# imyoseob@DESKTOP-5T12B9D:/$

# 사용자 홈 디렉토리로 이동
cd ~
# imyoseob@DESKTOP-5T12B9D:~$

# 다시 RedWoodK 디렉토리로 이동
cd RedWoodK
# imyoseob@DESKTOP-5T12B9D:~/RedWoodK$
```

**✔ ls**

ls는 "list"의 약자로, 현재 디렉토리에 속한 파일 및 디렉토리를 나열해줍니다.

**👩‍💻 실습 코드**

```
# imyoseob@DESKTOP-5T12B9D:~/RedWoodK$ 에 속한 파일 및 디렉토리 나열하기
ls
# README.md  RedWoodK  RedWoodK.code-workspace  day1-github구성.md  day2-linux명령어.md  image

# ls 명령어 옵션
# ls -a : 숨겨진 파일이나 디렉토리도 함께 보기
# ls -l : 자세한 내용(권한, 포함된 파일 수, 소유자, 그룹, 파일크기, 수정일자, 파일이름) 보기
# ls -al : a와 l의 기능을 모두 포함
# ls -h -al : -h를 붙이면 K, M, G 단위의 파일크기를 사용하여 사람에게 보기 좋게 표시
```

**✔ mv**

mv는 "move"의 약자로 파일이나 디렉토리를 원하는 곳으로 옮기거나, 이름을 변경할 대 사용할 수 있는 명령어 입니다.

**👩‍💻 실습 코드**

```
# 임의로 linux_mv_practice.txt 파일 생성 후 mv 명령어로 image 디렉토리로 옮기기
# linux_mv_practice.txt 현재 절대 경로 : /home/imyoseob/RedWoodK/linux_mv_practice.txt
# image 디렉토리로 이동후 dir로 디렉토리, 파일 목록을 출력하여 파일 있는지 확인하기
cd image
dir
# dir에 디렉토리, 파일 목록이 너무 많을 경우 find 명령어를 통해 찾아볼 수도 있다.
find . -name linux_mv_practice.txt
# .은 현재경로
# ./linux_mv_practice.txt 가 출력된 것을 통해 확인할 수 있다.
```

**✔ 기타 다른 명령어 모음**

<table>
<tr style="background-color:#e6ffe6">
 <td><b>명령어</b></td>
 <td><b><p style="text-align: center">설명</b></td>
</tr>
<tr style="background-color:#f2f2f2">
    <td>cp</td>
    <td style="text-align: center">copy의 약자로 파일이나 디렉토리를 원하는 곳에 원하는 이름으로 복사할 수 있음.</td>
</tr>
<tr style="background-color:#e6ffe6">
    <td>cat</td>
    <td style="text-align: center">concatenate의 약자로 두 개 이상의 파일을 연결해서 출력할 때 사용됩니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
    <td>less</td>
    <td style="text-align: center">파일 내용을 확인하는 명령어들 중 하나로, 한 번에 보여지는 만큼만 vim과 같은 내부창에 새로 출력을 해줍니다. 파일 내용을 확인할 때 용이하며, 파일 수정은 불가합니다.</td>
</tr>
<tr style="background-color:#e6ffe6">
    <td>tail</td>
    <td style="text-align: center">파일의 마지막 행을 기준으로 지정한 행까지의 파일 내용 일부를 출력해줍니다. 아무 옵션을 주지 않으면 기본적으로 10개의 행을 출력해줍니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
    <td>nohup</td>
    <td style="text-align: center">터미널을 종료해도 프로그램이 백그라운드에서 계속 실행되도록 하는 명령어 입니다.</td>
</tr>
<tr style="background-color:#e6ffe6">
    <td>rm</td>
    <td style="text-align: center">remove의 약자로 파일과 디렉토리 삭제에 사용되는 명령어 입니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
    <td>clear</td>
    <td style="text-align: center">쉘 창에 있는 기록을 모두 지워줍니다.</td>
</tr>
<tr style="background-color:#e6ffe6">
    <td>pwd</td>
    <td style="text-align: center">print working directory의 약자로 현재 작업중인 디렉토리의 절대 경로를 반환해줍니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
    <td>chown</td>
    <td style="text-align: center">파일이나 디렉토리의 소유권자 및 그룹식별자를 바꾸는 명령어입니다.</td>
</tr>
<tr style="background-color:#e6ffe6">
    <td>chmod</td>
    <td style="text-align: center">
    해당 파일이나 디렉토리의 허용 권한을 수정할 수 있는 명령어입니다. ("r"은 읽기, "w"는 쓰기, "x"는 실행 권한)<br>
    <a href="https://recipes4dev.tistory.com/175">chmod 관련 참고 사이트</a>
    </td>
</tr>
<tr style="background-color:#f2f2f2">
    <td>grep</td>
    <td style="text-align: center">특정 파일 내에서 지정한 패턴을 가진 문자열을 찾은 후, 해당 문자열을 출력해줍니다. 그리고 패턴에는 정규표현식의 패턴을 사용합니다.<br> <a href="https://velog.io/@devmin/TIL-%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9D-%EC%95%8C%EC%95%84%EA%B0%80%EA%B8%B0-s8k1vs4j8y">[TIL] 정규표현식 알아가기</a> </td>
</tr>
<tr style="background-color:#e6ffe6">
    <td>history</td>
    <td style="text-align: center">현재까지 쳤던 모든 명령어 리스트를 행 넘버와 함께 출력해줍니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
    <td>ps</td>
    <td style="text-align: center">현재 작동하는 프로세스의 목록을 출력해줍니다. 뒤에 붙는 옵션에 따라 출력되는 값이 달라집니다.</td>
</tr>
<tr style="background-color:#e6ffe6">
    <td>man</td>
    <td style="text-align: center">명령어를 어떻게 쓰는지 설명해주는 내용을 출력해줍니다. 내용이 좀 방대하게 나와서 중요한 부분만 알려주는 tldr로 대체해서 사용하기도 합니다. 다만 tldr은 내장되어 있지 않기 대문에, 패키지 매니저를 통해 설치해야 합니다.</td>
</tr>
</table>

- 기타 꿀팁
```
Control+a 누르면 커서가 해당 줄의 맨 앞으로 이동합니다.
Control+e 누르면 커서가 해당 줄의 맨 뒤로 이동합니다.
```

**💻 코드 실습**

```
# cp : 현재 디렉토리에 파일 복사
cp linux_mv_practice.txt linux_practice.txt

# cat : 두 개 이상의 파일을 연결해서 출력
cat linux_mv_practice.txt linux_practice.txt
# linux mv practicelinux practice
# 두 파일의 내용이 합쳐서 나타난다.

# rm : 파일과 디렉토리 삭제
rm linux_mv_practice.txt
find . -name linux_mv_practice.txt
# 제거 하였기 때문에 아무것도 나오지 않음

# mkdir : 새로운 디렉토리 만들기
mkdir dir_practice
find . -name dir_practice
# ./dir_practice : 디렉토리 생성됨

# touch : 새로운 파일 만들기
cd dir_practice
touch new_file.txt
find . -name new_file.txt
# ./new_file.txt : 파일 생성됨

# pwd : 현재 작업 중인 디렉토리의 절대 경로
pwd
# /home/imyoseob/RedWoodK/image/dir_practice : 절대 경로가 출력됨.

# grep : 특정 파일 내에서 지정한 패턴을 가진 문자열을 찾은 후, 해당 문자열을 출력해줍니다.
grep "Let" new_file.txt
# Let it be
# Let it be
# Let is be, let it be

# ps : 현재 작동하는 프로세스의 목록 출력
ps -a 
# PID TTY          TIME CMD
#   12 pts/0    00:00:00 sh
#   17 pts/0    00:00:00 sh 

# man : 명령어를 어떻게 쓰는지 설명해주는 내용 출력
man ls

LS(1)                                                                       User Commands                                                                      LS(1)

NAME
       ls - list directory contents

SYNOPSIS
       ls [OPTION]... [FILE]...

DESCRIPTION
       List information about the FILEs (the current directory by default).  Sort entries alphabetically if none of -cftuvSUX nor --sort is specified.

       Mandatory arguments to long options are mandatory for short options too.
```

## 2. [리눅스] 쉘 스크립트(SHELL SCRIPT) 기본 문법, 작성방법(변수, 반복문, 비교문, 종료상태 등)

<hr>

**✔ #!/bin/bash**

**👩‍💻 실습 코드**

```
#!/bin/bash
echo "hello"
# hello

printf "hello"
# hello
```

**✔ 변수**

쉘 스크립트에서도 변수를 사용할 수 있다. 변수명=값으로 변수를 선언하고, 사용할 때는 앞에 $를 붙여준다. 

**👩‍💻 실습 코드**

```
# ${변수}식으로 중괄호로 묶어서 사용합니다.
h="hello"
w="world"
echo "${h}, ${w}"
# 출력결과 : hello, world
```

**✔ 매개변수**

프로그램에서도 실행할 때 인자를 주듯 쉘 스크립트도 역시 그렇게 할 수 있다. 실행한 스크립트 이름은 ${0}, 그 이후는 전달받은 인자값들이다. 

**👩‍💻 실습 코드**

```
echo "script name:${0}"
# script name:/usr/bin/bash

echo "매개변수 갯수 :${#}"
# 매개변수 갯수 :0

echo "전체 매개변수 값 : ${*}"
# 전체 매개변수 값 : 

echo "전체 매개변수 값2 : ${@}"
# 전체 매개변수 값2 : 

echo "매개변수 1 : ${1}"
# 매개변수 1 : 

echo "매개변수 2 : ${2}"
# 매개변수 2 : 
```

**✔ 예약변수**

쉘 스크립트에서 사용자가 정해서 만들 수 없는 이미 정의된 변수가 존재한다. 이를 예약 변수라고 한다.

|변수|설명|
|:--|:--:|
|HOME|사용자 홈 디렉토리를 의미함|
|PATH|실행 파일의 경로|
|LANG|프로그램 실행 시 지원되는 언어|
|UID|사용자의 UID|
|SHELL|사용자가 로그인시 실행되는 쉘|
|USER|사용자의 계정 이름|
|FUNCNAME|현재 실행되고 있는 함수 이름|
|TERM|로그인 터미널|

**✔ 배열(Array)**

쉘 스크립트에서 배열은 1차원 배열만 지원하며 중괄호를 사용해야 한다. 배열 원소는 소괄호 안에 공백으로 구분한다. 배열 안 원소는 문자열이든 정수든 상관없이 쓸 수 있는 특징이 있다.

**👩‍💻 실습 코드**

```
#!/bin/bash
arr=("Red" 1 "Wood" 2 "K" 3)

echo "배열 전체 : ${arr[@]}"
# 배열 전체 : Red 1 Wood 2 K 3

echo "배열 원소의 갯수: ${#arr[@]}"
# 배열 원소의 갯수: 6

echo "배열 첫 번째 : ${arr},  혹은 ${arr[0]}"
# 배열 첫 번째 : Red,  혹은 Red

echo "5번 index를 갖는 배월의 원소 : ${arr[5]}"
# 5번 index를 갖는 배월의 원소 : 3

arr[5]=4
echo "5번 index를 갖는 배월의 원소 : ${arr[5]}"
# 5번 index를 갖는 배월의 원소 : 4

unset arr[5]
echo "5번 원소 삭제 후"
# 5번 원소 삭제 후
echo "5번 index를 갖는 배열의 원소 : ${arr[5]}"
# 5번 index를 갖는 배열의 원소 :
echo "6번 index를 갖는 배월의 원소 : ${arr[6]}"
# 6번 index를 갖는 배월의 원소 : 
```

**✔ 함수(Function)**

다른 프로그래밍 언어와 같이 쉘 스크립트에서도 함수를 사용할 수 있다. 
- 주의 : 함수가 호출되기 전에 함수가 정의되어 있어야 하며 호출할 때는 괄호를 써주지 않고 호출해야 한다.

**👩‍💻 실습 코드**

```
#!/bin/bash
 
 function redwoodk(){
     echo "Hello! RedWoodK"
 }

# 함수 호출
redwoodk
# Hello! RedWoodK
```

**✔ 비교문**

쉘스크립트에서 비교문은 아래와 같은 형식으로 사용할 수 있다.

```
if [값1 조건 값2]; then
    ... 작업 내용 ...
fi
```
**👩‍💻 실습 코드**

```
#!/bin/bash

function func(){
        a=10
        b=5

        if [ ${a} -eq ${b} ]; then
                echo "a와 b는 같다."
        fi

        if [ ${a} -ne ${b} ]; then
                echo "a와 b는 같지 않다."
        fi

        if [ ${a} -gt ${b} ]; then
                echo "a가 b보다 크다."
        fi

        if [ ${a} -ge ${b} ]; then
                echo "a가 b보다 크거나 같다."
        fi

        if [ ${a} -lt ${b} ]; then
                echo "a가 b보다 작다."
        fi

        if [ ${a} -le ${b} ]; then
                echo "a가 b보다 작거나 같다."
        fi

}

# 출력 결과
# a와 b는 같지 않다.
# a가 b보다 크다.
# a가 b보다 크거나 같다.
```    
**파일 관련 조건**

<table>
<tr style="background-color:#66a3ff">
<td style="text-align:center"><b>조건</b></td>
<td style="text-align:center"><b>설명</b></td>
</tr>
<tr>
 <td ><code>if [-d ${변수}]; then</code><br><code>if[! -d ${변수}]; then </code></td>
 <td style="text-align:center">${변수}의 디렉토리가 존재하면 참이 성립합니다.<br> ${변수}의 디렉토리가 존재하지 않으면 참이 성립합니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
 <td ><code>if [-e ${변수}]; then</code><br><code>if[! -e ${변수}]; then </code></td>
 <td style="text-align:center">${변수}라는 파일이 존재하면 참입니다.<br>${변수}라는 파일이 존재하지 않으면 참입니다.</td>
</tr>
<tr>
 <td ><code>if [-L ${변수}]; then </code></td>
 <td style="text-align:center">파일이 symbolic link이면 참입니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
 <td ><code>if [-s ${변수}]; then</code></td>
 <td style="text-align:center">파일의 크기가 0보다 크면 참입니다.</td>
</tr>
<tr>
 <td ><code>if [-S ${변수}]; then</code></td>
 <td style="text-align:center">파일 타입이 소켓이면 참입니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
 <td ><code>if [-r ${변수}]; then</code></td>
 <td style="text-align:center">파일을 읽을 수 있으면 참입니다.</td>
</tr>
<tr>
 <td ><code>if [-w ${변수}]; then</code></td>
 <td style="text-align:center">파일을 쓸 수 있으면 참입니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
 <td ><code>if [-x ${변수}]; then</code></td>
 <td style="text-align:center">파일을 실행할 수 있으면 참입니다.</td>
</tr>
<tr>
 <td ><code>if [-f ${변수}]; then</code></td>
 <td style="text-align:center">파일을 정규 파일이면 참입니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
 <td ><code>if [-c ${변수}]; then</code></td>
 <td style="text-align:center">파일이 문자 장치이면 참입니다.</td>
</tr>
<tr>
 <td ><code>if [${변수1} -nt ${변수2}]; then</code></td>
 <td style="text-align:center">변수1의 파일이 변수2의 파일보다 최신 파일이면 참입니다.</td>
</tr>
<tr style="background-color:#f2f2f2">
 <td ><code>if [${변수1} -ot ${변수2}]; then</code></td>
 <td style="text-align:center">변수1의 파일이 변수2의 파일보다 최신이 아니면 참입니다.</td>
</tr>
<tr>
 <td ><code>if [${변수1} -ef ${변수2}]; then</code></td>
 <td style="text-align:center">변수1의 파일과 변수2의 파일이 동일하면 참입니다.</td>
</tr>
</table>

**🤔 만약 AND 조건과 OR 조건을 섞어서 쓴다면?**

- AND는 -a, OR은 -o를 이용해서 조건을 추가 할 수 있다.
- 또한, 여러 조건을 걸려면 C에서 switch case와 동일한 구문을 하는 문법도 존재한다.

**👩‍💻 case 실습 코드**

```
case ${1} in
        "linux") echo "리눅스" ;;
        "unix") echo "유닉스" ;;
        "windows") echo "윈도우즈" ;;
        "MacOS") echo "맥OS" ;;
        *) echo "머야" ;;
esac

# 출력 결과 : 머야
```

**✔ 반복문**

**👩‍💻 실습 코드**

```
function gugu_2(){
    echo "2단을 외자"
    for i in {2..18..2}
    do
        echo "${i}"
    done
}

# 함수 호출
gugu_2
# 2단을 외자
# 2
# 4
# 6
# 8
# 10
# 12
# 14
# 16
# 18
```

**✔ 명령어의 종료 코드(exit)**

만약 명령어가 실패할 경우 동작을 다르게 할 것이라면 명령어의 종료 코드를 얻어오면 된다. 명령어의 종료 코드는 $?에 가장 최근 실행한 명령어의 종료 코드가 있다.
- 정상적인 종료는 0이 반환되는데, 만약 0이 아닌 값으로 반환되면 오류라고 판단하면 된다.

**👩‍💻 실습 코드**

```
echo "성공적 출력"
echo "오류코드 ($?)"
# 오류코드 (0)

ehco "실패적 출력"
echo "오류코드 ($?)"
# 오류코드 (127)
```

## 3. 왕초보를 위한 vim 사용방법

<hr>

### 1. vim이란?

"유닉스에서 사용할 수 있는 에디터"

**vi, vim**

 - vi : VIsual display editor에서 유래 됨.
 - vim : VI iMproved, 즉 향상된 vi를 의미


### 2. vim을 어떻게 쓸 것인가?

터미널에서 파일 생성하기

**👩‍💻 실습 코드**

```
vim hello.txt
```

vim에는 일반모드/입력모드/명령모드가 존재한다.

**2-1 입력모드로 전환하기**

- a 또는 i 또는 s 또는 o 누르기

```
# a누른 결과
-- INSERT --  
```

- 내용입력하기

```
안녕하세요.
vim을 배워봅시다
```

**2-2 명령모드로 전환하기**

- ESC를 누르면 명령모드로 들어간다.
- 이 상태에서 :를 눌러야 한다.

**2-3 저장하기**

- 소문자 w를 누르면, 저장할 수 있다.

```
# : 뒤에 소문자 w를 누른다.
"hello.txt" [New] 2L, 40C written   
```

**2-4 종료하기**

- :q를 누르면 종료할 수 있다.
- :w를 안하고 :q를 하면 경고문구가 뜬다. 다시 명령모드로 돌아가고 싶으면 :을 누르면 된다.

**2-5 강제종료**

- :q! 를 누르면 저장이 되지 않고 바로 전화면으로 돌아갈 수 있다.

**2-6 저장하면서 종료하기**

- :wq 또는 :wq!