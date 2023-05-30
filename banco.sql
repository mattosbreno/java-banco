-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 08-Maio-2023 às 04:40
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bancoteste`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(65) NOT NULL,
  `sexo` enum('M','F') NOT NULL,
  `email` varchar(90) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `civil` enum('Solteiro(a)','Casado(a)','Divorciado(a)','Viúvo(a)') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`codigo`, `nome`, `sexo`, `email`, `telefone`, `civil`) VALUES
(1, 'Emerson Luiz da Rocha', 'M', 'emersonluizkk@gmail.com', '(13) 98122-2225', 'Casado(a)'),
(2, 'João Sidnei Arcanjo', 'M', 'johnsid@gmail.com', '(19) 91935-7788', 'Solteiro(a)'),
(3, 'Fatima Jesus Xavier', 'F', 'fatima.jxavier@gmail.com', '(52) 98153-8860', 'Casado(a)'),
(4, 'Debora Cristina', 'F', 'cristina.debora0929@gmail.com', '(21) 98113-1645', 'Divorciado(a)'),
(5, 'Jacqueline Lifsitch', 'F', 'jaclifs@gmail.com', '(89) 99125-4564', 'Viúvo(a)'),
(6, 'Felipe Pires', 'M', 'felps.09@gmail.com', '(37) 99256-3255', 'Solteiro(a)'),
(7, 'Marcilio Nunes', 'M', 'marcilio00nunes@gmail.com', '(39) 98754-3332', 'Divorciado(a)'),
(8, 'Heraldo Oliveira', 'M', 'heraldoliveiram@gmail.com', '(55) 99722-9899', 'Viúvo(a)'),
(9, 'José Lopes Corrêa', 'M', 'lollypop@gmail.com', '(21) 99825-0211', 'Casado(a)'),
(28, 'Leon Scott Kennedy', 'M', 'leonbr19@gmail.com', '(12) 98156-7394', 'Solteiro(a)'),
(30, 'Maicon Kuster', 'M', 'maiconkusterkay@gmail.com', '(47) 98149-1212', 'Casado(a)'),
(34, 'Michonne Hinz', 'F', 'miijonehinz@gmail.com', '(52) 99557-4324', 'Solteiro(a)');

-- --------------------------------------------------------

--
-- Estrutura da tabela `contas`
--

CREATE TABLE `contas` (
  `codigo` int(11) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `numero` varchar(15) NOT NULL,
  `saldo` double NOT NULL,
  `cliente_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `contas`
--

INSERT INTO `contas` (`codigo`, `tipo`, `numero`, `saldo`, `cliente_codigo`) VALUES
(1, 'POUPANÇA', '0123-4', 11000, 4),
(2, 'CORRENTE', '5678-9', 20000, 3),
(3, 'CORRENTE', '2345-6', 25000, 2),
(4, 'SALÁRIO', '6789-0', 10000, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Índices para tabela `contas`
--
ALTER TABLE `contas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `cliente_codigo` (`cliente_codigo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de tabela `contas`
--
ALTER TABLE `contas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `contas`
--
ALTER TABLE `contas`
  ADD CONSTRAINT `contas_ibfk_1` FOREIGN KEY (`cliente_codigo`) REFERENCES `clientes` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
