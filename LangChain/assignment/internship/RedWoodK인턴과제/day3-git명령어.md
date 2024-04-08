## day3-git명령어

작성일 2022.07.14

작성자 윤요섭 인턴

## day3 과제

<hr>

git 명령어를 실습하고 각각의 기능에 대해 보고서를 제출하세요.

**📃 참고링크**

✔ [Git/GitHub 안내서](https://subicura.com/git/guide/#git%E1%84%8B%E1%85%B4-%E1%84%90%E1%85%B3%E1%86%A8%E1%84%8C%E1%85%B5%E1%86%BC)

**✔ Git이란?**

Git은 분산 버전 관리 시스템이다.

## Git 기본 명령어

<hr>

**✔ git init**

로컬 Git 저장소를 설정합니다.

**👩‍💻 실습 코드**

```
pwd
# /home/imyoseob/RedWoodK/practice_file
mkdir sample
cd sample
echo "빨강" >> red
echo "주황" >> orange
git init
# Initialized empty Git repository in /home/imyoseob/RedWoodK/practice_file/sample/.git/
```

- mkdir : 디렉토리 생성
- cd : 디렉토리 이동
- touch : 빈 파일 생성
- echo "[글자]" >> [파일] : 파일에 글자 추가

**✔ git status, git add**

```git add``` :  파일의 변경사항을 인덱스에 추가합니다. Git은 커밋하기 전, 인덱스에 먼저 커밋할 파일을 추가합니다.

```git status``` : 현재 작업중인 상태를 확인합니다.

**👩‍💻 실습 코드**

```
# git 접속하기
git config --global user.name 'Yun-Yoseob'
git config --global user.email 'imyoseob@gmail.com"

# repo 연결하기
git remote add origin https://github.com/Yun-Yoseob/RedWoodK.git

git status
# On branch master
# No commits yet
#Untracked files:
#  (use "git add <file>..." to include in what will be committed)
#        hello.txt
#        sample/
#
#nothing added to commit but untracked files present (use "git add" #to track)

git add .
git status
#On branch master
#
#No commits yet
#
#Changes to be committed:
#  (use "git rm --cached <file>..." to unstage)
#        new file:   orange
#        new file:   red
```

**✔ git commit**

git commit : 현재 상태 저장, 인덱스에 추가된 변경 사항을 이력에 추가합니다.

**👩‍💻 실습 코드**

```
git commit -m "20220714:Git실습"
#[master (root-commit) a85909b] 20220714:Git실습
# 2 files changed, 2 insertions(+)
# create mode 100644 orange
# create mode 100644 red
```

**✔ 새 파일 추가하기**

yellow 파일을 만듭니다.

**👩‍💻 실습 코드**

```
touch yellow
echo "노랑" >> yellow
git status
#On branch master
#Untracked files:
#  (use "git add <file>..." to include in what will be committed)
#        yellow
#
#nothing added to commit but untracked files present (use "git add" #to track)

git add .
git commit -m "20220714:Git파일추가"
#[master 1c9e6bc] 20220714:Git파일추가
# 1 file changed, 1 insertion(+)
# create mode 100644 yellow
```

**✔ 다양한 변화 주기**

추가/수정/삭제를 이용한 세 번째 이력을 만듭니다.

요구사항
1. red 삭제
2. orange에 내용 추가
3. green 파일 추가
4. 상태 확인
5. 전체 파일 인덱스에 추가
6. 세 번째 이력 커밋

**👩‍💻 실습 코드**

```
rm red
echo "오렌지" >> orangee
touch green
git status
#On branch master
#Changes not staged for commit:
#  (use "git add/rm <file>..." to update what will be committed)
#  (use "git restore <file>..." to discard changes in working #directory)
#        deleted:    red
#
#Untracked files:
#  (use "git add <file>..." to include in what will be committed)
#        green
#        orangee
#no changes added to commit (use "git add" and/or "git commit -a")

git add -A
git commit -m "20220714:Git다양한변화주기"
# 3 files changed, 1 insertion(+), 1 deletion(-)
# create mode 100644 green
# create mode 100644 orangee
# delete mode 100644 red
```

**✔ git log - 이력확인**

```git log``` : 다양한 옵션을 조합하여 원하는 형태의 로그를 출력할 수 있는 강력한 기능입니다. 

**👩‍💻 실습 코드**

```
git log
#commit 645bd203f1749edd4983a670c23f18a0755f5c08 (HEAD -> master)
#Author: Yun-Yoseob <imyoseob@gmail.com>
#Date:   Thu Jul 14 09:34:44 2022 +0900
#
#    20220714:Git다양한변화주기
#
#commit 1c9e6bc49e80ee3cc33ca3313536dcb7e587fcf8
#Author: Yun-Yoseob <imyoseob@gmail.com>
#Date:   Thu Jul 14 09:30:17 2022 +0900
#
#    20220714:Git파일추가
#
#commit a85909ba91f8b56ea26b3a2764d1dd9b749cee86
#Author: Yun-Yoseob <imyoseob@gmail.com>
#commit a85909ba91f8b56ea26b3a2764d1dd9b749cee86
#Author: Yun-Yoseob <imyoseob@gmail.com>
#Date:   Thu Jul 14 09:25:51 2022 +0900
#
#    20220714:Git실습
```

**✔ git reset - 이전 상태로(이력 제거)**

20220714:Git파일 추가 커밋까지 이력 초기화 시키기

**👩‍💻 실습 코드**

```
git reset --hard 1c9e6bc
# HEAD is now at 1c9e6bc 20220714:Git파일추가
```

**✔ git revert - 이전 상태로(이력 유지)**

git reset 명령어로 인해, 20220714:Git다양한변화주기 커밋내용이 사라졌기 때문에, 다시 작업을 해줍니다.

```
rm red
echo "오렌지" >> orangee
touch green
git status
git add -A
git commit -m "20220714:Git다양한변화주기"
#[master b8a6e30] 20220714:Git다양한변화주기
# 3 files changed, 1 insertion(+), 1 deletion(-)
# create mode 100644 green
# create mode 100644 orangee
# delete mode 100644 red
```

**참고**

```
# git log를 보았을 때
# commit b8a6e30ce08292577b118dd15fe578e0c54a6648
# 으로 나타납니다.
# 이전의 "20220714:Git다양한 변화주기" commit 기록인
# commit 645bd203f1749edd4983a670c23f18a0755f5c08 (HEAD -> master)
# 과는 다른 것을 확인 할 수 있습니다.
```

**🤔 reset과 revert 차이점**

- reset : 시간을 아예 과거의 특정 사건(commit)으로 되돌린다.
- revert : 현재에 있으면서 과거의 특정 사건(commit)들만 없던 일로 만든다.

공통점은 '과거로 되돌린다.'는 것이지만 가장 큰 차이점은 '과거로 되돌리겠다는 내용도 기록되는가?(== commit 이력에 남는가?)'이다.

[참고링크 : [Git] reset과 revert 알고 사용하기](https://velog.io/@njs04210/Git-reset%EA%B3%BC-revert-%EC%95%8C%EA%B3%A0-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)

## Git and Branch

<hr>

**📃 참고링크**

✔ [Yun-Yoseob/Study Git.md](https://github.com/Yun-Yoseob/Study/blob/master/Git.md)

**🤔 Branch란?**

> 참고링크
- [유튜브 생활코딩 : 지옥에서 온 Git - branch 소개](https://www.youtube.com/watch?v=PmWPdYkAMg4)
-  [누구나 쉽게 이해할 수 있는 Git 입문](https://backlog.com/git-tutorial/kr/stepup/stepup1_1.html)

브랜치란 독립적으로 어떤 작업을 진행하기 위한 개념으로, 각각의 브랜치는 다른 브랜치의 영향을 받지 않기 때문에, 여러 작업을 동시에 진행할 수 있습니다.

**✔ git branch 만들고 이동하기**

**👩‍💻 실습 코드**

```
# 새 브랜치 만들기
git branch branch_1
git branch branch_2
# 브랜치 생성 확인
git branch
#  branch_1
#  branch_2
#* main

# 새로운 브랜치로 이동
git checkout branch_1
# Switched to branch 'branch_1'

# branch_1에서 새로운 파일 branch_1_file 만들기
touch branch_1_file
echo "브랜치1파일내용" >> branch_1_file

# branch_2에서 새로운 파일 branch_2_file 만들기
git checkout branch_2
# Switched to branch 'branch_2'
touch branch_2_file
echo "브랜치2파일내용" >> branch_2_file
```
**✔ git branch에 파일 업로드 하기**

**👩‍💻 실습 코드**

```
# 다시 branch_1로 이동하여 branch_1_file 올리기
git checkout branch_1
git add branch_1_file
git commit -m "branch_1:branch_1_file"
git push -u origin branch_1
# branch_1에 branch_1_file이 업로드 된 것을 확인 할 수 있다.

# branch_2로 이동하여 branch_2_file 올리기
git checkout branch_2
# Switched to branch 'branch_2'
git add branch_2_file
git commit -m "branch_2:branch_2_file"
git push -u origin branch_2
# branch_2에 branch_2_file이 업로드 된 것을 확인 할 수 있다.
```

**✔ git 브랜치 병합하기**

**👩‍💻 실습 코드**

```
#  branch_2에 branch_1 병합하기
git merge branch_1
git commit -m "20220714:1245"
git checkout main
git push -u origin branch_2
```

<img src="/image/merge.PNG" alt="no-image">

branch_2에 branch_1_file과 branch_2_file이 모두 들어가 있는 것을 확인할 수 있다. 

## 원격저장소와 Github

day3-git명령어.md 를 포함한 local에 있는 workspace에 있는 파일들을 Github repository에 업로드 하기

**👩‍💻 실습 코드**

```
pwd
# /home/imyoseob/RedWoodK

git init
# Reinitialized existing Git repository in /home/imyoseob/RedWoodK/.git/

git add .
git remote -v
# origin  https://github.com/Yun-Yoseob/RedWoodK.git (fetch)
# origin  https://github.com/Yun-Yoseob/RedWoodK.git (push)
git commit -m "20220714:git명령어.md"
git push -u origin main
```