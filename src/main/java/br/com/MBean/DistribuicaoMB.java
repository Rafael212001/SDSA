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
	private List<Aulas> aulass;
	private List<Aulas> drop;
	private Aulas selecionadas;
	
	
	
	public void onAulasDropSala1(DragDropEvent dde) {
		Aulas aulas = ((Aulas) dde.getData());
		
		drop.add(aulas);
		aulass.remove(aulas);
	}
	
	public void init() {
		//aulass = ;
		drop = new ArrayList<Aulas>();
	}
	
	
	public List<Aulas> getAulas() {
		return aulass;
	}

	public void setAulas(List<Aulas> aulas) {
		this.aulass = aulas;
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
	
	
	
	
}
