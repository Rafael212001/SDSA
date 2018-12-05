package br.com.MBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.DAO.aulasDAO;
import br.com.DAO.cursoDAO;
import br.com.DAO.disciplinaDAO;
import br.com.DAO.professorDAO;
import br.com.DAO.turmaDAO;
import br.com.entities.Aulas;
import br.com.entities.CD;
import br.com.entities.Curso;
import br.com.entities.Disciplina;
import br.com.entities.Professor;
import br.com.entities.Turma;

@ManagedBean
@ViewScoped
public class EscolhaMB {

	Aulas aulas;
	Disciplina disc;
	List<Curso> cursoL;
	List<Turma> turmaL;
	List<Disciplina> disciplinaL;
	List<CD> cdL;
	cursoDAO csDAO = new cursoDAO();
	turmaDAO tDAO = new turmaDAO();
	disciplinaDAO dDAO = new disciplinaDAO();
	professorDAO pDAO = new professorDAO();
	aulasDAO aDAO = new aulasDAO();
	int idCurso;
	int idTurma;
	int idDisciplina;
	int idColaborador;
	int idCoordenador;
	int quantidade;
	boolean botao;
	@ManagedProperty(value = "#{loginMB}")
	LoginMB lMB;

	public EscolhaMB() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não tem ", "jdfhasoidfh"));
		cursoL = csDAO.listarTodos();
	}

	public String criarAula() {
		int n;
		boolean b = false;
		Turma turma = new Turma();
		turma = tDAO.buscarTurma(idTurma);
		
		if (lMB.c != null) {
			setIdCoordenador(lMB.getC().getId());
			listarCarga();
			
			for ( n = 1; n <= quantidade; n++) {
				if(aDAO.inserir(idCurso, idTurma, idDisciplina, idColaborador, idCoordenador, turma.getPeriodo(), disc.getCarga_hora())){
					b = true;
				}else {
					b = false;
				}
			}
				if (b == true) {
					System.out.println("Aula criada.");
					return "/telaDistribuicao?faces-redirect=true";
				} else {
					System.out.println("Erro ao criar aula.");
					return "criaAulas?faces-redirect=true";
				}
		} else {
			System.out.println("Erro no coordenador.");
			return "criaAulas?faces-redirect=true";
		}
	}

	private void listarCarga() {
		disc = dDAO.buscarDisciplina(idDisciplina);

		if (disc.getCarga_hora() == 75) {
			quantidade = 5;
		} else if (disc.getCarga_hora() == 150) {
			quantidade = 10;
		} else if (disc.getCarga_hora() == 225) {
			quantidade = 15;
		} else if (disc.getCarga_hora() == 300) {
			quantidade = 20;
		} else {
			quantidade = 1;
		}
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
		} else {
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

	public Aulas getAulas() {
		return aulas;
	}

	public void setAulas(Aulas aulas) {
		this.aulas = aulas;
	}

	public aulasDAO getaDAO() {
		return aDAO;
	}

	public void setaDAO(aulasDAO aDAO) {
		this.aDAO = aDAO;
	}

	public int getIdCoordenador() {
		return idCoordenador;
	}

	public void setIdCoordenador(int idCoordenador) {
		this.idCoordenador = idCoordenador;
	}

	public LoginMB getlMB() {
		return lMB;
	}

	public void setlMB(LoginMB lMB) {
		this.lMB = lMB;
	}

	public Disciplina getDisc() {
		return disc;
	}

	public void setDisc(Disciplina disc) {
		this.disc = disc;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}