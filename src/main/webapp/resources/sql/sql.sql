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