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
    update_date       DATE   DEFAULT SYSDATE
);

create sequence seq_tbl_board NOCACHE;

INSERT INTO tbl_board(bno, title, content, writer)
VALUES(seq_tbl_board.NEXTVAL, 'title', 'content', 'writer');