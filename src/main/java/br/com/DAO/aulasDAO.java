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
import br.com.entities.Turma;
import br.com.jdbc.ConnectionDB;

public class aulasDAO {
	Connection con;

	public aulasDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean inserir(int idCurso, int idTurma, int idDisciplina, int idColaborador, int idCoordenador,
			int periodo, int carga) {
		String sql = " INSERT INTO Aulas (id_cursos, id_turmas, id_disciplina, id_colaborador, id_coordenador, periodo, carga) VALUES (?,?,?,?,?,?,?) ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idCurso);
			ps.setInt(2, idTurma);
			ps.setInt(3, idDisciplina);
			ps.setInt(4, idColaborador);
			ps.setInt(5, idCoordenador);
			ps.setInt(6, periodo);
			ps.setInt(7, carga);

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}

	public Aulas listarAulas(int id) {

		String sql = "SELECT * FROM Aulas WHERE id = ?";
		Aulas a = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Aulas(rs.getInt("id"), new Curso(rs.getInt("id_cursos"), null, null),
						new Turma(rs.getInt("id_turmas"), null, null, null, null),
						new Disciplina(rs.getInt("id_disciplina"), null, null, null, null),
						new Professor(rs.getInt("id_colaborador"), null, null, null, null, null),
						new Coordenador(rs.getInt("id_coordenador"), null, null, null, null), rs.getInt("id_sala"),
						rs.getInt("dia_semana"), rs.getInt("carga"), rs.getInt("periodo"), rs.getString("horario"),
						null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}

	public int contarSala(int sala, Integer periodo, Integer dia_semana) {
		int cont = 0;
		String sql = "SELECT COUNT(id_sala) as cont FROM aulas WHERE id_sala = ? AND periodo = ? AND dia_semana = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sala);
			ps.setInt(2, periodo);
			ps.setInt(3, dia_semana);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cont = rs.getInt("cont");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cont;
	}
	
	public int aulaColab(int id) {
		int cont = 0;
		String sql = "SELECT COUNT(horario) AS cont FROM aulas WHERE id_sala IS NOT NULL AND id_colaborador = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cont = rs.getInt("cont");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cont;
	}

	public List<Aulas> verAulas(int sala, Integer periodo, Integer dia_semana) {
		List<Aulas> list = new ArrayList<Aulas>();
		String sql = "SELECT horario FROM aulas WHERE id_sala = ? AND periodo = ? AND dia_semana = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sala);
			ps.setInt(2, periodo);
			ps.setInt(3, dia_semana);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aulas a = new Aulas();
				a.setHorario(rs.getString("horario"));
				list.add(a);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Aulas> disponibilidade(Integer periodo, Integer dia_semana, Integer colaborador){
		List<Aulas> list = new ArrayList<>();
		String sql = "SELECT horario FROM aulas WHERE periodo = ? AND dia_semana = ? AND id_colaborador = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, periodo);
			ps.setInt(2, dia_semana);
			ps.setInt(3, colaborador);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aulas a = new Aulas();
				a.setHorario(rs.getString("horario"));
				list.add(a);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public int pegarIdDisciplina(int j) {
		int i = 0;
		String sql = "SELECT id_disciplina FROM Aulas WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, j);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = rs.getInt("id_disciplina");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public List<Aulas> listarTodasSemSala(int periodo) {
		List<Aulas> list = new ArrayList<Aulas>();
		String sql = " SELECT a.id as id, c.nome as curso, t.nome as turma, d.nome as disciplina, co.nome as colaborador, cr.nome as coordenador, "
				+ " COUNT(a.id) as qtde " 
				+ " FROM aulas a "
				+ " INNER JOIN cursos c ON (a.id_cursos = c.id) "
				+ " INNER JOIN turmas t ON (a.id_turmas = t.id) "
				+ " INNER JOIN disciplinas d ON (a.id_disciplina = d.id) "
				+ " INNER JOIN colaboradores co ON (a.id_colaborador = co.id) "
				+ " INNER JOIN coordenadores cr ON (a.id_coordenador = cr.id) " 
				+ " WHERE a.id_sala is NULL AND a.periodo = ?"
				+ " GROUP BY a.id_cursos, a.id_turmas, a.id_disciplina, a.id_colaborador, a.id_coordenador";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, periodo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Aulas a = new Aulas(rs.getInt("id"), new Curso(null, rs.getString("curso"), null),
						new Turma(null, rs.getString("turma"), null, null, null),
						new Disciplina(null, rs.getString("disciplina"), null, null, null),
						new Professor(null, rs.getString("colaborador"), null, null, null, null),
						new Coordenador(null, rs.getString("coordenador"), null, null, null), null, null, null, null,
						null, rs.getInt("qtde"));
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
				+ " FROM aulas a " 
				+ " INNER JOIN cursos c ON (a.id_cursos = c.id) "
				+ " INNER JOIN turmas t ON (a.id_turmas = t.id) "
				+ " INNER JOIN disciplinas d ON (a.id_disciplina = d.id) "
				+ " INNER JOIN colaboradores co ON (a.id_colaborador = co.id) "
				+ " WHERE id_sala = ? AND dia_semana = ? AND a.periodo = ? " 
				+ " ORDER BY(horario)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numero);
			ps.setInt(2, dia_semana);
			ps.setInt(3, periodo);
			System.out.println("Sala: " + numero + " atualizada.");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Aulas a = new Aulas(rs.getInt("id"), new Curso(null, rs.getString("curso"), null),
						new Turma(null, rs.getString("turma"), null, null, null),
						new Disciplina(null, rs.getString("disciplina"), null, null, null),
						new Professor(null, rs.getString("professor"), null, null, null, null), null,
						rs.getInt("id_sala"), rs.getInt("dia_semana"), rs.getInt("carga"), rs.getInt("periodo"),
						rs.getString("horario"), null);
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

	public boolean alocarSala(Aulas aula, Integer numeroSala, Integer dia_semana, int periodo, String horario) {
		String sql = " UPDATE aulas SET id_sala = ?, dia_semana = ?, horario = ? "
				+ " WHERE id_cursos = ? AND id_turmas = ? AND id_disciplina = ? AND id_colaborador = ? AND id_coordenador = ? AND id = ? AND periodo = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numeroSala);
			ps.setInt(2, dia_semana);
			ps.setString(3, horario);

			ps.setInt(4, aula.getCurso().getId());
			ps.setInt(5, aula.getTurma().getId());
			ps.setInt(6, aula.getDisciplina().getId());
			ps.setInt(7, aula.getProfessor().getId());
			ps.setInt(8, aula.getCoordenador().getId());
			ps.setInt(9, aula.getId());
			
			ps.setInt(10, periodo);
			
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
		String sql = "UPDATE aulas SET id_sala = NULL, dia_semana = NULL, horario = NULL WHERE id = ?";

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
		String sql = "DELETE FROM aulas WHERE id_cursos = ? AND id_turmas = ? AND id_disciplina = ? "
				+ " AND id_colaborador = ? AND id_coordenador = ? AND id_sala IS NULL";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getCurso().getId());
			ps.setInt(2, a.getTurma().getId());
			ps.setInt(3, a.getDisciplina().getId());
			ps.setInt(4, a.getProfessor().getId());
			ps.setInt(5, a.getCoordenador().getId());

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
