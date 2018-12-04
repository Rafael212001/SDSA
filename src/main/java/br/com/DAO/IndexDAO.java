package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.entities.Aulas;
import br.com.jdbc.ConnectionDB;

public class IndexDAO {
	
	Connection con;
	
	public IndexDAO() {
		con = ConnectionDB.getConnection();
	}
	
	public String listarTabela(int colaborador, int dia_semana, int periodo, int horario){
		String i = "";
		String sql = "SELECT a.id_sala, t.nome AS nomeTurma, c.nome AS nomeCurso, d.nome AS nomeDisciplina "
				+ " FROM Aulas a INNER JOIN turmas t INNER JOIN cursos c INNER JOIN disciplinas d "
				+ " ON a.id_turmas = t.id AND a.id_cursos = c.id AND a.id_disciplina = d.id "
				+ " WHERE a.id_colaborador = ? AND a.dia_semana = ? AND a.periodo = ? AND a.horario = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, colaborador);
			ps.setInt(2, dia_semana);
			ps.setInt(3, periodo);
			ps.setInt(4, horario);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aulas a = new Aulas();
				a.setNomeCurso(rs.getString("nomeCurso"));
				a.setNomeTurma(rs.getString("nomeTurma"));
				a.setNomeDisciplina(rs.getString("nomeDisciplina"));
				a.setId_sala(rs.getInt("id_sala"));
				
				i = "Sala: "+a.getId_sala()
				+"º \n Curso: "+a.getNomeCurso()
				+" \n Turma: "+a.getNomeTurma()
				+" \n Disc.: "+a.getNomeDisciplina();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
}
