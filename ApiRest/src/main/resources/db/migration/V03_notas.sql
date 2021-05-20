CREATE TABLE notas (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    --submissao
    notaQualidadeCodigo INT(3) NOT NULL,
    notaQuantidadeEntregada INT(3) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO notas (notaQualidadeCodigo, notaQuantidadeEntregada) values (1,2);
