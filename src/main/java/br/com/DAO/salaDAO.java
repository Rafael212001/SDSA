package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.entities.Salas;
import br.com.jdbc.ConnectionDB;

public class salaDAO {
	
	Connection con;
	
public salaDAO() {
	con = ConnectionDB.getConnection();
}

/*public boolean inserir(Salas s) {
	String sql =  "INSERT INTO salas(numero)"
			+ "VALUES (?)";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,s.getNumero());
//		if(ps.executeQuery())
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

*/	
}