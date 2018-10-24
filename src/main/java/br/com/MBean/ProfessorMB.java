package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.DAO.professorDAO;
import br.com.entities.CD;
import br.com.entities.Disciplina;
import br.com.entities.Professor;

@ManagedBean
@ViewScoped
public class ProfessorMB {
	int idC;
	Professor prof = new Professor();
	List<Professor> profL;
	professorDAO pDAO = new professorDAO();
	List<Disciplina> d = pDAO.listarDisciplina();
	List<CD> cdl;
	CD cd = new CD();
	int lastId;
	private String caminho = "resource/img/";

	public ProfessorMB() {
		listarP();
	}

	public void criarProfessor() {
		lastId = pDAO.inserir(prof);
		if (lastId > 0) {
			System.out.println("deu porra");
			prof = new Professor();
			listarP();
		} else {
			System.out.println("não deu ;-;");
			listarP();
		}
	}

	public void colocarDisciplina() {
		cd.setId_colaborador(lastId);
		if (pDAO.inserirCD(cd)) {
			System.out.println("deu porra");
			cd = new CD();
			listarP();
		} else {
			System.out.println("não deu ;-;");
			listarP();
		}
	}
	
	public void listarDisciplina() {
		d = pDAO.listarDisciplina();
	}

	/*
	 * public void upload(FileUploadEvent event) { FacesMessage msg = new
	 * FacesMessage("A imagem ", event.getFile().getFileName() + " foi enviado.");
	 * FacesContext.getCurrentInstance().addMessage(null, msg);
	 * 
	 * try { copia(event.getFile().getFileName(), event.getFile().getInputstream());
	 * prof.setFoto(event.getFile().getFileName()); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 * 
	 * private void copia(String fileName, InputStream in) { try { OutputStream out
	 * = new FileOutputStream(new File(caminho + fileName)); in.close();
	 * out.flush(); out.close(); System.out.println(""); }catch (IOException e) {
	 * System.out.println(e.getMessage()); }
	 * 
	 * }
	 */
	public void listarP() {
		profL = pDAO.listarTodos();
		cdl = pDAO.listarCd(lastId);
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

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
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
}