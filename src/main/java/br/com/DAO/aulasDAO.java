package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Aulas;
import br.com.entities.Coordenador;
import br.com.entities.Curso;
import br.com.entities.Disciplina;
import br.com.entities.Professor;
import br.com.entities.Salas;
import br.com.entities.Turma;
import br.com.jdbc.ConnectionDB;

public class aulasDAO {
	Connection con;

	public aulasDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean inserir(int idCurso, int idTurma, int idDisciplina, int idColaborador, int idCoordenador,
			int periodo) {
		String sql = "INSERT INTO Aulas (id_cursos, id_turmas, id_disciplina, id_colaborador, id_coordenador, periodo) VALUES (?,?,?,?,?,?) ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idCurso);
			ps.setInt(2, idTurma);
			ps.setInt(3, idDisciplina);
			ps.setInt(4, idColaborador);
			ps.setInt(5, idCoordenador);
			ps.setInt(6, periodo);

			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}

	public List<Aulas> listarTodasSemSala() {
		List<Aulas> list = new ArrayList<Aulas>();
		String sql = " SELECT a.id as id, c.nome as curso, t.nome as turma, d.nome as disciplina, co.nome as colaborador, cr.nome as coordenador"
				+ " FROM aulas a " + " INNER JOIN cursos c ON (a.id_cursos = c.id)"
				+ " INNER JOIN turmas t ON (a.id_turmas = t.id)"
				+ " INNER JOIN disciplinas d ON (a.id_disciplina = d.id)"
				+ " INNER JOIN colaboradores co ON (a.id_colaborador = co.id)"
				+ " INNER JOIN coordenadores cr ON (a.id_coordenador = cr.id) " + " WHERE a.id_sala is NULL ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Aulas a = new Aulas(rs.getInt("id"), new Curso(null, rs.getString("curso"), null),
						new Turma(null, rs.getString("turma"), null, null, null),
						new Disciplina(null, rs.getString("disciplina"), null, null, null),
						new Professor(null, rs.getString("colaborador"), null, null, null, null, null, null),
						new Coordenador(null, rs.getString("coordenador"), null, null,null), null, null, null, null);
				list.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Aulas> listarAulasAlocadas(Integer dia_semana, Integer numero, Integer periodo) {
		List<Aulas> list = new ArrayList<Aulas>();
		String sql = " SELECT  a.*, c.nome as curso, t.nome as turma, d.nome as disciplina, co.nome as professor "
				+ "FROM aulas a " + " INNER JOIN cursos c ON (a.id_cursos = c.id) "
				+ " INNER JOIN turmas t ON (a.id_turmas = t.id) "
				+ " INNER JOIN disciplinas d ON (a.id_disciplina = d.id) "
				+ "INNER JOIN colaboradores co ON (a.id_colaborador = co.id) "
				+ " WHERE id_sala = ? AND dia_semana = ? AND a.periodo = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numero);
			ps.setInt(2, dia_semana);
			ps.setInt(3, periodo);
			System.out.println(ps.toString());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Aulas a = new Aulas(rs.getInt("id"), new Curso(null, rs.getString("curso"), null),
						new Turma(null, rs.getString("turma"), null, null, null),
						new Disciplina(null, rs.getString("disciplina"), null, null, null),
						new Professor(null, rs.getString("professor"), null, null, null, null, null, null), null,
						rs.getInt("id_sala"), rs.getInt("dia_semana"), rs.getInt("carga"), rs.getInt("periodo"));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean excluir(Integer id) {
		String sql = "DELETE * FROM professor " + "WHERE id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean alocarSala(Aulas aula, Integer numeroSala, Integer dia_semana, Integer carga, int periodo) {
		String sql = "UPDATE aulas SET id_sala = ?, dia_semana = ?, carga = ?, periodo = ? WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numeroSala);
			ps.setInt(2, dia_semana);
			ps.setInt(3, carga);
			ps.setInt(4, periodo);
			ps.setInt(5, aula.getId());

			if (ps.executeUpdate() != 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean desalocar(Aulas aula) {
		String sql = "UPDATE aulas SET id_sala = NULL, dia_semana = NULL, carga = NULL " + "WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, aula.getId());

			if (ps.executeUpdate() != 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean excluir(Aulas a) {
		String sql = "DELETE FROM Aulas WHERE id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getId());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
