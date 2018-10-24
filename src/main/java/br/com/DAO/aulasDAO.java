package br.com.DAO;

import java.security.GeneralSecurityException;
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
	
	public List<Aulas> listarTodasSemSala(){
		List<Aulas> list = new ArrayList<Aulas>();
		String sql = " SELECT a.id as id, c.nome as curso, t.nome as turma, d.nome as disciplina, co.nome as colaborador, cr.nome as coordenador" + 
				" FROM aulas a " + 
				" INNER JOIN cursos c ON (a.id_cursos = c.id)" + 
				" INNER JOIN turmas t ON (a.id_turmas = t.id)" + 
				" INNER JOIN disciplinas d ON (a.id_disciplina = d.id)" + 
				" INNER JOIN colaboradores co ON (a.id_colaborador = co.id)" + 
				" INNER JOIN coordenadores cr ON (a.id_coordenador = cr.id) "
				+ " WHERE a.id_sala is NULL ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Aulas a = new Aulas(rs.getInt("id"), new Curso(null, rs.getString("curso"), null), 
						new Turma(null, rs.getString("turma"),null, null, null, null, null ), 
						new Disciplina(null, rs.getString("disciplina"), null, null,null),
						new Professor(null, rs.getString("colaborador"), null, null, null, null ,null, null), 
						new Coordenador( null, rs.getString("coordenador"), null, null), 
						null,null,null);
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
	
	public boolean alocarSala(Aulas aula, Integer numeroSala, Integer dia_semana, Integer carga) {
		String sql = "UPDATE aulas SET id_sala = ?, dia_semana = ?, carga = ? "
				+ "WHERE id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numeroSala);
			ps.setInt(2, dia_semana);
			ps.setInt(3, carga);
			ps.setInt(4, aula.getId());			
			
			if(ps.executeUpdate() != 0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
