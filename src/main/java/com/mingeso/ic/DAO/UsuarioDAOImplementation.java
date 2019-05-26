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
public class UsuarioDAOImplementation extends JdbcDaoSupport implements UsuarioDAO{
	
	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertUsuario(Usuario user) {
		String query = "INSERT INTO usuario (password, rol, usuario) VALUES (?, ?, ?)";
		getJdbcTemplate().update(query, new Object[]{user.getPassword(), user.getRol(), user.getUsuario()});
		
	}

	@Override
	public Usuario getUsuarioById(int id) {
		String query = "SELECT * FROM usuario WHERE usuario_id = ?";
		return (Usuario)getJdbcTemplate().queryForObject(query, new Object[]{id}, new RowMapper<Usuario>(){
			@Override
			public Usuario mapRow(ResultSet resultSet, int rwNumber) throws SQLException{
				Usuario user = new Usuario();
				user.setId(resultSet.getInt("usuario_id"));
				user.setPassword(resultSet.getString("password"));
				user.setRol(resultSet.getString("rol"));
				user.setUsuario(resultSet.getString("usuario"));
				return user;
			}
		});
	}

	@Override
	public List<Usuario> getAll() {
		String query = "SELECT * FROM usuario";
		List<Map<String, Object>> usuarioRow = getJdbcTemplate().queryForList(query);
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for(Map<String, Object> row:usuarioRow) {
			Usuario user = new Usuario();
			user.setId((int)row.get("usuario_id"));
			user.setPassword((String)row.get("password"));
			user.setRol((String)row.get("rol"));
			user.setUsuario((String)row.get("usuario"));
			usuarios.add(user);
		}
		return usuarios;
	}

	@Override
	public void deleteUsuario(int id) {
		String query = "DELETE FROM usuario where usuario_id = ?";
		getJdbcTemplate().update(query, new Object[]{id});
	}

}
