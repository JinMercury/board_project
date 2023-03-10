# 게시판 개인 프로젝트

<p align="center">
  <br>
  <img src="./image/sample/logo-sample.jpeg">
  <br>
</p>

## 프로젝트 소개

<p align="justify">
개인 실습 프로젝트로 게시판을 만들어보았다.
</p>

<br>

## 기술 스택

| JavaScript |    css    |   html   |  java   |   oracle  |
| :--------: | :-------: | :------: | :-----: | :-------: |
|   ![js]    |   ![css]  | ![html]  | ![java] | ![oracle] |

<br>

## 구현 기능

### 게시판

#### 메인화면
![메인]
<p align="justify">
  상위 헤더 include로 추가, 로그인/로그아웃, 회원정보 버튼을 누를 시 해당 페이지로 이동 <br>
  게시글이 최근 작성일 순으로 생성, 페이징 처리 해당 페이지 글 생성 <br>
  작성자, 작성일, 분류와 제목, 조회수가 보이게 된다 <br>
  게시글을 누를 시 해당 게시글 페이지로 이동 <br>
  분류, 검색어로 글 검색기능 생성
</p>

#### 게시글
![게시글]
<p align="justify">
  메인 페이지에서 게시글을 누를 시 글 번호에 해당하는 페이지 <br>
  작성자, 작성일, 분류와 제목, 내용이 포함된 글 생성 <br>
  하단 수정, 삭제 버튼을 누를 시 수정, 삭제 페이지로 이동 <br>
  댓글이 최근 작성일 순으로 생성, 댓글 작성자, 작성일, 내용이 보이게 된다 <br>
  댓글 작성할 시 댓글 추가
</p>

#### 게시글 작성
![게시글작성]
<p align="justify">
  분류 선택, 제목과 내용을 작성하고 작성버튼을 누를 시 해당 글이 저장되며 <br>
  메인페이지로 이동하게 된다
</p>

#### 게시글 수정
![게시글수정]
<p align="justify">
  해당 게시글의 분류, 제목, 내용을 생성
  분류 선택, 제목과 내용을 수정하고 작성버튼을 누를 시 해당 글이 수정되며 <br>
  메인페이지로 이동하게 된다
</p>

### 회원

#### 로그인
![로그인]
<p align="justify">
  아이디, 비밀번호 입력 후 로그인 버튼을 누르게 되면 해당 아이디로 로그인 후 세션 ID, 닉네임 저장 <br>
  아이디와 비밀번호가 틀렸을 시 하단 경고 문구 생성 <br>
  회원가입 버튼을 누를 시 해당 페이지로 이동
</p>

#### 회원가입
![회원가입]
<p align="justify">
  아이디와 비밀번호, 비밀번호 확인, 닉네임을 작성 후 버튼을 누르면 DB에 저장후 메인페이지로 이동 <br>
  비밀번호와 비밀번호 확인이 서로 다르게 되면 하단에 경고 문구 생성 후 버튼 비활성화
</p>

#### 회원정보 수정
![회원정보]
<p align="justify">
  아이디와 닉네임은 세션을 통해 미리 작성, 아이디는 변경할 수 없게 비활성화 <br>
  비밀번호, 비밀번호 확인, 닉네임을 수정 후 버튼을 누르면 DB에 저장된 데이터 변경 후 로그아웃 페이지로 이동 <br>
  비밀번호와 비밀번호 확인이 서로 다르게 되면 하단에 경고 문구 생성 후 버튼 비활성화
</p>

<br>

## 배운 점 & 아쉬운 점

<p align="justify">
  MVC 패턴의 작동방법, 흐름을 알게 되었다. <br>
  이 흐름을 알게되면 페이지당 어떤식으로 처리해야 하는지에 대한 속도가 빨라졌다. <br>
  <br>
  DB에서 많이 혼란을 느꼈다. <br>
  멤버와 게시글간의 외래키는 어떻게 해야하고 <br>
  게시글과 댓글간 처리는 어떻게 해야할지 고민이 많았다. <br>
  특히 게시글의 작성자를 멤버의 닉네임으로 외래키를 지정하고 싶었지만 <br>
  주 식별자 키가 ID였기 때문에 해결방법을 찾지 못했다.
</p>

<!-- Stack Icon Refernces -->

[js]: image/stack/javascript.svg
[css]: image/stack/css.svg
[html]: image/stack/html.svg
[java]: image/stack/java.png
[oracle]: image/stack/oracle.png

<!-- Sample Refernces -->

[게시글]: /image/sample/게시글.png
[게시글수정]: image/sample/게시글수정.png
[게시글작성]: image/sample/게시글작성.png
[로그인]: image/sample/로그인.png
[메인]: image/sample/메인.png
[회원가입]: image/sample/회원가입.png
[회원정보]: image/sample/회원정보.png
