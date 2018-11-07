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
import br.com.entities.Salas;

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
	private List<Aulas> dropSala9;
	private List<Aulas> dropSala10;
	private List<Aulas> dropSala11;
	private List<Aulas> dropSala12;
	private List<Aulas> dropSala13;
	private List<Aulas> dropSala14;
	private List<Aulas> dropSala15;
	private List<Aulas> dropSala16;
	private List<Aulas> dropSala18;
	private List<Aulas> dropSala35;

	private Aulas selecionadas;
	private aulasDAO aDao;
	private Salas sala;
	public Integer dia_semana = 1;
	private Integer carga = 75;
	private Aulas aulaExcluir;

	List<Aulas> aulas;

	public DistribuicaoMB() {
		System.out.println("entrou");
		aDao = new aulasDAO();
		aulas = aDao.listarTodasSemSala();
		atualizar();
	}
	
	public void atualizar() {
		System.out.println("entrou");
		dropSala1 = aDao.listarAulasAlocadas(dia_semana,1);
		dropSala2 = aDao.listarAulasAlocadas(dia_semana,2);
		dropSala3 = aDao.listarAulasAlocadas(dia_semana,3);
		dropSala4 = aDao.listarAulasAlocadas(dia_semana,4);
		dropSala5 = aDao.listarAulasAlocadas(dia_semana,5);
		dropSala6 = aDao.listarAulasAlocadas(dia_semana,6);
		dropSala7 = aDao.listarAulasAlocadas(dia_semana,7);
		dropSala8 = aDao.listarAulasAlocadas(dia_semana,8);
		dropSala9 = aDao.listarAulasAlocadas(dia_semana,9);
		dropSala10 = aDao.listarAulasAlocadas(dia_semana,10);
		dropSala11 = aDao.listarAulasAlocadas(dia_semana,11);
		dropSala12 = aDao.listarAulasAlocadas(dia_semana,12);
		dropSala13 = aDao.listarAulasAlocadas(dia_semana,13);
		dropSala14 = aDao.listarAulasAlocadas(dia_semana,14);
		dropSala15 = aDao.listarAulasAlocadas(dia_semana,15);
		dropSala16 = aDao.listarAulasAlocadas(dia_semana,16);
		dropSala18 = aDao.listarAulasAlocadas(dia_semana,18);
		dropSala35 = aDao.listarAulasAlocadas(dia_semana,35);
	}
	
	
	public String excluir() {
		aDao.desalocar(aulaExcluir);
		aulas.remove(aulaExcluir);
		return "telaDistribuicao?faces-redirect=true";
	}

	public void onAulasDropSala1(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 1, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 1);

		dropSala1.add(aula);
		aulas.remove(aula);

		
		
	}

	/////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala2(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 2, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 2);

		dropSala2.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala3(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 3, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 3);

		dropSala3.add(aula);
		aulas.remove(aula);
	}

/////////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala4(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 4, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 4);
		
		dropSala4.add(aula);
		aulas.remove(aula);
	}

////////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala5(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 5, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 5);
		
		dropSala5.add(aula);
		aulas.remove(aula);
	}

////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala6(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 6, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 6);
		
		dropSala6.add(aula);
		aulas.remove(aula);
	}

////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala7(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		
		aDao.alocarSala(aula, 7, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 7);

		dropSala7.add(aula);
		aulas.remove(aula);
	}

////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala8(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 8, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 8);

		dropSala8.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala9(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 9, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 9);

		dropSala9.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala10(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 10, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 10);

		dropSala10.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala11(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 11, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 11);

		dropSala11.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala12(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 12, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 12);

		dropSala12.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala13(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 13, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 13);

		dropSala13.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala14(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 14, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 14);

		dropSala14.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala15(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 15, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 15);

		dropSala15.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala16(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 16, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 16);

		dropSala16.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala18(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 18, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 18);

		dropSala18.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala35(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		aDao.alocarSala(aula, 35, dia_semana, 75);
		aDao.listarAulasAlocadas(dia_semana, 35);

		dropSala35.add(aula);
		aulas.remove(aula);
	}

///////////////////////////////////////////////////////////////////////////	
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

	public List<Aulas> getDropSala9() {
		return dropSala9;
	}

	public void setDropSala9(List<Aulas> dropSala9) {
		this.dropSala9 = dropSala9;
	}

	public List<Aulas> getDropSala10() {
		return dropSala10;
	}

	public void setDropSala10(List<Aulas> dropSala10) {
		this.dropSala10 = dropSala10;
	}

	public List<Aulas> getDropSala11() {
		return dropSala11;
	}

	public void setDropSala11(List<Aulas> dropSala11) {
		this.dropSala11 = dropSala11;
	}

	public List<Aulas> getDropSala12() {
		return dropSala12;
	}

	public void setDropSala12(List<Aulas> dropSala12) {
		this.dropSala12 = dropSala12;
	}

	public List<Aulas> getDropSala13() {
		return dropSala13;
	}

	public void setDropSala13(List<Aulas> dropSala13) {
		this.dropSala13 = dropSala13;
	}

	public List<Aulas> getDropSala14() {
		return dropSala14;
	}

	public void setDropSala14(List<Aulas> dropSala14) {
		this.dropSala14 = dropSala14;
	}

	public List<Aulas> getDropSala15() {
		return dropSala15;
	}

	public void setDropSala15(List<Aulas> dropSala15) {
		this.dropSala15 = dropSala15;
	}

	public List<Aulas> getDropSala16() {
		return dropSala16;
	}

	public void setDropSala16(List<Aulas> dropSala16) {
		this.dropSala16 = dropSala16;
	}

	public List<Aulas> getDropSala18() {
		return dropSala18;
	}

	public void setDropSala18(List<Aulas> dropSala18) {
		this.dropSala18 = dropSala18;
	}

	public List<Aulas> getDropSala35() {
		return dropSala35;
	}

	public void setDropSala35(List<Aulas> dropSala35) {
		this.dropSala35 = dropSala35;
	}

	public Salas getSala() {
		return sala;
	}

	public void setSala(Salas sala) {
		this.sala = sala;
	}

	public Integer getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(Integer dia_semana) {
		this.dia_semana = dia_semana;
	}

	public Integer getCarga() {
		return carga;
	}

	public void setCarga(Integer carga) {
		this.carga = carga;
	}

	public Aulas getAulaExcluir() {
		return aulaExcluir;
	}

	public void setAulaExcluir(Aulas aulaExcluir) {
		this.aulaExcluir = aulaExcluir;
	}
	
	

}
