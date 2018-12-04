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

	public int listarContador(int numero) {
		int i = 0;
		String sql = "SELECT contador FROM Salas WHERE numero = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numero);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i = rs.getInt("contador");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public void almentarContador(int numero, int contador) {
		String sql = "UPDATE Salas SET contador = ? WHERE numero = ?";
		contador = contador + 1;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, contador);
			ps.setInt(2, numero);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void diminuirContador(int numero, int contador) {
		String sql = "UPDATE Salas SET contador = ? WHERE numero = ?";
		contador = contador - 1;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, contador);
			ps.setInt(2, numero);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}