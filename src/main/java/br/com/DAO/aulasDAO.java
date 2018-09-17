package br.com.DAO;

import java.sql.Connection;

import br.com.entities.Aulas;
import br.com.jdbc.ConnectionDB;

public class aulasDAO {
	
	Connection con;
	
	public aulasDAO{
		con = ConnectionDB.getConnection();
	} 
	
	
	
	

}
