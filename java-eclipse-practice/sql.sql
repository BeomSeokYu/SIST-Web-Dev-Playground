CREATE TABLE t_member (
	id			VARCHAR2(20)	PRIMARY KEY,
	pw			VARCHAR2(20)	NOT NULL,
	name		VARCHAR2(20)	NOT NULL,
	email		VARCHAR2(50),
	photo		VARCHAR2(100),
	gender		CHAR(1),
	joindate	DATE DEFAULT SYSDATE
);
DROP TABLE t_member;
 
SELECT * FROM t_member ORDER BY id;

SELECT * FROM t_member WHERE id = 'qwe';

INSERT INTO t_member (
	id
	, pw
	, name
	, email
	, photo
	, gender
	, joindate
) VALUES (
	id = ''
	, pw = ''
	, name = ''
	, email = ''
	, photo = ''
	, gender = ''
	, joindate = ''
);


UPDATE t_member
SET joindate=SYSDATE
WHERE id='admin'