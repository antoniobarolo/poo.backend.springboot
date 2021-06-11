CREATE TABLE `acao` (
	`id_acao` varchar(64) NOT NULL,
	`id_empresa` varchar(64) NOT NULL,
	`dt_data` date NOT NULL,
	`vr_valor` decimal(14,4) DEFAULT NULL,
	PRIMARY KEY (`id_acao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
