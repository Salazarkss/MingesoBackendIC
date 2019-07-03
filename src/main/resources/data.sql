INSERT INTO `dbic`.`habitacion` (`number`, `tipo_tipo_id`, `tipo_reserva`)
	VALUES
	('250', 1, 'Disponible'),
	('251', 2, 'Disponible'),
	('252', 3, 'Disponible'),
	('302', 2, 'Disponible'),
	('303', 1, 'Disponible'),
	('401', 3, 'Disponible');

INSERT INTO `dbic`.`tipo` (`tipo`,`valor` )
	VALUES
	('Simple', '15000'),
	('Doble', '30000'),
	('Matrimonial', '45000');

INSERT INTO `dbic`.`reserva` (`codigo`, `fecha_reserva`, `fin`, `valor_final`, `inicio`, `nombre`, `valor`, `tipo_reserva`,`habitacion_id`)
	VALUES
	('A', '2011-04-19 10:00:00', '2019-05-26 10:00:00', '65000', '2019-05-22 10:00:00', 'Ignacia Arratia', '65000', 'Particular','1'),
	('B', '2011-04-19 10:00:00', '2019-05-21 10:00:00', '150000', '2019-05-19 10:00:00', 'Pedro', '150000', 'Particular','2'),
	('A', '2011-04-19 10:00:00', '2019-05-09 10:00:00', '125000', '2019-05-07 10:00:00', 'Juan', '125000', 'Particular','1'),
	('D', '2011-04-19 10:00:00', '2019-05-13 10:00:00', '125000', '2019-05-10 10:00:00', 'Francisco', '150000', 'Particular','1'),
	('D', '2011-04-19 10:00:00', '2019-05-26 10:00:00', '125000', '2019-05-17 10:00:00', 'Francisco', '125000', 'Particular', '1'),
	('C', '2011-04-19 10:00:00', '2019-05-15 10:00:00', '250000', '2019-05-05 10:00:00', 'Diego', '250000', 'Particular','3'),
	('E', '2011-04-19 10:00:00', '2019-05-18 10:00:00', '250000', '2019-05-17 10:00:00', 'Sebastian', '53000', 'Empresa','3'),
	('B', '2011-04-19 10:00:00', '2019-05-23 10:00:00', '150000', '2019-05-22 10:00:00', 'Pedro', '150000', 'Empresa','2'),
	('A', '2011-04-19 10:00:00', '2019-05-09 10:00:00', '125000', '2019-05-07 10:00:00', 'Juan', '125000', 'Empresa','2'),
	('C', '2011-04-19 10:00:00', '2019-05-16 10:00:00', '250000', '2019-05-15 10:00:00', 'Diego', '250000', 'Empresa','4');

INSERT INTO `dbic`.`usuario` (`password`,`rol`,`usuario`)
	VALUES
	('colocolo', 'administrador', 'ssalazar'),
	('123', 'administrador', 'mingeso'),
	('123', 'administrador', 'user'),
	('13deOctubre', 'usuario', 'marratia');

