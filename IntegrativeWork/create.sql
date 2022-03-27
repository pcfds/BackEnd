create table IF NOT EXISTS dentists(id int auto_increment primary key,name varchar(255),surname varchar (255), register int);
create table IF NOT EXISTS address(id int auto_increment primary key,street varchar(255),number varchar (255),city varchar (255));
create table IF NOT EXISTS patients(id int auto_increment primary key,name varchar(255),surname varchar (255),dni varchar (255), id_address int, dateInit TIMESTAMP WITHOUT TIME ZONE);
