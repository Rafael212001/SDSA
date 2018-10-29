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
	Curso selc;
	Disciplina d = new Disciplina();
	List<Curso> curL;
	cursoDAO csDAO = new cursoDAO();
	@ManagedProperty(value = "#{disciplinaMB}")
	DisciplinaMB dMB;
	int lastId;

	public CursoMB() {
		listarCS();
	}
	
	public void salvar() {
		if(cur.getId() != null) {
			Curso c = csDAO.buscarCurso(cur.getId());
			if(c != null && c.getId().equals(cur.getId())) {
				editarCurso();
			}
		}else {
			criarCurso();
		}
	}
	
	public void editarCurso() {
		if(csDAO.editar(cur)) {
			System.out.println("Curso alterado.");
			zerar();
			listarCS();
		}else {
			System.out.println("Erro na alteraçao do curso.");
			listarCS();
		}
	}
	
	public void criarCurso() {
		lastId = csDAO.inserir(cur);
		if (lastId > 0) {
			System.out.println("Curso criado.");
			zerar();
			listarCS();
		} else {
			System.out.println("Erro na criaçao do curso.");
			listarCS();
		}
	}
	
	public void disciplina() {
		dMB.setID(selc.getId());
		dMB.listarSemestreC();
		dMB.listarD();
	}

	private void zerar() {
		cur = new Curso();
		d = new Disciplina();
		csDAO = new cursoDAO();
		selc = null;
	}
	
	public void editar() {
		cur = selc;
	}
	
	public void excluir() {
		if(csDAO.excluir(selc.getId())){
			System.out.println("Curso " +selc.getNome()+ " excluido.");
			listarCS();
			zerar();
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

	public Curso getSelc() {
		return selc;
	}

	public void setSelc(Curso selc) {
		this.selc = selc;
	}

}
