DROP TABLE if EXISTS myuser;
CREATE TABLE myuser
(
  userName VARCHAR (100) PRIMARY KEY,
  name VARCHAR (255),
  second_name VARCHAR (255),
  password VARCHAR(70) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1
);

DROP TABLE if EXISTS message;
CREATE TABLE message (
  id int(11) NOT NULL AUTO_INCREMENT,
  sender VARCHAR (100) NOT NULL,
  receiver VARCHAR (100) NOT NULL,
  date TIMESTAMP,
  title TINYTEXT,
  content LONGTEXT,
  FOREIGN KEY (sender) REFERENCES myuser(userName),
  FOREIGN KEY (receiver) REFERENCES myuser(userName)
);

DROP TABLE if EXISTS authorities;
CREATE TABLE authorities (
  authority_id int(11) NOT NULL AUTO_INCREMENT,
  userName varchar(100) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (authority_id),
  UNIQUE KEY uni_username_role (role,userName),
  CONSTRAINT fk_username FOREIGN KEY (userName) REFERENCES myuser (userName));
