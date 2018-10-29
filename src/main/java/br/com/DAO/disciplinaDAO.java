package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entities.Disciplina;
import br.com.jdbc.ConnectionDB;

public class disciplinaDAO {

	Connection con;

	public disciplinaDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean inserir(Disciplina d) {
		String sql = "INSERT INTO Disciplinas (nome, carga_hora, semestre, id_curso) VALUES (?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getNome());
			ps.setInt(2, d.getCarga_hora());
			ps.setInt(3, d.getSemestre());
			ps.setInt(4, d.getId_curso());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Disciplina> listarTodos(int i) {
		List<Disciplina> list = new ArrayList<Disciplina>();
		String sql = "SELECT * FROM Disciplinas WHERE id_curso = ?";

		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Disciplina d = new Disciplina();
				d.setId(rs.getInt("id"));
				d.setNome(rs.getString("nome"));
				d.setCarga_hora(rs.getInt("carga_hora"));
				d.setSemestre(rs.getInt("semestre"));
				d.setId_curso(rs.getInt("id_curso"));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int listarId(int i) {
		int f = 0;
		String sql = "SELECT qtd_semestre FROM Cursos WHERE id = ?";

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
	
	public Disciplina buscarDisciplina(int id) {
		String sql = "SELECT * FROM Disciplinas WHERE id = ? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Disciplina d = new Disciplina();
				d.setId(rs.getInt("id"));
				d.setNome(rs.getString("nome"));
				d.setCarga_hora(rs.getInt("carga_hora"));
				d.setSemestre(rs.getInt("semestre"));
				d.setId_curso(rs.getInt("id_curso"));
				
				return d;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean editar(Disciplina d) {
		String sql = "UPDATE Disciplinas SET nome = ?, carga_hora= ?, semestre = ? WHERE id = ? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(4, d.getId());
			ps.setString(1, d.getNome());
			ps.setInt(2, d.getCarga_hora());
			ps.setInt(3, d.getSemestre());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean excluir(Integer id) {
		String sql = "DELETE FROM Disciplinas WHERE id = ? ";

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
