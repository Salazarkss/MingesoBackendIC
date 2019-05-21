package com.mingeso.ic.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
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
public class HabitacionDAOImplementation extends JdbcDaoSupport implements HabitacionDAO{
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertHabitacion(Habitacion hab) {
		String query = "INSERT INTO habitacion (habitacion_id, number, tipo) VALUES (?, ?, ?)";
		getJdbcTemplate().update(query, new Object[]{hab.getId(), hab.getNumber(), hab.getTipo()});
		
	}

	@Override
	public Habitacion getHabitacionById(int id) {
		String query = "SELECT * FROM habitacion WHERE habitacion_id = ?";
		return (Habitacion)getJdbcTemplate().queryForObject(query, new Object[]{id}, new RowMapper<Habitacion>(){
			@Override
			public Habitacion mapRow(ResultSet resultSet, int rwNumber) throws SQLException{
				Habitacion hab = new Habitacion();
				hab.setId(resultSet.getInt("habitacion_id"));
				hab.setNumber(resultSet.getString("number"));
				hab.setTipo(resultSet.getString("tipo"));
				return hab;
			}
		});
	}

	@Override
	public List<Habitacion> getAll() {
		String query = "SELECT * FROM habitacion";
		List<Map<String, Object>> habitacionRow = getJdbcTemplate().queryForList(query);
		
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		for(Map<String, Object> row:habitacionRow) {
			Habitacion hab = new Habitacion();
			hab.setId((int)row.get("habitacion_id"));
			hab.setNumber((String)row.get("number"));
			hab.setTipo((String)row.get("tipo"));
			habitaciones.add(hab);
		}
		return habitaciones;
	}

	@Override
	public void deleteHabitacion(int id) {
		String query = "DELETE FROM habitacion where habitacion_id = ?";
		getJdbcTemplate().update(query, new Object[]{id});
	}

}
