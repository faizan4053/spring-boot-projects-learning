CREATE TABLE AUTH_USER 
(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(40),
	last_name VARCHAR(40),
	email VARCHAR(20) UNIQUE,
	PASSWORD VARCHAR(256), 
	account_non_expired BOOLEAN NOT NULL,
	account_non_locked BOOLEAN NOT NULL,
	credentials_non_expired BOOLEAN NOT NULL,
	enabled BOOLEAN NOT NULL
	
);