package br.com.MBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.DAO.cursoDAO;
import br.com.entities.Curso;

@ManagedBean
@RequestScoped
public class CursoMB {
	Curso cur;
	cursoDAO cDAO;
	List<Curso> cuu;

	public CursoMB() {
		cur = new Curso();
		cDAO = new cursoDAO();
		cuu = cDAO.listarTodos();
	}
	
	public void criarCurso() {
		
	}
	
	
	
	
	

	public Curso getCur() {
		return cur;
	}

	public void setCur(Curso cur) {
		this.cur = cur;
	}

	public cursoDAO getcDAO() {
		return cDAO;
	}

	public void setcDAO(cursoDAO cDAO) {
		this.cDAO = cDAO;
	}

	public List<Curso> getCuu() {
		return cuu;
	}

	public void setCuu(List<Curso> cuu) {
		this.cuu = cuu;
	}
	
	
}
