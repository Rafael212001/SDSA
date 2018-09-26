package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Turma;
import br.com.jdbc.ConnectionDB;

public class turmaDAO {

	Connection con;

	public turmaDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean inserir(Turma t) {
		String sql = "INSERT INTO Turmas (nome, qtd_alunos, divisao, periodo, semestre )" + "VALUES (?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNome());
			ps.setInt(2, t.getQtd_alunos());
			ps.setInt(3, t.getDivisao());
			ps.setInt(4, t.getPeriodo());
			ps.setInt(5, t.getSemestre());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Turma> listarTodos() {
		List<Turma> list = new ArrayList<Turma>();
		String sql = "SELECT * FROM Turmas";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Turma t = new Turma();
				t.setId(rs.getInt("id"));
				t.setNome(rs.getString("nome"));
				t.setQtd_alunos(rs.getInt("qtd_alunos"));
				t.setDivisao(rs.getInt("divisao"));
				t.setPeriodo(rs.getInt("periodo"));
				t.setSemestre(rs.getInt("semestre"));
				t.setId_curso(rs.getInt("id_curso"));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean excluir(Integer id) {
		String sql = "DELETE * FROM Turmas " + "WHERE id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
