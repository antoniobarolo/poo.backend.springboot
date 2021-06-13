CREATE TABLE `transacaoativo` (
   `id_transacaoativo` varchar(64) NOT NULL,
   `id_carteira` varchar(64) NOT NULL,
   `id_acao` varchar(64) not NULL,
   `dt_data` datetime not null,
   `nr_qtd` decimal(14,4) not NULL,
   `nrTipo` int not NULL,
   PRIMARY KEY (`id_transacaoativo`)
) ENGINE=InnoDB;
