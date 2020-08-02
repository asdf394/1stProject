select * from toy;
select * from TOY_RENTAL;
select * from TOY_PAY;
select * from TOY_MEMBER
select * from TOY_BASKET;
insert into toy(name,domain,develop,age,rent,img) values()
TRUNCATE TABLE TOY_BASKET;
select toy_no from toy_basket where id ='a';
insert into toy_pay(no,id,discount,place,pay_year,toy_no) values(PAY_SEQ.NEXTVAL,1,1,1,1,1)
insert into toy_rental values(394,1,SYSDATE + 7)

--테이블 삭제
drop table toy CASCADE CONSTRAINTS;
drop table toy_basket CASCADE CONSTRAINTS;
drop table toy_board CASCADE CONSTRAINTS;
drop table toy_member CASCADE CONSTRAINTS;
drop table toy_pay CASCADE CONSTRAINTS;
drop table toy_rental CASCADE CONSTRAINTS;
--시퀀스 삭제
drop sequence TOY_SEQ;
drop sequence PAY_SEQ;
drop sequence BOARD_SEQ;
drop sequence BASKET_SEQ
--시퀀스 생성
CREATE SEQUENCE TOY_SEQ --시퀀스이름 장난감
INCREMENT BY 1 --증감숫자 1
START WITH 1 --시작숫자 1
MINVALUE 1 --최소값 1
NOCYCLE; --순한하지않음

CREATE SEQUENCE BOARD_SEQ --시퀀스이름 게시판
INCREMENT BY 1 --증감숫자 1
START WITH 1 --시작숫자 1
MINVALUE 1 --최소값 1
NOCYCLE; --순한하지않음

CREATE SEQUENCE BASKET_SEQ --시퀀스이름 장바구니
INCREMENT BY 1 --증감숫자 1
START WITH 1 --시작숫자 1
MINVALUE 1 --최소값 1
NOCYCLE; --순한하지않음

CREATE SEQUENCE PAY_SEQ --시퀀스이름 결제
INCREMENT BY 1 --증감숫자 1
START WITH 1 --시작숫자 1
MINVALUE 1 --최소값 1
NOCYCLE; --순한하지않음
--------------------------------------------------------
--  DDL for Table TOY
--------------------------------------------------------
  CREATE TABLE "HR"."TOY" 
   ("NO" NUMBER DEFAULT NULL NOT NULL, 
	"NAME" VARCHAR2(50 BYTE) NOT NULL , 
	"DOMAIN" VARCHAR2(20 BYTE) NOT NULL , 
	"DEVELOP" VARCHAR2(15 BYTE) NOT NULL , 
	"AGE" VARCHAR2(30 BYTE) NOT NULL , 
	"RENT" NUMBER DEFAULT 0 NOT NULL , 
	"IMG" VARCHAR2(200 BYTE), 
	"EXPLAIN" VARCHAR2(300 BYTE), 
	 CONSTRAINT "TOY_PK" PRIMARY KEY ("NO"),
	 CONSTRAINT "TOY_CHK_RENT" CHECK (RENT = 0 OR RENT = 1));
--------------------------------------------------------
--  DDL for Table TOY_MEMBER
--------------------------------------------------------

  CREATE TABLE "HR"."TOY_MEMBER" 
   ("ID" VARCHAR2(15 BYTE) NOT NULL, 
	"PW" VARCHAR2(20 BYTE) NOT NULL, 
	"NAME" VARCHAR2(10 BYTE) NOT NULL, 
	"ADDRESS" VARCHAR2(150 BYTE) NOT NULL, 
	"PHONE" VARCHAR2(15 BYTE) NOT NULL, 
	"SALETARGET" NUMBER DEFAULT 1, 
	"TERM" DATE,
	 CONSTRAINT "MEM_PK" PRIMARY KEY ("ID"),
	 CONSTRAINT "MEM_CHK_SALETARGET" CHECK (SALETARGET = 1 OR SALETARGET = 2)
   );
--------------------------------------------------------
--  DDL for Table TOY_BASKET
--------------------------------------------------------

  CREATE TABLE TOY_BASKET 
   ("NO" NUMBER NOT NULL, 
	"ID" VARCHAR2(15 BYTE) NOT NULL, 
	"TOY_NO" NUMBER NOT NULL,
	CONSTRAINT "TOY_BASKET_PK" PRIMARY KEY ("NO"),
	CONSTRAINT "BASKET_MEM_ID_FK1" FOREIGN KEY ("ID")
	 REFERENCES "HR"."TOY_MEMBER" ("ID"),
	CONSTRAINT "BASKET_TOY_NO_FK2" FOREIGN KEY ("TOY_NO")
	 REFERENCES "HR"."TOY" ("NO")
	);
--------------------------------------------------------
--  DDL for Table TOY_PAY
--------------------------------------------------------

  CREATE TABLE TOY_PAY 
   ("NO" NUMBER NOT NULL, 
	"ID" VARCHAR2(15 BYTE) NOT NULL, 
	"DISCOUNT" NUMBER NOT NULL, 
	"PLACE" NUMBER, 
	"PAY_YEAR" VARCHAR2(20 BYTE) DEFAULT 1 NOT NULL,  
	"TOY_NO" NUMBER NOT NULL, 
	"TOTAL" NUMBER,
	CONSTRAINT "PAY_PK" PRIMARY KEY ("NO"),
	CONSTRAINT "PAY_CHK_YEAR" CHECK (PAY_YEAR = 0 OR PAY_YEAR = 1),
	CONSTRAINT "PAY_CHK_DISCOUNT" CHECK (DISCOUNT = 1 OR PAY_YEAR = 2),
	CONSTRAINT "PAY_CHK_PLACE" CHECK (PLACE = 0 OR PLACE = 1),
	CONSTRAINT "PAY_MEM_ID_FK1" FOREIGN KEY ("ID")
	 REFERENCES "HR"."TOY_MEMBER" ("ID"),
	CONSTRAINT "PAYT_TOY_NO_FK2" FOREIGN KEY ("TOY_NO")
	 REFERENCES "HR"."TOY" ("NO")
   ); 
--------------------------------------------------------
--  DDL for Table TOY_RENTAL
--------------------------------------------------------

  CREATE TABLE "HR"."TOY_RENTAL" 
   ("NO" NUMBER NOT NULL, 
   "EXPDATE" DATE,
	"PLACE" NUMBER, 
	CONSTRAINT "RENTAL_PK" PRIMARY KEY ("NO"),
	CONSTRAINT "RENT_CHK_PLACE" CHECK (PLACE = 0 OR PLACE = 1),
	CONSTRAINT "RENT_TOY_NO_FK1" FOREIGN KEY ("NO")
	 REFERENCES "HR"."TOY" ("NO")
   );
--------------------------------------------------------
--  DDL for Table TOY_BOARD
--------------------------------------------------------

  CREATE TABLE "HR"."TOY_BOARD" 
   ("NO" NUMBER NOT NULL, 
	"NAME" VARCHAR2(10 BYTE) NOT NULL, 
	"ID" VARCHAR2(15 BYTE) NOT NULL, 
	"CONTENT" VARCHAR2(400 BYTE), 
	"TITLE" VARCHAR2(100 BYTE),
	CONSTRAINT "BOARD_PK" PRIMARY KEY ("NO"),
	CONSTRAINT "BOARD_MEM_ID_FK1" FOREIGN KEY ("ID")
	 REFERENCES "HR"."TOY_MEMBER" ("ID")	
   );