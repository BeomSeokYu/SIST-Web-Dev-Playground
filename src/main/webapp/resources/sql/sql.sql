DROP TABLE tbl_reply;
DROP TABLE tbl_board;
DROP TABLE tbl_attach;

CREATE TABLE tbl_reply (
    rno         NUMBER      CONSTRAINT  pk_tbl_reply  PRIMARY KEY,
    bno         NUMBER      CONSTRAINT   fk_tbl_reply  REFERENCES tbl_board(bno)  NOT NULL,
    reply       VARCHAR(1000)   NOT NULL,
    replyer     VARCHAR(50)     NOT NULL,
    reg_date    DATE        DEFAULT SYSDATE,
    update_date DATE
);

-- index
CREATE INDEX idx_tbl_reply ON tbl_reply(bno DESC, rno ASC);

CREATE SEQUENCE seq_tbl_reply NOCACHE;

CREATE TABLE tbl_board(
    bno         number  CONSTRAINT pk_tbl_board PRIMARY KEY,
    title       VARCHAR2(200)   not null,
    content       VARCHAR2(4000)   not null,
    writer       VARCHAR2(50)   not null,
    reg_date       DATE   DEFAULT SYSDATE,
    update_date       DATE,
    reply_cnt   NUMBER  DEFAULT 0
);

create sequence seq_tbl_board NOCACHE;

INSERT INTO tbl_board(bno, title, content, writer)
VALUES(seq_tbl_board.NEXTVAL, 'title', 'content', 'writer');

CREATE TABLE tbl_attach (
    uuid        VARCHAR2(150)       CONSTRAINT pk_tbl_attach      PRIMARY KEY,
    bno         NUMBER              CONSTRAINT fk_board_attach    REFERENCES tbl_board(bno) ON DELETE CASCADE,
    up_folder   VARCHAR(200)        NOT NULL,
    file_name   VARCHAR(200)        NOT NULL,
    image       CHAR(1)
);












CREATE TABLE users(
    username VARCHAR2(50) NOT NULL PRIMARY KEY,
    password VARCHAR2(50) NOT NULL,
    enabled  CHAR(1)      DEFAULT '1'
);
 
 CREATE TABLE authorities(
	username  VARCHAR2(50) NOT NULL 
			  CONSTRAINT fk_authorities_users
			  REFERENCES users(username),
	authority VARCHAR2(50) NOT NULL
);
 
CREATE UNIQUE INDEX ix_auth_username
ON     authorities(username, authority);
 
INSERT INTO users(username, password) VALUES('user00', '1111');
INSERT INTO users(username, password) VALUES('member00', '1111');
INSERT INTO users(username, password) VALUES('admin00', '1111'); 
 
INSERT INTO authorities VALUES('user00',   'ROLE_USER');
INSERT INTO authorities VALUES('member00', 'ROLE_MEMBER');
INSERT INTO authorities VALUES('admin00',  'ROLE_MEMBER');
INSERT INTO authorities VALUES('admin00',  'ROLE_ADMIN');

CREATE TABLE tbl_member(
    id          VARCHAR2(50)    NOT NULL PRIMARY KEY,
    pw          VARCHAR2(100)   NOT NULL,
    name        VARCHAR2(50)    NOT NULL,
    reg_date    DATE            DEFAULT SYSDATE,
    update_date DATE,
    enabled     CHAR(1)         DEFAULT '1'
);

CREATE TABLE tbl_member_auth(
	id          VARCHAR2(50) NOT NULL
			    CONSTRAINT fk_tbl_member_auth
			    REFERENCES tbl_member(id),
	auth VARCHAR2(50) NOT NULL
);