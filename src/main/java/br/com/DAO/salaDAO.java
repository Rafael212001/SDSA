package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Salas;
import br.com.jdbc.ConnectionDB;

public class salaDAO {
	Connection con;

	public salaDAO() {
		con = ConnectionDB.getConnection();
	}

}