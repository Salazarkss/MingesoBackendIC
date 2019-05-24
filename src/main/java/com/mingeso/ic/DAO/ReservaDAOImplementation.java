package com.mingeso.ic.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaDAOImplementation extends JdbcDaoSupport implements ReservaDAO{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	HabitacionDAO habitacionDAO;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertReserva(Reserva reserva) {
		String query = "INSERT INTO reserva (`codigo`, `fecha_reserva`, `fin`, `valor_final`, `inicio`, `nombre`, `valor`, `habitacion_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(query, new Object[]{reserva.getCodigo(), reserva.getFecha_reserva(), reserva.getFin(),
			reserva.getFinal_descuento(), reserva.getInicio(), reserva.getNombre(), reserva.getValor(), reserva.getHabitacion().getId()});
		
	}

	@Override
	public Reserva getReservaById(int id) {
		String query = "SELECT * FROM reserva WHERE reserva_id = ?";
		return (Reserva)getJdbcTemplate().queryForObject(query, new Object[]{id}, new RowMapper<Reserva>(){
			@Override
			public Reserva mapRow(ResultSet resultSet, int rwNumber) throws SQLException{
				Reserva reserva = new Reserva();
				reserva.setId(resultSet.getInt("reserva_id"));
				reserva.setCodigo(resultSet.getString("codigo"));
				reserva.setFecha_reserva(resultSet.getTimestamp("fecha_reserva"));
				reserva.setFin(resultSet.getTimestamp("fin"));
				reserva.setFinal_descuento(resultSet.getInt("valor_final"));
				reserva.setInicio(resultSet.getTimestamp("inicio"));
				reserva.setNombre(resultSet.getString("nombre"));
				reserva.setValor(resultSet.getInt("valor"));
				reserva.setHabitacion(habitacionDAO.getHabitacionById((int)resultSet.getInt("habitacion_id")));
				return reserva;
			}
		});
	}

	@Override
	public List<Reserva> getAll() {
		String query = "SELECT * FROM reserva";
		List<Map<String, Object>> reservaRow = getJdbcTemplate().queryForList(query);
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		for(Map<String, Object> row:reservaRow) {
			Reserva reserva = new Reserva();
			reserva.setId((int)row.get("reserva_id"));
			reserva.setCodigo((String)row.get("codigo"));
			reserva.setFecha_reserva((Timestamp)row.get("fecha_reserva"));
			reserva.setFin((Timestamp)row.get("fin"));
			reserva.setFinal_descuento((int)row.get("valor_final"));
			reserva.setInicio((Timestamp)row.get("inicio"));
			reserva.setNombre((String)row.get("nombre"));
			reserva.setValor((int)row.get("valor"));
			reserva.setHabitacion(habitacionDAO.getHabitacionById((int)row.get("habitacion_id")));
			reservas.add(reserva);
		}
		return reservas;
	}

	@Override
	public void deleteReserva(int id) {
		String query = "DELETE FROM reserva where reserva_id = ?";
		getJdbcTemplate().update(query, new Object[]{id});
	}

}
