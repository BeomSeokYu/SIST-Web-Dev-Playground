CREATE TABLE product (
	pid			VARCHAR2(10) 	PRIMARY KEY,
	pname		VARCHAR2(30),
	price		NUMBER 	 		DEFAULT 0,
	description VARCHAR2(4000),
	maker		VARCHAR2(30),
	category	VARCHAR2(20),
	stock		NUMBER 	 		DEFAULT 0,
	condition	VARCHAR2(20),
	pimage		VARCHAR2(50)
);

CREATE TABLE member (
	userid		VARCHAR2(50) 	PRIMARY KEY		NOT NULL,
	userpw		VARCHAR2(50)	NOT NULL,
	usernm		VARCHAR2(50)	NOT NULL,
	email 		VARCHAR2(100),
	gender		CHAR(1),
	photo		VARCHAR2(500),
	joinDate	DATE			DEFAULT SYSDATE
);

INSERT INTO product VALUES('P1000', 'iPhone 6s', 800000, '1334X750 Renina HD display, 8-megapixel iSight Camera', 'Apple', 'Smart Phone', 1000, 'new', 'P1000.png');
INSERT INTO product VALUES('P1001', 'LG PC gram', 1500000, '3.3-inch,IPS LED display, 5rd Generation Intel Core processors', 'LG', 'Notebook', 1000, 'new', 'P1001.png');
INSERT INTO product VALUES('P1002', 'Galaxy Tab S', 900000, '3.3-inch, 212.8*125.6*6.6mm, Super AMOLED display, Octa-Core processor', 'Samsung', 'Tablet', 1000, 'new', 'P1002.png');

