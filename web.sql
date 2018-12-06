-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 06-Dez-2018 às 21:06
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `web`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE `empresa` (
  `IdEmpresa` int(11) NOT NULL,
  `Nome` varchar(255) NOT NULL,
  `RazaoSocial` varchar(255) NOT NULL,
  `CNPJ` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `empresa`
--

INSERT INTO `empresa` (`IdEmpresa`, `Nome`, `RazaoSocial`, `CNPJ`) VALUES
(1, 'testegadsfgsdfg', 'teste', 'teste'),
(2, 'teste1', 'teste1', 'teste1'),
(3, 'teste1', 'teste1we', 'teste12345'),
(4, 'Alexandre', 'teste', 'teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ticket`
--

CREATE TABLE `ticket` (
  `IdTicket` int(11) NOT NULL,
  `IdUsuario` int(11) DEFAULT NULL,
  `Titulo` varchar(255) NOT NULL,
  `Descricao` varchar(255) NOT NULL,
  `DataCriacao` date NOT NULL,
  `DataFechamento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ticket`
--

INSERT INTO `ticket` (`IdTicket`, `IdUsuario`, `Titulo`, `Descricao`, `DataCriacao`, `DataFechamento`) VALUES
(1, 3, 'wert', 'wert', '2018-12-05', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ticketconversa`
--

CREATE TABLE `ticketconversa` (
  `IdTicketConversa` int(11) NOT NULL,
  `IdTicket` int(11) DEFAULT NULL,
  `IdUsuarioDetalhe` int(11) DEFAULT NULL,
  `IdOperador` int(11) DEFAULT NULL,
  `Conteudo` varchar(255) NOT NULL,
  `DataPostagem` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `topico`
--

CREATE TABLE `topico` (
  `IdTopico` int(11) NOT NULL,
  `IdUsuarioDetalhe` int(11) DEFAULT NULL,
  `IdMelhorResposta` int(11) DEFAULT NULL,
  `Titulo` varchar(255) NOT NULL,
  `Descricao` varchar(255) NOT NULL,
  `DataCriacao` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `topicocomentario`
--

CREATE TABLE `topicocomentario` (
  `IdTopicoComentario` int(11) NOT NULL,
  `IdTopico` int(11) DEFAULT NULL,
  `IdUsuario` int(11) DEFAULT NULL,
  `Conteudo` varchar(255) NOT NULL,
  `Votos` int(11) DEFAULT NULL,
  `DataPostagem` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `IdUsuario` int(11) NOT NULL,
  `IdUsuarioDetalhe` int(11) DEFAULT NULL,
  `IdEmpresa` int(11) DEFAULT NULL,
  `Login` varchar(255) NOT NULL,
  `Senha` varchar(255) NOT NULL,
  `Admin` bit(1) NOT NULL,
  `Operador` bit(1) NOT NULL,
  `Cliente` bit(1) NOT NULL,
  `Nome` varchar(100) DEFAULT NULL,
  `Sobrenome` varchar(100) DEFAULT NULL,
  `Idade` varchar(100) DEFAULT NULL,
  `Sexo` varchar(100) DEFAULT NULL,
  `RG` varchar(100) DEFAULT NULL,
  `CPF` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`IdUsuario`, `IdUsuarioDetalhe`, `IdEmpresa`, `Login`, `Senha`, `Admin`, `Operador`, `Cliente`, `Nome`, `Sobrenome`, `Idade`, `Sexo`, `RG`, `CPF`) VALUES
(1, 1, NULL, 'admin', '12345', b'1', b'0', b'0', '', '', '', '', '', ''),
(2, 1, NULL, 'operador', '1', b'0', b'1', b'0', '', '', '', '', '', ''),
(3, 1, NULL, 'cliente', '12345', b'0', b'0', b'1', '', '', '', '', '', ''),
(4, 1, NULL, 'usuario', '1', b'0', b'0', b'0', '', '', '', '', '', ''),
(9, 1, 1, 'wert', '123', b'0', b'0', b'1', '', '', '', '', '', ''),
(10, 0, 1, 'teste1', '12345', b'0', b'0', b'1', NULL, NULL, NULL, NULL, NULL, NULL),
(11, 0, 3, 'teste12345', '12345', b'0', b'0', b'1', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuariodetalhe`
--

CREATE TABLE `usuariodetalhe` (
  `IdUsuarioDetalhe` int(11) NOT NULL,
  `IdUsuario` int(11) DEFAULT NULL,
  `IdEmpresa` int(11) DEFAULT NULL,
  `Nome` varchar(255) NOT NULL,
  `Sobrenome` varchar(255) NOT NULL,
  `Idade` int(11) NOT NULL,
  `Sexo` varchar(255) NOT NULL,
  `RG` varchar(255) NOT NULL,
  `CPF` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`IdEmpresa`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`IdTicket`),
  ADD KEY `fk_Ticket_IdUsuario` (`IdUsuario`);

--
-- Indexes for table `ticketconversa`
--
ALTER TABLE `ticketconversa`
  ADD PRIMARY KEY (`IdTicketConversa`),
  ADD KEY `fk_TicketConversa_IdTicket` (`IdTicket`),
  ADD KEY `fk_TicketConversa_IdUsuarioDetalhe` (`IdUsuarioDetalhe`),
  ADD KEY `fk_TicketConversa_IdUsuario` (`IdOperador`);

--
-- Indexes for table `topico`
--
ALTER TABLE `topico`
  ADD PRIMARY KEY (`IdTopico`),
  ADD KEY `fk_Topico_IdUsuarioDetalhe` (`IdUsuarioDetalhe`),
  ADD KEY `fk_Topico_IdMelhorResposta` (`IdMelhorResposta`);

--
-- Indexes for table `topicocomentario`
--
ALTER TABLE `topicocomentario`
  ADD PRIMARY KEY (`IdTopicoComentario`),
  ADD KEY `fk_TopicoComentario_IdTopico` (`IdTopico`),
  ADD KEY `fk_TopicoComentario_IdUsuario` (`IdUsuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IdUsuario`),
  ADD UNIQUE KEY `uc_Usuario_Login` (`Login`),
  ADD KEY `fk_Usuario_IdEmpresa` (`IdEmpresa`);

--
-- Indexes for table `usuariodetalhe`
--
ALTER TABLE `usuariodetalhe`
  ADD PRIMARY KEY (`IdUsuarioDetalhe`),
  ADD KEY `fk_UsuarioDetalhe_IdEmpresa` (`IdEmpresa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `empresa`
  MODIFY `IdEmpresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `IdTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ticketconversa`
--
ALTER TABLE `ticketconversa`
  MODIFY `IdTicketConversa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `topico`
--
ALTER TABLE `topico`
  MODIFY `IdTopico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `topicocomentario`
--
ALTER TABLE `topicocomentario`
  MODIFY `IdTopicoComentario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IdUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `usuariodetalhe`
--
ALTER TABLE `usuariodetalhe`
  MODIFY `IdUsuarioDetalhe` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_Ticket_IdUsuario` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`IdUsuario`);

--
-- Limitadores para a tabela `ticketconversa`
--
ALTER TABLE `ticketconversa`
  ADD CONSTRAINT `fk_TicketConversa_IdTicket` FOREIGN KEY (`IdTicket`) REFERENCES `ticket` (`IdTicket`),
  ADD CONSTRAINT `fk_TicketConversa_IdUsuario` FOREIGN KEY (`IdOperador`) REFERENCES `usuario` (`IdUsuario`),
  ADD CONSTRAINT `fk_TicketConversa_IdUsuarioDetalhe` FOREIGN KEY (`IdUsuarioDetalhe`) REFERENCES `usuariodetalhe` (`IdUsuarioDetalhe`);

--
-- Limitadores para a tabela `topico`
--
ALTER TABLE `topico`
  ADD CONSTRAINT `fk_Topico_IdMelhorResposta` FOREIGN KEY (`IdMelhorResposta`) REFERENCES `topicocomentario` (`IdTopicoComentario`),
  ADD CONSTRAINT `fk_Topico_IdUsuarioDetalhe` FOREIGN KEY (`IdUsuarioDetalhe`) REFERENCES `usuariodetalhe` (`IdUsuarioDetalhe`);

--
-- Limitadores para a tabela `topicocomentario`
--
ALTER TABLE `topicocomentario`
  ADD CONSTRAINT `fk_TopicoComentario_IdTopico` FOREIGN KEY (`IdTopico`) REFERENCES `topico` (`IdTopico`),
  ADD CONSTRAINT `fk_TopicoComentario_IdUsuario` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`IdUsuario`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_IdEmpresa` FOREIGN KEY (`IdEmpresa`) REFERENCES `empresa` (`IdEmpresa`);

--
-- Limitadores para a tabela `usuariodetalhe`
--
ALTER TABLE `usuariodetalhe`
  ADD CONSTRAINT `fk_UsuarioDetalhe_IdEmpresa` FOREIGN KEY (`IdEmpresa`) REFERENCES `empresa` (`IdEmpresa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
