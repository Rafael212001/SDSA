package br.com.MBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

import br.com.DAO.aulasDAO;
import br.com.entities.Aulas;
import br.com.entities.Curso;

@ManagedBean
@ViewScoped
public class DistribuicaoMB implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private List<Aulas> dropSala1;
	private Aulas selecionadas;
	private aulasDAO aDao;
	
	List<Aulas> aulas;
	
	public DistribuicaoMB() {
		aDao = new aulasDAO();
		aulas = aDao.listarTodasSemSala();
		dropSala1 = new ArrayList<Aulas>();
	}
	
	public void onAulasDropSala1(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		
		//chamar daoAula para atualizar a sala que foi inserida
		
		dropSala1.add(aula);
		aulas.remove(aula);
	}
	
	
	public void init() {
		//aulass = ;
		
	}
	

	public Aulas getSelecionadas() {
		return selecionadas;
	}

	public void setSelecionadas(Aulas selecionadas) {
		this.selecionadas = selecionadas;
	}


	public aulasDAO getaDao() {
		return aDao;
	}

	public void setaDao(aulasDAO aDao) {
		this.aDao = aDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Aulas> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aulas> aulas) {
		this.aulas = aulas;
	}

	public List<Aulas> getDropSala1() {
		return dropSala1;
	}

	public void setDropSala1(List<Aulas> dropSala1) {
		this.dropSala1 = dropSala1;
	}
	
	
	
	
	
	
	
	
}
