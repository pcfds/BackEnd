DROP TABLE IF EXISTS address;  CREATE TABLE address (ID INT AUTO_INCREMENT PRIMARY KEY,
street varchar(200) NOT NULL,
number INT NOT NULL,
city varchar(100) NOT NULL);

DROP TABLE IF EXISTS patients; CREATE TABLE patients (ID INT AUTO_INCREMENT PRIMARY KEY,
name varchar(100) NOT NULL,
surname varchar(100) NOT NULL,
email varchar(100) NOT NULL,
dni INT NOT NULL,
dateInit DATE NOT NULL,
address_id INT NOT NULL);

DROP TABLE IF EXISTS dentists; CREATE TABLE dentists (ID INT AUTO_INCREMENT PRIMARY KEY,
name varchar(200) NOT NULL,
surname varchar(200) NOT NULL,
register int NOT NULL);

INSERT INTO address (street, number, city)
VALUES ('25 de Mayo',1323, 'Catamarca');

INSERT INTO patients (name, surname, email, dni , dateInit, address_id)
VALUES ('Peter','Bauman','qwe@gmail.com',57182,'2022-03-01',1);

INSERT INTO dentists (name, surname, register)
VALUES ('Grego','Martinez',14);
