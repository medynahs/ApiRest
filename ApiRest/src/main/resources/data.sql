-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           8.0.23 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.2.0.6213
-- --------------------------------------------------------

SET FOREIGN_KEY_CHECKS=0;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando dados para a tabela starter_aesi.desafios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `desafios` DISABLE KEYS */;
INSERT INTO `desafios` (`id`, `nome_do_desafio`) VALUES
	(1, 'API'),
	(2, 'Desafio API'),
	(4, 'Funcionou');
/*!40000 ALTER TABLE `desafios` ENABLE KEYS */;

-- Copiando dados para a tabela starter_aesi.flyway_schema_history: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;

-- Copiando dados para a tabela starter_aesi.notas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` (`id`, `nota_qualidade_codigo`, `nota_quantidade_entregada`, `submissao_id`) VALUES
	(1, 2, 3, 1),
	(2, 2, 2, 2),
	(3, 1, 1, NULL),
	(4, 2, 3, 2);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;

-- Copiando dados para a tabela starter_aesi.starters: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `starters` DISABLE KEYS */;
INSERT INTO `starters` (`id`, `nome`, `email`, `letras`, `telefone`, `endereco`, `linguagem`) VALUES
	(1, 'Ariane', 'aesi@gft.com', 'aesi', '11 93775-4752', 'Rua Alves Guimarães', 'JAVA'),
	(2, 'Aryannniii', 'arya@gft.com', 'arya', '11 9333-9999', 'Rua aaaaryaaa', 'Dart'),
	(3, 'Juliana', 'jlna@gft.com', 'jlna', '11 3456-7890', 'Rua Alves Guimaraes', 'QA'),
	(5, 'Arya', 'arya@gft.com', 'arya', '11 9333-9999', 'Rua aaaaryaaa', 'Dart');
/*!40000 ALTER TABLE `starters` ENABLE KEYS */;

-- Copiando dados para a tabela starter_aesi.submissoes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `submissoes` DISABLE KEYS */;
INSERT INTO `submissoes` (`id`, `bairro`, `cep`, `cidade`, `complemento`, `estado`, `logradouro`, `numero`, `nome`, `desafio_id`, `starter_id`) VALUES
	(1, 'Pinheiros', '99.400-123', 'SP', 'Apto 19', 'SP', 'Rua Alves', '1239', 'Teste2', 2, 3),
	(2, 'Pinheiros', '99.400-123', 'SP', 'Apto 19', 'SP', 'Rua Guimara', '1239', 'Teste3', 2, 2);
/*!40000 ALTER TABLE `submissoes` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

SET FOREIGN_KEY_CHECKS=1;
