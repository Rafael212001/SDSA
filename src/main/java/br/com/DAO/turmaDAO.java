package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.entities.Turma;
import br.com.jdbc.ConnectionDB;

public class turmaDAO {
	
	Connection con;
	
	public turmaDAO() {
		con = ConnectionDB.getConnection();
	}
	
	public boolean inserir(Turma t) {
		String sql = "INSERT INTO turma (nome, qtd_alunos, divisao, periodo, semestre )"
				+ "VALUES (?,?,?,?,?)";
		
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
	
	
	


}
