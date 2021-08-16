

--table for storing user details

CREATE TABLE USER 
(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(40),
	last_name VARCHAR(40),
	email VARCHAR(20) UNIQUE,
	PASSWORD VARCHAR(256), 
	account_non_expired BOOLEAN NOT NULL,
	account_non_locked BOOLEAN NOT NULL,
	account_non_expired BOOLEAN NOT NULL,
	credentials_non_expired BOOLEAN NOT NULL,
	enabled BOOLEAN NOT NULL
	
);

CREATE TABLE ADDRESS 
(
	USERID INT NOT NULL,
	STATE VARCHAR(20),
	STREEETNAME VARCHAR(20),
	BLOCKNUMBER VARCHAR(20), 
	CITY VARCHAR(20),
	COUNTRY VARCHAR(40)
);

--table for storing role of an user

CREATE TABLE ROLE 
(
	id SERIAL PRIMARY KEY,
	name VARCHAR(20)
);

--table for managing the relation between USER table and ROLE table

CREATE TABLE USER_ROLE(
	USER_ID int,
	ROLE_ID int,
	FOREIGN KEY (user_id)
	REFERENCES auth_user(id),
	FOREIGN KEY (role_id)
	REFERENCES role(id)
);


CREATE TABLE PASSWORDS 
(
	USERID INT NOT NULL AUTO_INCREMENT,
	PASSWORD VARCHAR(256),
	PASSWORD VARCHAR(256),
	PASSWORD VARCHAR(256), 
	LAST_PASSWORD_MODIFIED TIMESTAMP,
);


--Data insertion queries

insert into user(first_name,last_name,email,password) values ('doug','bailey','doug@bailey.com','$2a$10$U2STWqktwFbvPPsfblVeIuy11vQ1S/0LYLeXQf1ZL0cMXc9HuTEA2');
insert into user(first_name,last_name,email,password) values ('john','ferguson','john@ferguson.com','$2a$10$YzcbPL.fnzbWndjEcRkDmO1E4vOvyVYP5kLsJvtZnR1f8nlXjvq/G');

insert into auth_user values (1,true,true,true,'doug@123.com',true,'doug','bailey','$2a$10$U2STWqktwFbvPPsfblVeIuy11vQ1S/0LYLeXQf1ZL0cMXc9HuTEA2');

insert into role values(1,'ROLE_ADMIN');
insert into role values(2,'ROLE_USER');

insert into user_role values(1,1);
insert into user_role values(2,2);

select * from user;
select * from role;
select * from user_role;


--tables for storing access token and refresh token

create table oauth_access_token (
	token_id varchar(255) NOT NULL,
	token BYTEA,
	authentication_id varchar(255) DEFAULT NULL, 
	user_name varchar(255) DEFAULT NULL, 
	client_id varchar(255) DEFAULT NULL, 
	authentication BYTEA,
	refresh_token varchar(255) DEFAULT NULL, 
	PRIMARY KEY (token_id)
);

create table oauth_refresh_token ( 
	token_id varchar(255) NOT NULL,
	token BYTEA,
	authentication BYTEA,
	PRIMARY KEY (token_id)
);

select * from oauth_access_token;

select * from oauth_refresh_token;