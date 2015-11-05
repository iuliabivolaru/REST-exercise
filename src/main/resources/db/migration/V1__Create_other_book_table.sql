CREATE TABLE iulia.BOOKS5 (
  id_book NUMBER(5) NOT NULL,
  title VARCHAR(100) NOT NULL,
  authors VARCHAR(100) NOT NULL,
  category VARCHAR(100),
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

