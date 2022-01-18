## 소비내역 관리 프로젝트

## 사용 언어 
- Java 8
- SpringBoot 2.x
- SpringSecurity
- JWT
- mysql 5.7

- feat에 대한 설명은 Issues에 있습니다.

## 요구사항
- [x] 고객은 이메일과 비밀번호 입력을 통해서 회원 가입을 할 수 있습니다. <br>
- [ ] 고객은 회원 가입이후, 로그인과 로그아웃을 할 수 있습니다. -> 로그아웃 기능 구현 x <br>
- [x] 고객은 로그인 이후 가계부 관련 아래의 행동을 할 수 있습니다. <br>
    - [x] 가계부에 오늘 사용한 돈의 금액과 관련된 메모를 남길 수 있습니다. <br>
    - [x] 가계부에서 수정을 원하는 내역은 금액과 메모를 수정 할 수 있습니다. <br>
    - [x] 가계부에서 삭제를 원하는 내역은 삭제 할 수 있습니다. <br>
    - [x] 삭제한 내역은 언제든지 다시 복구 할 수 있어야 한다. <br>
    - [x] 가계부에서 이제까지 기록한 가계부 리스트를 볼 수 있습니다. <br>
    - [x] 가계부에서 상세한 세부 내역을 볼 수 있습니다. <br>
- [x] 로그인하지 않은 고객은 가계부 내역에 대한 접근 제한 처리가 되어야 합니다. <br>

## 구현 
- [ ] 언어에 상관없이 Docker를 기반으로 서버를 실행 할 수 있도록 작성해주세요.
- [x] DB 관련 테이블에 대한 DDL 파일을 소스 디렉토리 안에 넣어주세요.
- [x] 가능하다면 테스트 케이스를 작성해주세요.
- [x] 별도의 요구사항이 없는 것은 지원자가 판단해서 개발합니다.
- [x] 토큰을 발행해서 인증을 제어하는 방식으로 구현해주세요

## Architecture
![image](src/main/resources/static/image.png)

## 데이터베이스
### Schema : customer
- id : 고객 식별 번호
- email : 이메일 정보
- password : 비밀번호
- roles : 권한정보

### Schema : account
- id : 가계부 식별번호
- customer_id : 고객 번호
- pay_money : 비용
- memo : 메모장
- created_at : 생성시간
- modified_at : 변경시간

### Schema : delete_account
- id : 삭제된 가계부 식별번호
- customer_id : 고객 번호
- pay_money : 비용
- memo : 메모장
- created_at : 생성시간
- modified_at : 변경시간

-> 가계부의 정보를 삭제하게 되면 자동으로 삭제된 가계부에 생성된다.

## RestAPI
- 고객 회원가입 : (POST) http:localhost:8080/customer/sign-up
  ```{
  "email":"sdfsd@naver.com",
  "password" : "sfe12412"
  }
  ```
- 고객 로그인 : (POST) http:localhost:8080/customer/login
  ```{
  "email":"sdfsd@naver.com",
  "password" : "sfe12412"
  }
  ```
- 가계부 금액,메모 삽입 : (POST) http:localhost:8080/accounts
  ```{
  "customerId":"1",
  "payMoney" : "2000",
  "memo":"콜라한잔"
  }
  ```
- 가계부 금액, 메모 수정 : (PATCH) http:localhost:8080/accounts
  ```{
  "id":"2",
  "payMoney" : "2000",
  "memo":"콜라한잔"
  }
  ```
- 가계부 내역 삭제 : (Delete) http:localhost:8080/accounts/{id}
- 삭제한 내역 복구 : (Delete) http:localhost:8080/delete_accounts/{id}
- 가계부 리스트 조회 : (GET) http:localhost:8080/accounts/all
- 가계부 상세한 세부 내역 : (GET) http:localhost:8080/accounts/{id}
