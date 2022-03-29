create table IF NOT EXISTS dentists(id int auto_increment primary key,name varchar(255),surname varchar (255), register int);
create table IF NOT EXISTS address(id int auto_increment primary key,street varchar(255),number varchar (255),city varchar (255));
create table IF NOT EXISTS patients(id int auto_increment primary key,name varchar(255),surname varchar (255),id_address int, dni int, dateInit TIMESTAMP WITHOUT TIME ZONE);
create table IF NOT EXISTS appointments(id int auto_increment primary key,dentist_id int,patient_id int, dateInit TIMESTAMP WITHOUT TIME ZONE);