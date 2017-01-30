-- This script creates a new database and insert products and their prices


CREATE DATABASE `glazier` ;
USE glazier;
CREATE TABLE PRICES(	
	ID INTEGER, 
	PROD_NAME VARCHAR(30),
	PROD_TYPE VARCHAR(30),
	PRICE DOUBLE,
	PRICE_PER VARCHAR(30),
	PRIMARY KEY prices(ID)
);

insert into prices (id,prod_name,prod_type,price,price_per) values (1,'GLASS','TRANSPARENT',300,'m2 (square meters)');
insert into prices (id,prod_name,prod_type,price,price_per) values (2,'FRAME_TYPE1','PVC',100,'m (meters)');
insert into prices (id,prod_name,prod_type,price,price_per) values (3,'FRAME_TYPE2','ALUMINIUM',200,'m (meters)');
insert into prices (id,prod_name,prod_type,price,price_per) values (4,'FRAME_TYPE3','WOOD',350,'m (meters)');