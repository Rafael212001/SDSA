package br.com.MBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.com.DAO.cursoDAO;
import br.com.entities.Curso;
import br.com.entities.Disciplina;

@ManagedBean
@ViewScoped
public class CursoMB {
	Curso cur = new Curso();
	List<Curso> curL;
	cursoDAO csDAO = new cursoDAO();
	Disciplina d = new Disciplina();
	@ManagedProperty(value = "#{disciplinaMB}")
		DisciplinaMB dMB;
	int lastId;
	
	public CursoMB() {
		curL = csDAO.listarTodos();
	}
	
	public void criarCurso() {
		lastId = csDAO.inserir(cur);
		if(lastId > 0) {			
			System.out.println("deu porra");
			cur = new Curso();
			listarCS();
			dMB.listarSemestreC(lastId);
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

	public Disciplina getD() {
		return d;
	}

	public void setD(Disciplina d) {
		this.d = d;
	}

	public DisciplinaMB getdMB() {
		return dMB;
	}

	public void setdMB(DisciplinaMB dMB) {
		this.dMB = dMB;
	}
	
}
