CREATE TABLE user (
  id int(11) AUTO_INCREMENT,   
  firstname varchar(255),
  lastname varchar(255),
  email varchar(255),
  password varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE role (
  id int(11) AUTO_INCREMENT,
  name varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE users_roles (
  user_id int(11),
  role_id int(11),
  PRIMARY KEY (user_id,role_id),  
  CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES user (id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE TABLE DATASOURCECONFIG (
	id int(11) AUTO_INCREMENT,	
	driverclassname VARCHAR(255),
	url VARCHAR(255),
	name VARCHAR(255),
	username VARCHAR(255),
	password VARCHAR(255),
	initialize BOOLEAN,
	PRIMARY KEY (id)
);

CREATE TABLE HIBERNATE_SEQUENCE (
  next_val bigint(20) DEFAULT NULL
);

CREATE SEQUENCE HIBERNATE_SEQUENCE;
