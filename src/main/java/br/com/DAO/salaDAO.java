package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Curso;
import br.com.entities.Salas;
import br.com.jdbc.ConnectionDB;

public class salaDAO {

	Connection con;

	public salaDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean inserir(Salas s) {
		String sql = "INSERT INTO Salas(numero)" + "VALUES (?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, s.getNumero());

			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Salas> listarTodos() {
		List<Salas> list = new ArrayList<Salas>();
		String sql = "SELECT * FROM Salas";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Salas s = new Salas( rs.getInt("id"), rs.getInt("numeros"));
				list.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;

	}
	
	public boolean excluir(Integer id) {
		String sql = "DELETE * FROM Salas " + "WHERE id = ? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}