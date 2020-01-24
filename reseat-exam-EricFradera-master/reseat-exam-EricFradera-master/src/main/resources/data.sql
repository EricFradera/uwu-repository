-- Users
INSERT INTO myuser (name, second_name, userName, password) VALUES ('Xavier', 'Tarafa', 'tarafa', '{noop}tarafa');
INSERT INTO myuser (name, second_name, userName, password) VALUES ('Sergi', 'Alvarez', 'alvarez', '{bcrypt}$2a$10$7PFxXn4TQRiut9jNcAl7AubQZUWWck/eML3TDaQtoZiWNEN6o.Ig6');
INSERT INTO myuser (name, second_name, userName, password) VALUES ('Josep', 'Roure', 'roure', '{bcrypt}$2a$10$0VGzG8lfiDXBnFTE98lfiOLtP4uh62wnE6iWs5.2AMrJ3G9k7XZqu');
INSERT INTO myuser (name, second_name, userName, password) VALUES ('Admin', 'Admin', 'admin', '{noop}admin');

-- Authorities
INSERT INTO authorities (userName, role) VALUES ('tarafa', 'ROLE_USER');
INSERT INTO authorities (userName, role) VALUES ('alvarez', 'ROLE_USER');
INSERT INTO authorities (userName, role) VALUES ('roure', 'ROLE_ADMIN');
INSERT INTO authorities (userName, role) VALUES ('roure', 'ROLE_USER');
INSERT INTO authorities (userName, role) VALUES ('admin', 'ROLE_ADMIN');

-- Messages
INSERT INTO message (title, content, date, sender, receiver) VALUES ('Alerta vent', 'Josep,  Avui s''ha d''anar amb molt de compte', CURRENT_TIMESTAMP, 'tarafa', 'roure' );
INSERT INTO message (title, content, date, sender, receiver) VALUES ('Re: Alerta vent', 'Xavier, Moltes gràcies per l''avís. Ho tindré en compte. ---- Avui s''ha d''anar amb molt de compte', CURRENT_TIMESTAMP, 'roure', 'tarafa' );

