package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.entities.Aulas;
import br.com.jdbc.ConnectionDB;


public class aulasDAO {
	Connection con;
	
	public aulasDAO() {
		con = ConnectionDB.getConnection();
	}
	
	public List<Aulas> listarTodos(){
		List<Aulas> list = new ArrayList<Aulas>();
		String sql = "SELECT * FROM aulas ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Aulas a = new Aulas(rs.getInt("id"), rs.getInt("id_cursos"), rs.getInt("id_turmas"), rs.getInt("id_disciplina"), rs.getInt("id_colaborador"), 
						rs.getInt("id_colaborado"), rs.getInt("id_sala"));
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
