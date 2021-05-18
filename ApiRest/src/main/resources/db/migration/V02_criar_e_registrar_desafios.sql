CREATE TABLE desafios (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nomeDoDesafio VARCHAR(50) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO desafios (nomeDoDesafio) values ('Desafio API');
