==============
DDLs 
==============

1)User Details table


CREATE TABLE G064PD.USER_DETAILS_TBL
	(
	USER_ID            NUMBER (7) NOT NULL,
	FIRST_NAME         VARCHAR2 (15),
	MIDDLE_NAME        VARCHAR2 (5),
	LAST_NAME          VARCHAR2 (10),
	GENDER             VARCHAR2 (7),
	DOB                DATE,
	EMAIL_ID           VARCHAR2 (25),
	PHONENO            NUMBER (10),
	CITY               VARCHAR2 (15),
	STATE              VARCHAR2 (10),
	LOCATION           VARCHAR2 (10),
	WEEKLY_NEWSLETTERS VARCHAR2 (2),
	PROMOTIONAL_OFFERS VARCHAR2 (2),
	CONSTRAINT USERID_PK PRIMARY KEY (USER_ID)
	)
	TABLESPACE G01_2012
	LOGGING
	STORAGE (BUFFER_POOL DEFAULT);
	
	

2)User Login table
	


CREATE TABLE G064PD.USER_LOGIN_TBL
	(
	USER_ID        NUMBER (7) NOT NULL,
	USER_NAME      VARCHAR2 (20),
	PASSWORD       VARCHAR2 (12),
	ROLE_ID        NUMBER (1),
	IS_FIRST_LOGIN VARCHAR2 (3),
	CONSTRAINT PK_USER_ID PRIMARY KEY (USER_ID)
	)
	TABLESPACE G01_2012
	LOGGING
	STORAGE (BUFFER_POOL DEFAULT);


	
3)Customer Details table


CREATE TABLE G064PD.CUSTOMERG04M2
	(
	FIRSTNAME   VARCHAR2 (20),
	MIDDLENAME  VARCHAR2 (20),
	LASTNAME    VARCHAR2 (20),
	ADDRESS     VARCHAR2 (50),
	CITY        VARCHAR2 (25),
	STATE       VARCHAR2 (25),
	GENDER      VARCHAR2 (10),
	DATE1       VARCHAR2 (20),
	CONTACT_NO  VARCHAR2 (12),
	EMAIL_ID    VARCHAR2 (25),
	LOCATION    VARCHAR2 (25),
	CUSTOMER_ID NUMBER (7) NOT NULL,
	ROLE_ID     NUMBER (1),
	CONSTRAINT PK_CUSTOMER_ID PRIMARY KEY (CUSTOMER_ID)
	)
	TABLESPACE G01_2012
	LOGGING
	STORAGE (BUFFER_POOL DEFAULT);
	
		
	
4)Generate Customer Id Sequence


CREATE SEQUENCE customer_Id
 START WITH     100
 INCREMENT BY   1
 
 
5)Upcoming Movie details table


CREATE TABLE G064PD.UPCOMINGMOVIE
	(
	MOVIE_ID       NUMBER (10),
	MOVIE_NAME     VARCHAR2 (10),
	MOVIE_LANGUAGE VARCHAR2 (10),
	MOVIE_DATE     VARCHAR2 (10),
	MOVIE_MONTH    VARCHAR2 (10),
	MOVIE_YEAR     VARCHAR2 (10)
	)
	TABLESPACE G01_2012
	LOGGING
	STORAGE (BUFFER_POOL DEFAULT);

	
6)Role table


CREATE TABLE G064PD.ROLE_TBL
	(
	ROLE_ID   NUMBER (1) NOT NULL,
	ROLE_NAME VARCHAR2 (11),
	CONSTRAINT ROLE_PK PRIMARY KEY (ROLE_ID)
	)
	TABLESPACE G01_2012
	LOGGING
	STORAGE (BUFFER_POOL DEFAULT);

	
	
	
=========================	
DMLs for Seed Data
=========================

1)User Login table


a)Super Admin Login(for Admin deletion)

INSERT INTO G064PD.USER_LOGIN_TBL 
(USER_ID, USER_NAME, PASSWORD, ROLE_ID, IS_FIRST_LOGIN)
VALUES (1, 'SA123', 'SA1234', 1, 'NO');


b)Admin Login(for adding upcoming movie)

INSERT INTO G064PD.USER_LOGIN_TBL 
(USER_ID, USER_NAME, PASSWORD, ROLE_ID, IS_FIRST_LOGIN)
VALUES (2, 'admin1', 'qwerty12', 2, 'NO');



2)Role table


INSERT INTO G064PD.ROLE_TBL (ROLE_ID, ROLE_NAME)
VALUES (1, 'SuperAdmin');


INSERT INTO G064PD.ROLE_TBL (ROLE_ID, ROLE_NAME)
VALUES (2, 'Admin');


INSERT INTO G064PD.ROLE_TBL (ROLE_ID, ROLE_NAME)
VALUES (3, 'MultiplexOP');


INSERT INTO G064PD.ROLE_TBL (ROLE_ID, ROLE_NAME)
VALUES (4, 'Customer');




3) User Details table


a)Super Admin details corresponding to login

INSERT INTO G064PD.USER_DETAILS_TBL (USER_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, GENDER, DOB, EMAIL_ID, PHONENO, CITY, STATE, LOCATION, WEEKLY_NEWSLETTERS, PROMOTIONAL_OFFERS)
VALUES (1, 'apoorva', NULL, 'gn', 'female', to_date ('1991-01-01', 'YYYY-MM-DD'), 'apoorva@tcs.com', 9192939495, 'hyd', NULL, 'jhills', NULL, NULL);


b)Admin details corresponding to login

INSERT INTO G064PD.USER_DETAILS_TBL (USER_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, GENDER, DOB, EMAIL_ID, PHONENO, CITY, STATE, LOCATION, WEEKLY_NEWSLETTERS, PROMOTIONAL_OFFERS)
VALUES (2, 'sonal', NULL, 'ruhatiya', 'female', to_date ('1990-04-12', 'YYYY-MM-DD'), 'sonal.ruhatiya@tcs.com', 9812321123, 'Guwahati', NULL, 'nedfi', NULL, NULL);


================================
DDL Modifications for Bug Fixing
================================


1)Upcoming Movie details table

ALTER TABLE UPCOMINGMOVIE MODIFY (MOVIE_NAME VARCHAR2(50));

--created by 760470, Balkrushna, for fixing bug related to movie name length--

2)Customer Details table

ALTER TABLE CUSTOMERG04M2 RENAME TO CUSTOMER_DETAIL_TABLE;

--created by 760140, Piyush Jain, to have a proper naming convension changed table name--



