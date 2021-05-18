CREATE TABLE starters (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    letras VARCHAR(50) NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    endereco VARCHAR(50) NOT NULL,
    linguagem VARCHAR(50) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO starters (nome, email, letras, telefone, endereco, linguagem) values ('Ariane', 'aesi@gft.com', 'aesi', '11 93775-4752', 'Rua Alves Guimarães', 'JAVA');
