drop database photoShare;
-- drop table user;
use photoShare;

/* CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      last_name VARCHAR(100) NOT NULL,
                      first_name VARCHAR(100) NOT NULL,
                      email VARCHAR(100) NOT NULL,
                      birth_date DATE
); */

CREATE TABLE image {
    idImage AUTO_INCREMENT PRIMARY KEY,
    uploadDate DATE NOT NULL,
    description VARCHAR(255),
    imagePath VARCHAR(255)
};

-- INSERT INTO user VALUES (1, "ASSAHI", "ABD", "abd@gmail.com", '2003-10-31');
-- INSERT INTO user VALUES (2, "KHARFI", "Adam", "adam@gmail.com", '2003-07-28');

-- select * from user;