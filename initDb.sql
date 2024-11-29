drop database if exists photoShare;
create database photoShare;
-- drop table user;
use photoShare;

/* CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      last_name VARCHAR(100) NOT NULL,
                      first_name VARCHAR(100) NOT NULL,
                      email VARCHAR(100) NOT NULL,
                      birth_date DATE
); */

CREATE TABLE image_file (
    id_image INT AUTO_INCREMENT PRIMARY KEY,
    upload_date DATETIME NOT NULL,
    image_filename VARCHAR(255),
    image_path VARCHAR(255),
    description VARCHAR(255)
    );

-- INSERT INTO user VALUES (1, "ASSAHI", "ABD", "abd@gmail.com", '2003-10-31');
-- INSERT INTO user VALUES (2, "KHARFI", "Adam", "adam@gmail.com", '2003-07-28');

-- select * from user;