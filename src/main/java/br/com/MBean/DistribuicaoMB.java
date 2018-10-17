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
	private List<Aulas> dropSala2;
	private List<Aulas> dropSala3;
	private List<Aulas> dropSala4;
	private List<Aulas> dropSala5;
	private List<Aulas> dropSala6;
	private List<Aulas> dropSala7;
	private List<Aulas> dropSala8;
	private Aulas selecionadas;
	private aulasDAO aDao;

	List<Aulas> aulas;

	public DistribuicaoMB() {
		aDao = new aulasDAO();
		aulas = aDao.listarTodasSemSala();
		dropSala1 = new ArrayList<Aulas>();
		dropSala2 = new ArrayList<Aulas>();
		dropSala3 = new ArrayList<Aulas>();
		dropSala4 = new ArrayList<Aulas>();
		dropSala5 = new ArrayList<Aulas>();
		dropSala6 = new ArrayList<Aulas>();
		dropSala7 = new ArrayList<Aulas>();
		dropSala8 = new ArrayList<Aulas>();

	}

	public void onAulasDropSala1(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		// chamar daoAula para atualizar a sala que foi inserida

		dropSala1.add(aula);
		aulas.remove(aula);
	}

	/////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala2(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		// chamar daoAula para atualizar a sala que foi inserida

		dropSala2.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala3(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		// chamar daoAula para atualizar a sala que foi inserida

		dropSala3.add(aula);
		aulas.remove(aula);
	}

/////////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala4(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		// chamar daoAula para atualizar a sala que foi inserida

		dropSala4.add(aula);
		aulas.remove(aula);
	}

////////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala5(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		// chamar daoAula para atualizar a sala que foi inserida

		dropSala5.add(aula);
		aulas.remove(aula);
	}

////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala6(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

//chamar daoAula para atualizar a sala que foi inserida

		dropSala6.add(aula);
		aulas.remove(aula);
	}

////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala7(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

//chamar daoAula para atualizar a sala que foi inserida

		dropSala7.add(aula);
		aulas.remove(aula);
	}

////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala8(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

//chamar daoAula para atualizar a sala que foi inserida

		dropSala8.add(aula);
		aulas.remove(aula);
	}

	public void init() {
		// aulass = ;

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

	public List<Aulas> getDropSala2() {
		return dropSala2;
	}

	public void setDropSala2(List<Aulas> dropSala2) {
		this.dropSala2 = dropSala2;
	}

	public List<Aulas> getDropSala3() {
		return dropSala3;
	}

	public void setDropSala3(List<Aulas> dropSala3) {
		this.dropSala3 = dropSala3;
	}

	public List<Aulas> getDropSala4() {
		return dropSala4;
	}

	public void setDropSala4(List<Aulas> dropSala4) {
		this.dropSala4 = dropSala4;
	}

	public List<Aulas> getDropSala5() {
		return dropSala5;
	}

	public void setDropSala5(List<Aulas> dropSala5) {
		this.dropSala5 = dropSala5;
	}

	public List<Aulas> getDropSala6() {
		return dropSala6;
	}

	public void setDropSala6(List<Aulas> dropSala6) {
		this.dropSala6 = dropSala6;
	}

	public List<Aulas> getDropSala7() {
		return dropSala7;
	}

	public void setDropSala7(List<Aulas> dropSala7) {
		this.dropSala7 = dropSala7;
	}

	public List<Aulas> getDropSala8() {
		return dropSala8;
	}

	public void setDropSala8(List<Aulas> dropSala8) {
		this.dropSala8 = dropSala8;
	}
	
	

}
