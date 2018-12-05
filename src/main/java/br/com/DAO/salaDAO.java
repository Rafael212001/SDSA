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

	public int listarContadorM(int numero) {
		int i = 0;
		String sql = "SELECT contadorM FROM Salas WHERE numero = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numero);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i = rs.getInt("contadorM");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int listarContadorT(int numero) {
		int i = 0;
		String sql = "SELECT contadorT FROM Salas WHERE numero = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numero);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i = rs.getInt("contadorT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int listarContadorN(int numero) {
		int i = 0;
		String sql = "SELECT contadorN FROM Salas WHERE numero = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numero);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i = rs.getInt("contadorN");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public void almentarContadorM(int numero, int contador) {
		String sql = "UPDATE Salas SET contadorM = ? WHERE numero = ?";
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
	
	public void almentarContadorT(int numero, int contador) {
		String sql = "UPDATE Salas SET contadorT = ? WHERE numero = ?";
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
	
	public void almentarContadorN(int numero, int contador) {
		String sql = "UPDATE Salas SET contadorN = ? WHERE numero = ?";
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
	
	public void diminuirContadorM(int numero, int contador) {
		String sql = "UPDATE Salas SET contadorM = ? WHERE numero = ?";
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
	
	public void diminuirContadorT(int numero, int contador) {
		String sql = "UPDATE Salas SET contadorT = ? WHERE numero = ?";
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
	
	public void diminuirContadorN(int numero, int contador) {
		String sql = "UPDATE Salas SET contadorN = ? WHERE numero = ?";
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