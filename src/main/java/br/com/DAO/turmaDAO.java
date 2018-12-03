package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Curso;
import br.com.entities.Turma;
import br.com.jdbc.ConnectionDB;

public class turmaDAO {

	Connection con;

	public turmaDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean inserir(Turma t) {
		String sql = "INSERT INTO Turmas (nome, periodo, semestre, id_curso, ativado) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNome());
			ps.setInt(2, t.getPeriodo());
			ps.setInt(3, t.getSemestre());
			ps.setInt(4, t.getId_curso());
			ps.setInt(5, 1);

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int pegarSemestre(int i) {
		int f = 0;
		String sql = "SELECT semestre FROM Turmas WHERE id = ? AND ativado = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = rs.getInt("semestre");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public List<Turma> listarTodos() {
		List<Turma> list = new ArrayList<Turma>();
		String sql = "SELECT t.*, c.nome AS nomeCurso FROM Turmas t INNER JOIN Cursos c ON t.id_curso = c.id WHERE t.ativado = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Turma t = new Turma();
				t.setId(rs.getInt("id"));
				t.setNome(rs.getString("nome"));
				t.setPeriodo(rs.getInt("periodo"));
				t.setSemestre(rs.getInt("semestre"));
				t.setId_curso(rs.getInt("id_curso"));
				t.setCurso(new Curso(t.getId_curso(), rs.getString("nomeCurso"), null));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Turma> listarPorCurso(int i){
		List<Turma> list = new ArrayList<Turma>();
		String sql = "SELECT * FROM Turmas WHERE id_curso = ? AND ativado = 1";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Turma t = new Turma();
				t.setId(rs.getInt("id"));
				t.setNome(rs.getString("nome"));
				t.setPeriodo(rs.getInt("periodo"));
				t.setSemestre(rs.getInt("semestre"));
				t.setId_curso(rs.getInt("id_curso"));
				list.add(t);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	public Turma buscarTurma(int id) {
		String sql = "SELECT * FROM Turmas WHERE id = ? AND ativado = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Turma t = new Turma();
				t.setId(rs.getInt("id"));
				t.setNome(rs.getString("nome"));
				t.setPeriodo(rs.getInt("periodo"));
				t.setSemestre(rs.getInt("semestre"));
				t.setId_curso(rs.getInt("id_curso"));

				return t;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public int listarId(int i) {
		int f = 0;
		String sql = "SELECT qtd_semestre FROM Cursos WHERE id = ? AND ativado = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = rs.getInt("qtd_semestre");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public boolean editar(Turma t) {
		String sql = "UPDATE Turmas SET nome = ?, periodo = ?, "
				+ " semestre =?, id_curso = ? WHERE id = ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(5, t.getId());
			ps.setString(1, t.getNome());
			ps.setInt(2, t.getPeriodo());
			ps.setInt(3, t.getSemestre());
			ps.setInt(4, t.getId_curso());

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
		String sql = "UPDATE Turmas SET ativado = 2 WHERE id = ? ";

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
