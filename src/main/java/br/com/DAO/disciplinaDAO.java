package br.com.DAO;

import java.sql.Connection;

import br.com.entities.Disciplina;
import br.com.jdbc.ConnectionDB;

public class disciplinaDAO {
	
	Connection con;
	
	public disciplinaDAO() {
		con = ConnectionDB.getConnection();
	}
	
//	public boolean inserir(Disciplina d) {
//		String sql = "INSERT INTO disciplina(?,?)";
//		
//	}
	

}
