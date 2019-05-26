INSERT INTO `dbic`.`habitacion` (`number`, `tipo_tipo_id`)
	VALUES
	('250', 1),
	('251', 2),
	('252', 3);

INSERT INTO `dbic`.`tipo` (`tipo`,`valor` )
	VALUES
	('Simple', '15000'),
	('Doble', '30000'),
	('Matrimonial', '45000');

INSERT INTO `dbic`.`reserva` (`codigo`, `fecha_reserva`, `fin`, `valor_final`, `inicio`, `nombre`, `valor`, `habitacion_id`)
	VALUES
	('ABC', '2011-04-19 10:00:00', '2012-04-21 10:00:00', '50000', '2012-04-19 10:00:00', 'Ignacia Arratia', '65000', '1'),
	('ABC', '2011-04-19 10:00:00', '2012-04-21 10:00:00', '50000', '2012-04-19 10:00:00', 'Ignacia Arratia', '65000', '2');

INSERT INTO `dbic`.`usuario` (`password`,`rol`,`usuario`)
	VALUES
	('colocolo', 'administrador', 'ssalazar'),
	('13deOctubre', 'usuario', 'marratia');

