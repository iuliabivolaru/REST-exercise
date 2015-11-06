CREATE TABLE iulia.CATEGORY (
  id_category NUMBER(5) NOT NULL,
  type_category VARCHAR(100),
  id_book NUMBER(5),
  PRIMARY KEY (id_category),
  FOREIGN KEY (id_book) REFERENCES iulia.BOOKS5(id_book)
);

CREATE SEQUENCE category_seq
 START WITH 1
 INCREMENT BY 1
 NOCYCLE;
