/* *********************************DATASOURCECONFIG************************************************/
INSERT INTO DATASOURCECONFIG(driverclassname,url,name,username,password,initialize) VALUES ('org.h2.Driver', 'jdbc:h2:mem:testdb','default','sa', '', true);
INSERT INTO DATASOURCECONFIG(driverclassname,url,name,username,password,initialize) VALUES ('org.h2.Driver', 'jdbc:h2:mem:Eder', 'Eder', 'sa', '', true);
INSERT INTO DATASOURCECONFIG(driverclassname,url,name,username,password,initialize) VALUES ('org.h2.Driver', 'jdbc:h2:mem:Maria', 'Maria', 'sa', '', true);
INSERT INTO DATASOURCECONFIG(driverclassname,url,name,username,password,initialize) VALUES ('org.h2.Driver', 'jdbc:h2:mem:Luiz', 'Luiz', 'sa', '', true);


--INSERT INTO user (id, firstname, lastname, email, password) VALUES (1, 'Memory', 'Not Found', 'info@memorynotfound.com', '$2a$10$RyY4bXtV3LKkDCutlUTYDOKd2AiJYZGp4Y7MPVdLzWzT1RX.JRZyG');

--INSERT INTO role (name) VALUES ('ROLE_ADMIN');
--INSERT INTO role (name) VALUES ('ROLE_MANAGER');
--INSERT INTO role (name) VALUES ('ROLE_USER');

--INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
--INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);

