CREATE TABLE REGISTRATION_USERS (
  id SERIAL PRIMARY KEY NOT NULL,
  username varchar(100) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL,
  email varchar(50) NOT NULL
) ;