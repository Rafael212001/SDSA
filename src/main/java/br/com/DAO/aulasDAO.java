package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.entities.Aulas;
import br.com.entities.Curso;
import br.com.jdbc.ConnectionDB;


public class aulasDAO {
	Connection con;
	
	public aulasDAO() {
		con = ConnectionDB.getConnection();
	}
	
	public List<Aulas> listarTodos(){
		List<Aulas> list = new ArrayList<Aulas>();
		String sql = " SELECT c.nome as curso, t.nome as turma, d.nome as disciplina, co.nome as colaborador, cr.nome as coordenador" + 
				"FROM aulas " + 
				"INNER JOIN cursos c ON (a.id_cursos = c.id)" + 
				"INNER JOIN turmas t ON (a.id_turmas = t.id)" + 
				"INNER JOIN disciplinas d ON (a.id_disciplina = d.id)" + 
				"INNER JOIN colaboradores co ON (a.id_colaborador = co.id)" + 
				"INNER JOIN coordenadores cr ON (a.id_coordenador = cr.id) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Aulas a = new Aulas(rs.getInt("id"), new Curso(null, rs.getString("curso"), null), rs.getInt("id_turmas"), rs.getInt("id_disciplina"), rs.getInt("id_colaborador"), 
						rs.getInt("id_coordenador"), rs.getInt("id_sala"));
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
}
