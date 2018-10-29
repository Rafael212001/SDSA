package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.DAO.cursoDAO;
import br.com.DAO.turmaDAO;
import br.com.entities.Curso;
import br.com.entities.Turma;

@ManagedBean
@ViewScoped
public class TurmaMB {
	Turma tur = new Turma();
	Curso tcur = new Curso();
	Turma selc;
	List<Turma> turL;
	List<Curso> curS;
	cursoDAO tcDAO = new cursoDAO();
	turmaDAO tDAO = new turmaDAO();
	Integer semestre;
	List<Integer> semestres;
	int idCurso;
	
	public TurmaMB() {
		listarT();
	}
	
	public void salvar() {
		if(tur.getId() != null) {
			Turma t = tDAO.buscarTurma(tur.getId());
			if(t != null && t.getId().equals(tur.getId())) {
				editarTurma();
			}
		}else {
			criarTurma();
		}
	}
	
	public void editarTurma() {
		if(tDAO.editar(tur)) {
			System.out.println("Turma alterada.");
			zerar();
			listarT();
		}else {
			System.out.println("Erro na alteração da turma.");
		}
	}
	
	public void criarTurma() {
		if(tDAO.inserir(tur)) {
			System.out.println("Turma criada.");
			zerar();
			listarT();
		}else {
			System.out.println("Erro na criação da turma.");
			listarT();
		}
	}
	
	public void listarSemestre() {
		idCurso = tur.getId_curso();
		int i = tDAO.listarId(idCurso);
		
		semestres = new ArrayList<Integer>();
		for(int f = 1; f <= i; f++) {
			semestres.add(f);
		}
	}
	
	private void zerar() {
		tcur = new Curso();
		tDAO = new turmaDAO();
		tcDAO = new cursoDAO();
		tur = new Turma();
		idCurso = 0;
		selc = null;
	}
	
	public void editar() {
		tur = selc;
	}
	
	public void excluir() {
		if(tDAO.excluir(selc.getId())) {
			System.out.println("Turma " +selc.getNome()+ " excluida.");
			listarT();
		}
	}
	
	public void listarT() {
		turL = tDAO.listarTodos();
		curS = tcDAO.listarTodos();
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

	public List<Curso> getCurS() {
		return curS;
	}

	public void setCurS(List<Curso> curS) {
		this.curS = curS;
	}

	public Curso getTcur() {
		return tcur;
	}

	public void setTcur(Curso tcur) {
		this.tcur = tcur;
	}

	public cursoDAO getTcDAO() {
		return tcDAO;
	}

	public void setTcDAO(cursoDAO tcDAO) {
		this.tcDAO = tcDAO;
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

	public Turma getSelc() {
		return selc;
	}

	public void setSelc(Turma selc) {
		this.selc = selc;
	}
	
	
}