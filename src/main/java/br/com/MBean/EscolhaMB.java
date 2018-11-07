package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import br.com.DAO.cursoDAO;
import br.com.DAO.turmaDAO;
import br.com.entities.Curso;
import br.com.entities.Turma;

@ManagedBean
@ViewScoped
public class EscolhaMB {

	Curso curso = new Curso();
	Turma turma = new Turma();
	List<Curso> cursoL;
	List<Turma> turmaL;
	List<SelectItem> aulas;
	cursoDAO csDAO = new cursoDAO();
	turmaDAO tDAO = new turmaDAO();
	int select;
	List<SelectItem> cursos;

	@PostConstruct
	public void aula() {
		cursos = new ArrayList<SelectItem>();
		cursoL = csDAO.listarTodos();
		
		for(Curso c : cursoL) {
			cursos.add(new SelectItemGroup(c.getNome()));
		}
		
		aulas = new ArrayList<SelectItem>();
		
	}

	/*----------------------------------------------------------------*/
	public List<Curso> getCursoL() {
		return cursoL;
	}

	public void setCursoL(List<Curso> cursoL) {
		this.cursoL = cursoL;
	}

	public cursoDAO getCsDAO() {
		return csDAO;
	}

	public void setCsDAO(cursoDAO csDAO) {
		this.csDAO = csDAO;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public List<SelectItem> getCursos() {
		return cursos;
	}

	public void setCursos(List<SelectItem> cursos) {
		this.cursos = cursos;
	}

}