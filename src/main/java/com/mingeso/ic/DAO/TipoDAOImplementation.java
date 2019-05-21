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
public class TipoDAOImplementation extends JdbcDaoSupport implements TipoDAO{
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertTipo(Tipo tipo) {
		String query = "INSERT INTO tipo (tipo_id, tipo, valor) VALUES (?, ?, ?)";
		getJdbcTemplate().update(query, new Object[]{tipo.getId(), tipo.getTipo(), tipo.getValor()});
	}

	@Override
	public Tipo getTipoById(int id) {
		String query = "SELECT * FROM tipo WHERE tipo_id = ?";
		return (Tipo)getJdbcTemplate().queryForObject(query, new Object[]{id}, new RowMapper<Tipo>(){
			@Override
			public Tipo mapRow(ResultSet resultSet, int rwNumber) throws SQLException{
				Tipo tipo = new Tipo();
				tipo.setId(resultSet.getInt("tipo_id"));
				tipo.setTipo(resultSet.getString("tipo"));
				tipo.setValor(resultSet.getString("valor"));
				return tipo;
			}
		});
	}

	@Override
	public List<Tipo> getAll() {
		String query = "SELECT * FROM tipo";
		List<Map<String, Object>> tipoRow = getJdbcTemplate().queryForList(query);
		
		List<Tipo> tipos = new ArrayList<Tipo>();
		for(Map<String, Object> row:tipoRow) {
			Tipo tipo = new Tipo();
			tipo.setId((int)row.get("tipo_id"));
			tipo.setTipo((String)row.get("tipo"));
			tipo.setValor((String)row.get("valor"));
			tipos.add(tipo);
		}
		return tipos;
	}

	@Override
	public void deleteTipo(int id) {
		String query = "DELETE FROM tipo where tipo_id = ?";
		getJdbcTemplate().update(query, new Object[]{id});
	}

}
