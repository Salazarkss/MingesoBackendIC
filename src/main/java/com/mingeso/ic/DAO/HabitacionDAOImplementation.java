package com.mingeso.ic.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.mingeso.ic.model.Habitacion;
import com.mingeso.ic.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class HabitacionDAOImplementation extends JdbcDaoSupport implements HabitacionDAO{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	TipoDAO tipoDAO;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertHabitacion(Habitacion hab) {
		String query = "INSERT INTO habitacion (habitacion_id, number, tipo_tipo_id) VALUES (?, ?, ?)";
		getJdbcTemplate().update(query, new Object[]{hab.getId(), hab.getNumber(), hab.getTipo().getId()});
		
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
				hab.setTipo(tipoDAO.getTipoById(resultSet.getInt("tipo_tipo_id")));
				hab.setTipoReserva(resultSet.getString("tipo_reserva"));
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
			hab.setTipo(tipoDAO.getTipoById((int)row.get("tipo_tipo_id")));
			hab.setTipoReserva(row.get("tipo_reserva").toString());
			habitaciones.add(hab);
		}
		return habitaciones;
	}

	@Override
	public void updateHabitacion(Habitacion hab){
		String query = "UPDATE habitacion SET tipo_tipo_id = ? WHERE habitacion_id = ?";
		Tipo tipo = hab.getTipo();
		int id = tipo.getId();
		getJdbcTemplate().update(query, id, hab.getId());
	}

	@Override
	public void updateDisponibilidad(Habitacion hab){
		String query = "UPDATE habitacion SET tipo_reserva = ? WHERE habitacion_id = ?";
		String tipo = hab.getTipoReserva();
		int id = hab.getId();
		getJdbcTemplate().update(query, hab.getTipoReserva(), id);
		Habitacion as =getHabitacionById(id);
	}

	@Override
	public void deleteHabitacion(int id) {

		String query = "DELETE FROM habitacion where habitacion_id = ?";
		getJdbcTemplate().update(query, new Object[]{id});
	}

}
