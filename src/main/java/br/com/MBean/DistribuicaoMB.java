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

@ManagedBean
@ViewScoped
public class DistribuicaoMB implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private List<Aulas> drop;
	private Aulas selecionadas;
	private aulasDAO aDao;
	
	List<Aulas> aulas;
	
	public DistribuicaoMB() {
		aDao = new aulasDAO();
		aulas = aDao.listarTodos();
	}
	
	public void onAulasDropSala1(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		
		drop.add(aula);
		aulas.remove(aula);
	}
	
	public void init() {
		//aulass = ;
		drop = new ArrayList<Aulas>();
	}
	
	
	public List<Aulas> getDrop() {
		return drop;
	}

	public void setDrop(List<Aulas> drop) {
		this.drop = drop;
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
	
	
	
	
	
	
	
	
}
