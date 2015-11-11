CREATE TABLE BOOKS (
  id_book NUMBER(5) NOT NULL,
  title VARCHAR(100) NOT NULL,
  authors VARCHAR(100) NOT NULL,
  publication_date VARCHAR(20),
  price NUMBER(7,2),
  ISBN VARCHAR(100),
  description VARCHAR(300),
  cover VARCHAR(100),
  number_of_pages NUMBER(5),
  language_of_book VARCHAR(100),
  stars NUMBER(7,2),
  PRIMARY KEY(id_book)
);
CREATE SEQUENCE books_seq START WITH 3 INCREMENT BY 1 NOCACHE;