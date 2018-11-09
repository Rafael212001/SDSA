package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.DAO.cursoDAO;
import br.com.DAO.disciplinaDAO;
import br.com.DAO.professorDAO;
import br.com.DAO.turmaDAO;
import br.com.entities.CD;
import br.com.entities.Curso;
import br.com.entities.Disciplina;
import br.com.entities.Turma;

@ManagedBean
@ViewScoped
public class EscolhaMB {

	List<Curso> cursoL;
	List<Turma> turmaL;
	List<Disciplina> disciplinaL;
	List<CD> cdL;
	cursoDAO csDAO = new cursoDAO();
	turmaDAO tDAO = new turmaDAO();
	disciplinaDAO dDAO = new disciplinaDAO();
	professorDAO pDAO = new professorDAO();
	int idCurso;
	int idTurma;
	int idDisciplina;
	int idColaborador;
	boolean botao;

	public EscolhaMB() {
		cursoL = csDAO.listarTodos();
	}

	public void listTurma() {
		disciplinaL = null;
		cdL = null;
		idTurma = 0;
		idDisciplina = 0;
		idColaborador = 0;
		verificar();
		turmaL = tDAO.listarPorCurso(idCurso);
	}

	public void listDisc() {
		cdL = null;
		idDisciplina = 0;
		idColaborador = 0;
		verificar();
		int semestre = tDAO.pegarSemestre(idTurma);
		disciplinaL = dDAO.listDisc(semestre, idCurso);
	}

	public void listColab() {
		idColaborador = 0;
		verificar();
		cdL = pDAO.listCd(idDisciplina);
	}

	public void verificar() {
		if (idColaborador != 0) {
			botao = true;
		}else {
			botao = false;
		}
			
	}

	public List<Curso> getCursoL() {
		return cursoL;
	}

	public void setCursoL(List<Curso> cursoL) {
		this.cursoL = cursoL;
	}

	public List<Turma> getTurmaL() {
		return turmaL;
	}

	public void setTurmaL(List<Turma> turmaL) {
		this.turmaL = turmaL;
	}

	public List<Disciplina> getDisciplinaL() {
		return disciplinaL;
	}

	public void setDisciplinaL(List<Disciplina> disciplinaL) {
		this.disciplinaL = disciplinaL;
	}

	public cursoDAO getCsDAO() {
		return csDAO;
	}

	public void setCsDAO(cursoDAO csDAO) {
		this.csDAO = csDAO;
	}

	public turmaDAO gettDAO() {
		return tDAO;
	}

	public void settDAO(turmaDAO tDAO) {
		this.tDAO = tDAO;
	}

	public disciplinaDAO getdDAO() {
		return dDAO;
	}

	public void setdDAO(disciplinaDAO dDAO) {
		this.dDAO = dDAO;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public professorDAO getpDAO() {
		return pDAO;
	}

	public void setpDAO(professorDAO pDAO) {
		this.pDAO = pDAO;
	}

	public int getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}

	public List<CD> getCdL() {
		return cdL;
	}

	public void setCdL(List<CD> cdL) {
		this.cdL = cdL;
	}

	public boolean isBotao() {
		return botao;
	}

	public void setBotao(boolean botao) {
		this.botao = botao;
	}

}