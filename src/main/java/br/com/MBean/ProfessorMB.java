package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.DAO.professorDAO;
import br.com.entities.CD;
import br.com.entities.Disciplina;
import br.com.entities.Professor;

@ManagedBean
@ViewScoped
public class ProfessorMB {
	int idC;
	private String caminho = "resource/img/";
	professorDAO pDAO = new professorDAO();
	Professor prof = new Professor();
	Professor selc;
	CD cd = new CD();
	CD cdSelc;
	Professor tcoo;
	List<Professor> profL;
	List<Professor> lista;
	List<Disciplina> d = pDAO.listarDisciplina();
	List<CD> cdl;

	public ProfessorMB() {
		listarP();
	}

	public void salvar() {
		if (prof.getId() != null) {
			Professor p = pDAO.buscaProfessor(prof.getId());
			if (p != null && p.getId().equals(prof.getId())) {
				editarProfessor();
			}
		} else {
			criarProfessor();
		}
	}

	public void editarProfessor() {
		if (pDAO.editar(prof)) {
			System.out.println("Colaborador alterado.");
			listarP();
			zerar();
		} else {
			System.out.println("Erro na alterção do colaborador.");
			listarP();
		}
	}

	public void criarProfessor() {
		if (pDAO.inserir(prof)) {
			System.out.println("Colaborador criado.");
			listarP();
			zerar();
		} else {
			System.out.println("Erro na criação do colaborador.");
			listarP();
		}
	}

	public void colocarDisciplina() {
		cd.setId_colaborador(selc.getId());
		if (pDAO.inserirCD(cd)) {
			System.out.println("Disciplina alocada.");
			cDisciplina();
			cdZerar();
		} else {
			System.out.println("Erro na alocação da disciplina.");
			cDisciplina();
		}
	}

	public void zerar() {
		pDAO = new professorDAO();
		prof = new Professor();
		cd = new CD();
		lista = null;
		selc = null;
	}

	public void cdZerar() {
		cdSelc = null;
		cd = new CD();
		pDAO = new professorDAO();
		prof = new Professor();
	}

	public void editar() {
		prof = selc;
	}

	public void excluir() {
		if (pDAO.excluir(selc.getId())) {
			System.out.println("Colaborador " + selc.getNome() + " excluido.");
			listarP();
			zerar();
		}
	}

	public void cdExcluir() {
		if (pDAO.cdExcluir(cdSelc.getId())) {
			System.out.println("Disciplina " + selc.getNome() + " removida do colaborador.");
			cDisciplina();
			cdZerar();
		}
	}
	
	public String fechar() {
		zerar();
		listarP();
		return "telaCoordenador";
	}
	
	public void cDisciplina() {
		listarDisciplina();
		listarP();
		cdl = pDAO.listarCd(selc.getId());
	}

	public void listarDisciplina() {
		d = pDAO.listarDisciplina();
	}

	public void listarP() {
		profL = pDAO.listarTodos();
	}

	public List<Disciplina> getD() {
		return d;
	}

	public List<CD> getCdl() {
		return cdl;
	}

	public void setCdl(List<CD> cdl) {
		this.cdl = cdl;
	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public void setD(List<Disciplina> d) {
		this.d = d;
	}

	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public List<Professor> getProfL() {
		return profL;
	}

	public void setProfL(List<Professor> profL) {
		this.profL = profL;
	}

	public professorDAO getpDAO() {
		return pDAO;
	}

	public void setpDAO(professorDAO pDAO) {
		this.pDAO = pDAO;
	}

	public Professor getSelc() {
		return selc;
	}

	public void setSelc(Professor selc) {
		this.selc = selc;
	}

	public CD getCdSelc() {
		return cdSelc;
	}

	public void setCdSelc(CD cdSelc) {
		this.cdSelc = cdSelc;
	}

	public Professor getTcoo() {
		return tcoo;
	}

	public void setTcoo(Professor tcoo) {
		this.tcoo = tcoo;
	}

	public List<Professor> getLista() {
		return lista;
	}

	public void setLista(List<Professor> lista) {
		this.lista = lista;
	}

}