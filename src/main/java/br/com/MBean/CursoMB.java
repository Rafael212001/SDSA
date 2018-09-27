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
	List<Curso> curL;
	cursoDAO csDAO;
	int lastId;
	
	public CursoMB() {
		cur = new Curso();
		csDAO = new cursoDAO();
		curL = csDAO.listarTodos();
	}
	
	public void criarCurso() {
		lastId = csDAO.inserir(cur);
		if(lastId > 0) {
			System.out.println("deu porra");
			cur = new Curso();
			listarCS();
		}else {
			System.out.println("não deu ;-;");
			listarCS();
		}
	}
	
	private void listarCS() {
		curL = csDAO.listarTodos();
	}

	public Curso getCur() {
		return cur;
	}

	public void setCur(Curso cur) {
		this.cur = cur;
	}

	public List<Curso> getCurL() {
		return curL;
	}

	public void setCurL(List<Curso> curL) {
		this.curL = curL;
	}

	public cursoDAO getCsDAO() {
		return csDAO;
	}

	public void setCsDAO(cursoDAO csDAO) {
		this.csDAO = csDAO;
	}

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}
}
