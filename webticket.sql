CREATE DATABASE webticket;

use webticket;

CREATE TABLE `UsuarioDetalhe` (
    `IdUsuarioDetalhe` int  NOT NULL auto_increment primary key,
    `IdUsuario` int ,
    `IdEmpresa` int ,
    `Nome` varchar(255)  NOT NULL ,
    `Sobrenome` varchar(255)  NOT NULL ,
    `Idade` int  NOT NULL ,
    `Sexo` varchar(255)  NOT NULL ,
    `RG` varchar(255)  NOT NULL ,
    `CPF` varchar(255)  NOT NULL
);

CREATE TABLE `Empresa` (
    `IdEmpresa` int  NOT NULL auto_increment primary key,
    `Nome` varchar(255)  NOT NULL ,
    `RazaoSocial` varchar(255)  NOT NULL ,
    `CNPJ` varchar(255)  NOT NULL
);

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

CREATE TABLE `Ticket` (
    `IdTicket` int  NOT NULL auto_increment primary key,
    `IdUsuario` int ,
    `Titulo` varchar(255)  NOT NULL ,
    `Descricao` varchar(255)  NOT NULL ,
    `DataCriacao` TIMESTAMP NOT NULL ,
    `DataFechamento` TIMESTAMP
);

CREATE TABLE `TicketConversa` (
    `IdTicketConversa` int  NOT NULL auto_increment primary key,
    `IdTicket` int   ,
    `IdUsuario` int   ,
    `Conteudo` varchar(255) NOT NULL ,
    `DataPostagem` TIMESTAMP  NOT NULL
);

CREATE TABLE `Topico` (
    `IdTopico` int  NOT NULL auto_increment primary key,
    `IdUsuarioDetalhe` int ,
    `IdMelhorResposta` int,
    `Titulo` varchar(255)  NOT NULL ,
    `Descricao` varchar(255)  NOT NULL ,
    `DataCriacao` date  NOT NULL
);

CREATE TABLE `TopicoComentario` (
    `IdTopicoComentario` int  NOT NULL auto_increment primary key,
    `IdTopico` int ,
    `IdUsuario` int,
    `Conteudo` varchar(255) NOT NULL ,
    `Votos` int  ,
    `DataPostagem` date  NOT NULL
);

ALTER TABLE `Usuario` ADD CONSTRAINT `fk_Usuario_IdEmpresa` FOREIGN KEY(`IdEmpresa`)
REFERENCES `Empresa` (`IdEmpresa`);

ALTER TABLE `UsuarioDetalhe` ADD CONSTRAINT `fk_UsuarioDetalhe_IdEmpresa` FOREIGN KEY(`IdEmpresa`)
REFERENCES `Empresa` (`IdEmpresa`);

ALTER TABLE `Ticket` ADD CONSTRAINT `fk_Ticket_IdUsuario` FOREIGN KEY(`IdUsuario`)
REFERENCES `Usuario` (`IdUsuario`);

ALTER TABLE `TicketConversa` ADD CONSTRAINT `fk_TicketConversa_IdTicket` FOREIGN KEY(`IdTicket`)
REFERENCES `Ticket` (`IdTicket`);

ALTER TABLE `TicketConversa` ADD CONSTRAINT `fk_TicketConversa_IdUsuarioDetalhe` FOREIGN KEY(`IdUsuario`)
REFERENCES `Usuario` (`IdUsuario`);

ALTER TABLE `Topico` ADD CONSTRAINT `fk_Topico_IdUsuarioDetalhe` FOREIGN KEY(`IdUsuarioDetalhe`)
REFERENCES `UsuarioDetalhe` (`IdUsuarioDetalhe`);

ALTER TABLE `Topico` ADD CONSTRAINT `fk_Topico_IdMelhorResposta` FOREIGN KEY(`IdMelhorResposta`)
REFERENCES `TopicoComentario` (`IdTopicoComentario`);

ALTER TABLE `TopicoComentario` ADD CONSTRAINT `fk_TopicoComentario_IdTopico` FOREIGN KEY(`IdTopico`)
REFERENCES `Topico` (`IdTopico`);

ALTER TABLE `TopicoComentario` ADD CONSTRAINT `fk_TopicoComentario_IdUsuario` FOREIGN KEY(`IdUsuario`)
REFERENCES `Usuario` (`IdUsuario`);

INSERT INTO Usuario (Login,Senha,Admin,Operador,Cliente,IdUsuarioDetalhe)
values
('admin','12345',1,0,0,0),
('operador','12345',0,1,0,0),
('cliente','12345',0,0,1,0),
('usuario','12345',0,0,0,0);