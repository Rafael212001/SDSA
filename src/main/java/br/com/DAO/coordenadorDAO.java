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
		String sql = "INSERT INTO Coordenadores (nome,login,senha,ativado)" + "VALUES(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getLogin());
			ps.setString(3, c.getSenha());
			ps.setInt(4, 1);

			if (ps.executeUpdate() == 1) {
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
		String sql = "SELECT * FROM Coordenadores WHERE ativado = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Coordenador c = new Coordenador();

				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));

				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean editar(Coordenador c) {
		String sql = "UPDATE Coordenadores SET nome = ?, login = ?, senha = ? WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(4, c.getId());
			ps.setString(1, c.getNome());
			ps.setString(2, c.getLogin());
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
		String sql = "UPDATE Coordenadores SET ativado = 2 WHERE id = ? ";

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

	public Coordenador buscaCoordenador(String nif) {
		String sql = "SELECT * FROM Coordenadores WHERE login = ? AND ativado = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nif);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Coordenador c = new Coordenador();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));

				return c;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Coordenador buscaCoordenador(int id) {
		String sql = "SELECT * FROM Coordenadores WHERE id = ? AND ativado = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Coordenador c = new Coordenador();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));

				return c;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
