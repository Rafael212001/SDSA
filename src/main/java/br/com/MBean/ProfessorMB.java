package br.com.MBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import br.com.DAO.professorDAO;
import br.com.entities.CD;
import br.com.entities.Disciplina;
import br.com.entities.Professor;

@ManagedBean
@ViewScoped
public class ProfessorMB {
	int idC;
	Professor prof;
	List<Professor> profL;
	professorDAO pDAO;
	List<Disciplina> d;
	List<CD> cd;
	int lastId;
	private String caminho = "resource/img/";

	public ProfessorMB() {
		prof = new Professor();
		pDAO = new professorDAO();
		profL = pDAO.listarTodos();
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
	
	/*public void upload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("A imagem ", event.getFile().getFileName() + " foi enviado.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		try {
			copia(event.getFile().getFileName(), event.getFile().getInputstream());
			prof.setFoto(event.getFile().getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void copia(String fileName, InputStream in) {
		try {
			OutputStream out = new FileOutputStream(new File(caminho + fileName));
			in.close();
			out.flush();
			out.close();
			System.out.println("");
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}*/
	private void listarP() {
		profL = pDAO.listarTodos();
		d = pDAO.listarDisciplina();
	}
	
	public List<Disciplina> getD() {
		return d;
	}

	public List<CD> getCd() {
		return cd;
	}

	public void setCd(List<CD> cd) {
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