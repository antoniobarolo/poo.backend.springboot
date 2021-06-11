CREATE TABLE `moeda` (
                         `id_moeda` varchar(64) NOT NULL,
                         `tx_nome` varchar(50) NOT NULL,
                         `tx_simbolo` varchar(5) DEFAULT NULL,
                         PRIMARY KEY (`id_moeda`)
) ENGINE=InnoDB;


INSERT INTO `moeda` (`id_moeda`,`tx_nome`,`tx_simbolo`) VALUES
('693b7986-c6fc-11eb-89c3-4d9f3735665f','Real','BRL'),
('693c79d0-c6fc-11eb-89c3-4d9f3735665f','Dolar','USD'),
('693c8cfe-c6fc-11eb-89c3-4d9f3735665f','Euro','EUR');



