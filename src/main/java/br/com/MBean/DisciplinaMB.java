package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.DAO.disciplinaDAO;
import br.com.entities.Disciplina;

@ManagedBean
@RequestScoped
public class DisciplinaMB {
	Disciplina disc;
	List<Disciplina> discL;
	disciplinaDAO dDAO;
	int lastId;
	CursoMB c;
	
	public DisciplinaMB() {
		disc = new Disciplina();
		dDAO = new disciplinaDAO();
		listarD();
	}
	
	public void criarDisciplina() {
		
		lastId = c.getLastId();
		disc.setId_curso(lastId);
		
		if(dDAO.inserir(disc)) {
			System.out.println("deu porra");
			disc = new Disciplina();
			listarD();
		}else {
			System.out.println("não deu ;-;");
			listarD();
		}
	}
	
	private void listarD() {
		discL = dDAO.listarTodos();
	}

	public Disciplina getDisc() {
		return disc;
	}

	public void setDisc(Disciplina disc) {
		this.disc = disc;
	}

	public List<Disciplina> getDiscL() {
		return discL;
	}

	public void setDiscL(List<Disciplina> discL) {
		this.discL = discL;
	}

	public disciplinaDAO getdDAO() {
		return dDAO;
	}

	public void setdDAO(disciplinaDAO dDAO) {
		this.dDAO = dDAO;
	}

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public CursoMB getC() {
		return c;
	}

	public void setC(CursoMB c) {
		this.c = c;
	}
	
}