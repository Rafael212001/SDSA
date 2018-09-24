package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Disciplina;
import br.com.jdbc.ConnectionDB;

public class disciplinaDAO {

	Connection con;

	public disciplinaDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean inserir(Disciplina d) {
		String sql = "INSERT INTO Disciplinas(?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getNome());
			ps.setInt(2, d.getCarga_hora());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Disciplina> listarTodos() {
		List<Disciplina> list = new ArrayList<Disciplina>();
		String sql = "SELECT * FROM Disciplinas ";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Disciplina d = new Disciplina(rs.getInt("id"), rs.getString("nome"), rs.getInt("carga_hora"),
						rs.getInt("id_turma"));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean excluir(Integer id) {
		String sql = "DELETE * FROM Disciplinas " + "WHERE id = ? ";

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
