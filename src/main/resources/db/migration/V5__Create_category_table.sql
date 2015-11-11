CREATE TABLE CATEGORY (
  type_category VARCHAR(100),
  id_book NUMBER(5),
  FOREIGN KEY (id_book) REFERENCES BOOKS(id_book),
  CONSTRAINT pk_category PRIMARY KEY (id_book, TYPE_CATEGORY)
);

