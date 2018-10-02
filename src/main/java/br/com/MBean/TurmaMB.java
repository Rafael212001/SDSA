package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.DAO.cursoDAO;
import br.com.DAO.turmaDAO;
import br.com.entities.Curso;
import br.com.entities.Turma;

@ManagedBean
@RequestScoped
public class TurmaMB {
	Turma tur;
	Curso cur;
	List<Turma> turL;
	List<Curso> curL;
	cursoDAO cDAO;
	turmaDAO tDAO;
	Integer semestre;
	List<Integer> semestres;
	int idCurso;
	
	public TurmaMB() {
		tur = new Turma();
		cur = new Curso();
		tDAO = new turmaDAO();
		cDAO = new cursoDAO();
		curL = cDAO.listarTodos();
		listarT();
	}
	
	public void criarTurma() {
		if(tDAO.inserir(tur, idCurso, semestre)) {
			System.out.println("deu porra");
			tur = new Turma();
			listarT();
		}else {
			System.out.println("não deu ;-;");
			listarT();
		}
	}
	
	public void listarSemestre() {
		idCurso = cur.getId();
		int i = tDAO.listarId(idCurso);
		
		semestres = new ArrayList<Integer>();
		for(int f = 1; f <= i; f++) {
			semestres.add(f);
		}
	}
	
	private void listarT() {
		turL = tDAO.listarTodos();
	}

	public Turma getTur() {
		return tur;
	}

	public void setTur(Turma tur) {
		this.tur = tur;
	}

	public List<Turma> getTurL() {
		return turL;
	}

	public void setTurL(List<Turma> turL) {
		this.turL = turL;
	}

	public turmaDAO gettDAO() {
		return tDAO;
	}

	public void settDAO(turmaDAO tDAO) {
		this.tDAO = tDAO;
	}

	public List<Curso> getCurL() {
		return curL;
	}

	public void setCurL(List<Curso> curL) {
		this.curL = curL;
	}

	public cursoDAO getcDAO() {
		return cDAO;
	}

	public void setcDAO(cursoDAO cDAO) {
		this.cDAO = cDAO;
	}

	public Curso getCur() {
		return cur;
	}

	public void setCur(Curso cur) {
		this.cur = cur;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public List<Integer> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Integer> semestres) {
		this.semestres = semestres;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
}