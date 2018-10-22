package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.entities.CD;
import br.com.entities.Disciplina;
import br.com.entities.Professor;
import br.com.jdbc.ConnectionDB;

public class professorDAO {
	Connection con;

	public professorDAO() {
		con = ConnectionDB.getConnection();
	}

	public int inserir(Professor p) {
		String sql = "INSERT INTO Colaboradores (nome, carga_hora, tipo)"
				+ "VALUES (?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, p.getNome());
			ps.setInt(2, p.getCarga_hora());
			ps.setInt(3, p.getTipo());

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
	
	public boolean inserirCD(CD cd) {
		String sql = "INSERT INTO CD (id_colaborador, id_disciplina)"
				+ "VALUES (?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cd.getId_colaborador());
			ps.setInt(2, cd.getId_disciplina());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public List<Professor> listarTodos() {
		List<Professor> list = new ArrayList<Professor>();
		String sql = "SELECT * FROM Colaboradores ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Professor p = new Professor();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setCarga_hora(rs.getInt("carga_hora"));
				p.setRestante(rs.getInt("restante"));
				p.setTipo(rs.getInt("tipo"));
				p.setFoto(rs.getString("foto"));

				list.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Disciplina> listarDisciplina() {
		List<Disciplina> list = new ArrayList<Disciplina>();
		String sql = "SELECT * FROM Disciplinas";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Disciplina d = new Disciplina();
				d.setId(rs.getInt("id"));
				d.setNome(rs.getString("nome"));
				list.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<CD> listarCd(int i){
		List<CD> list = new ArrayList<CD>();
		String sql = "SELECT * FROM CD WHERE id_colaborador = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CD cd = new CD();
				cd.setId_colaborador(rs.getInt("id_colaborador"));
				cd.setId_disciplina(rs.getInt("id_disciplina"));
				list.add(cd);
			}
		}catch (SQLException e ){
			e.printStackTrace();
		}
		return list;
	}

	public boolean excluir(Integer id) {
		String sql = "DELETE * FROM Colaboradores WHERE id = ? ";

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
