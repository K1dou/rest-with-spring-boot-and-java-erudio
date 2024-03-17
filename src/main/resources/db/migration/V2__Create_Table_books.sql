CREATE TABLE book_tb (
  id bigint NOT NULL AUTO_INCREMENT,
  author varchar(255) DEFAULT NULL,
  launch_date DATE DEFAULT NULL,
  price decimal(65.2) DEFAULT NULL,
  title varchar(100) DEFAULT NULL,
   PRIMARY KEY (id)
)
