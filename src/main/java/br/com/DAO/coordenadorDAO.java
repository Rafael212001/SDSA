package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Coordenador;
import br.com.jdbc.ConnectionDB;


public class coordenadorDAO {

	Connection con;

	public coordenadorDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean inserir(Coordenador c) {
		String sql = "INSERT INTO coordenador (nome,login,senha)" + "VALUES(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setInt(2, c.getLogin());
			ps.setString(3, c.getSenha());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;

	}

	public List<Coordenador> listarTodos() {
		List<Coordenador> list = new ArrayList<Coordenador>();
		String sql = "SELECT * FROM coordenador ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Coordenador c = new Coordenador(rs.getInt("id"), rs.getString("nome"), rs.getInt("login"),
						rs.getString("senha"));

				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean editar(Coordenador c) {
		String sql = "UPDATE coordenador SET " + " nome = ?," + " login = ?," + " senha = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setInt(2, c.getLogin());
			ps.setString(3, c.getSenha());

			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean excluir(Integer id) {
		String sql = "DELETE * FROM coordenador " + "WHERE id = ? ";

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
