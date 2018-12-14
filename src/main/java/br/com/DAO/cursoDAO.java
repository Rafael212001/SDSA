package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.entities.Curso;
import br.com.jdbc.ConnectionDB;

public class cursoDAO {

	Connection con;

	public cursoDAO() {

		con = ConnectionDB.getConnection();
	}

	public int inserir(Curso c) {

		String sql = "INSERT INTO Cursos(nome,qtd_semestre,ativado) VALUES (?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c.getNome());
			ps.setInt(2, c.getQtd_semestre());
			ps.setInt(3, 1);

			if (ps.executeUpdate() == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int lastId = rs.getInt(1);
					return lastId;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<Curso> listarTodos() {
		List<Curso> list = new ArrayList<Curso>();
		String sql = "SELECT * FROM Cursos WHERE ativado = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Curso c = new Curso();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setQtd_semestre(rs.getInt("qtd_semestre"));
				list.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Curso buscarCurso(int id) {
		String sql = "SELECT * FROM Cursos WHERE id = ? AND ativado = 1";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Curso c = new Curso();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setQtd_semestre(rs.getInt("qtd_semestre"));
				
				return c;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean editar(Curso c) {
		String sql = "UPDATE Cursos SET nome = ?, qtd_semestre = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3, c.getId());
			ps.setString(1, c.getNome());
			ps.setInt(2, c.getQtd_semestre());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean excluirCDT(Integer id) {
		String sql = "UPDATE cursos c, disciplinas d, turmas t "
				+ " SET c.ativado = 2, d.ativado = 2, t.ativado = 2 "
				+ " WHERE c.id = ? AND d.id_curso = ? AND t.id_curso = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ps.setInt(3, id);

			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean excluirCD(Integer id) {
		String sql = "UPDATE cursos c, disciplinas d "
				+ " SET c.ativado = 2, d.ativado = 2 "
				+ " WHERE c.id = ? AND d.id_curso = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id);

			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean excluirCT(Integer id) {
		String sql = "UPDATE cursos c, turmas t "
				+ " SET c.ativado = 2, t.ativado = 2 "
				+ " WHERE c.id = ? AND t.id_curso = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id);

			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean excluirC(Integer id) {
		String sql = "UPDATE cursos SET ativado = 2 WHERE id = ?";

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
	
	public boolean delit(int id) {
		String sql = " DELETE FROM Aulas WHERE id_curso = ? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
