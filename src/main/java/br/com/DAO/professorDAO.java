package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Professor;
import br.com.jdbc.ConnectionDB;

public class professorDAO {
	Connection con;
	
	public professorDAO() {
		con = ConnectionDB.getConnection();
	}
	
	public boolean inserir (Professor p) {
		String sql = "INSERT INTO Colaboradores (nome, disciplina_le, carga_hora, restante, tipo, foto)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getDisciplina_le());
			ps.setInt(3, p.getCarga_hora());
			ps.setInt(4, p.getRestante());
			ps.setInt(5, p.getTipo());
			ps.setInt(6, p.getFoto());
			
			if (ps.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		return false;
	}
	
	public List<Professor> listarTodos(){
		List<Professor> list = new ArrayList<Professor>();
		String sql = "SELECT * FROM Colaboradores ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Professor p = new Professor();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setDisciplina_le(rs.getString("disciplina_le"));
				p.setCarga_hora(rs.getInt("carga_hora")); 
				p.setRestante(rs.getInt("restante"));
				p.setTipo(rs.getInt("tipo"));
				p.setFoto(rs.getInt("foto"));
				p.setId_disciplina(rs.getInt("id_disciplina"));
				
				list.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean excluir(Integer id) {
		String sql = "DELETE * FROM Colaboradores " + "WHERE id = ? ";
		
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
