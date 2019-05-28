INSERT INTO `dbic`.`habitacion` (`number`, `tipo_tipo_id`)
	VALUES
	('250', 1),
	('251', 2),
	('252', 3),
	('302', 4),
	('303', 5),
	('401', 6),
	('402', 7);

INSERT INTO `dbic`.`tipo` (`tipo`,`valor` )
	VALUES
	('Simple', '15000'),
	('Doble', '30000'),
	('Matrimonial', '45000');

INSERT INTO `dbic`.`reserva` (`codigo`, `fecha_reserva`, `fin`, `valor_final`, `inicio`, `nombre`, `valor`, `habitacion_id`)
	VALUES
	('A', '2011-04-19 10:00:00', '2019-05-26 10:00:00', '65000', '2012-05-22 10:00:00', 'Ignacia Arratia', '65000', '1'),
	('B', '2011-04-19 10:00:00', '2019-05-21 10:00:00', '150000', '2012-05-19 10:00:00', 'Pedro', '150000', '2'),
	('A', '2011-04-19 10:00:00', '2019-05-09 10:00:00', '125000', '2012-05-07 10:00:00', 'Juan', '125000', '1'),
	('C', '2011-04-19 10:00:00', '2019-05-15 10:00:00', '250000', '2012-05-05 10:00:00', 'Diego', '250000', '3');

INSERT INTO `dbic`.`usuario` (`password`,`rol`,`usuario`)
	VALUES
	('colocolo', 'administrador', 'ssalazar'),
	('123', 'administrador', '123'),
	('13deOctubre', 'usuario', 'marratia');

