package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Carga_horaria_restante;
import br.com.entities.Curso;
import br.com.jdbc.ConnectionDB;

public class carga_horaria_restanteDAO {

	Connection con;

	public carga_horaria_restanteDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean inserir(Carga_horaria_restante c) {

		String sql = "INSERT INTO Carga_horaria_restante(tempo)" + "VALUES (?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, c.getTempo());

			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
//	public List<Carga_horaria_restante> listarTodos() {
//		List<Carga_horaria_restante> list = new ArrayList<Carga_horaria_restante>();
//		String sql = "SELECT * FROM carga_horaria_restante";
//		
//		PreparedStatement ps = con.prepareStatement(sql);
//	}
}
