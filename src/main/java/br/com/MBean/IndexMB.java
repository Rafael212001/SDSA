package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.DAO.IndexDAO;
import br.com.DAO.professorDAO;
import br.com.entities.Aulas;
import br.com.entities.Professor;

@ManagedBean
@ViewScoped
public class IndexMB {

	professorDAO pDAO = new professorDAO();
	IndexDAO iDAO = new IndexDAO();
	List<Professor> profL;
	String lmd1;
	String lmd2;
	String lmd3;
	String lmd4;
	String lmd5;
	String lmd6;
	String ltd1;
	String ltd2;
	String ltd3;
	String ltd4;
	String ltd5;
	String ltd6;
	String lnd1;
	String lnd2;
	String lnd3;
	String lnd4;
	String lnd5;
	String lnd6;
	int idColaborador;

	public IndexMB() {
		listarP();
	}
	
	public void listarTabela() {
		listarManha();
		listarTarde();
		listarNoite();
	}

	public void listarManha() {
		lmd1 = iDAO.listarTabela(idColaborador, 1, 1);
		lmd2 = iDAO.listarTabela(idColaborador, 2, 1);
		lmd3 = iDAO.listarTabela(idColaborador, 3, 1);
		lmd4 = iDAO.listarTabela(idColaborador, 4, 1);
		lmd5 = iDAO.listarTabela(idColaborador, 5, 1);
		lmd6 = iDAO.listarTabela(idColaborador, 6, 1);
	}
	
	public void listarTarde() {
		ltd1 = iDAO.listarTabela(idColaborador, 1, 2);
		ltd2 = iDAO.listarTabela(idColaborador, 2, 2);
		ltd3 = iDAO.listarTabela(idColaborador, 3, 2);
		ltd4 = iDAO.listarTabela(idColaborador, 4, 2);
		ltd5 = iDAO.listarTabela(idColaborador, 5, 2);
		ltd6 = iDAO.listarTabela(idColaborador, 6, 2);
	}
	
	public void listarNoite() {
		lnd1 = iDAO.listarTabela(idColaborador, 1, 3);
		lnd2 = iDAO.listarTabela(idColaborador, 2, 3);
		lnd3 = iDAO.listarTabela(idColaborador, 3, 3);
		lnd4 = iDAO.listarTabela(idColaborador, 4, 3);
		lnd5 = iDAO.listarTabela(idColaborador, 5, 3);
		lnd6 = iDAO.listarTabela(idColaborador, 6, 3);
	}

	public void listarP() {
		profL = pDAO.listarTodos();
	}

	public String troca() {
		return "telaLogin?faces-redirect=true";
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

	public List<Professor> getProfL() {
		return profL;
	}

	public void setProfL(List<Professor> profL) {
		this.profL = profL;
	}

	public IndexDAO getiDAO() {
		return iDAO;
	}

	public void setiDAO(IndexDAO iDAO) {
		this.iDAO = iDAO;
	}

	public String getLmd1() {
		return lmd1;
	}

	public void setLmd1(String lmd1) {
		this.lmd1 = lmd1;
	}

	public String getLmd2() {
		return lmd2;
	}

	public void setLmd2(String lmd2) {
		this.lmd2 = lmd2;
	}

	public String getLmd3() {
		return lmd3;
	}

	public void setLmd3(String lmd3) {
		this.lmd3 = lmd3;
	}

	public String getLmd4() {
		return lmd4;
	}

	public void setLmd4(String lmd4) {
		this.lmd4 = lmd4;
	}

	public String getLmd5() {
		return lmd5;
	}

	public void setLmd5(String lmd5) {
		this.lmd5 = lmd5;
	}

	public String getLmd6() {
		return lmd6;
	}

	public void setLmd6(String lmd6) {
		this.lmd6 = lmd6;
	}

	public String getLtd1() {
		return ltd1;
	}

	public void setLtd1(String ltd1) {
		this.ltd1 = ltd1;
	}

	public String getLtd2() {
		return ltd2;
	}

	public void setLtd2(String ltd2) {
		this.ltd2 = ltd2;
	}

	public String getLtd3() {
		return ltd3;
	}

	public void setLtd3(String ltd3) {
		this.ltd3 = ltd3;
	}

	public String getLtd4() {
		return ltd4;
	}

	public void setLtd4(String ltd4) {
		this.ltd4 = ltd4;
	}

	public String getLtd5() {
		return ltd5;
	}

	public void setLtd5(String ltd5) {
		this.ltd5 = ltd5;
	}

	public String getLtd6() {
		return ltd6;
	}

	public void setLtd6(String ltd6) {
		this.ltd6 = ltd6;
	}

	public String getLnd1() {
		return lnd1;
	}

	public void setLnd1(String lnd1) {
		this.lnd1 = lnd1;
	}

	public String getLnd2() {
		return lnd2;
	}

	public void setLnd2(String lnd2) {
		this.lnd2 = lnd2;
	}

	public String getLnd3() {
		return lnd3;
	}

	public void setLnd3(String lnd3) {
		this.lnd3 = lnd3;
	}

	public String getLnd4() {
		return lnd4;
	}

	public void setLnd4(String lnd4) {
		this.lnd4 = lnd4;
	}

	public String getLnd5() {
		return lnd5;
	}

	public void setLnd5(String lnd5) {
		this.lnd5 = lnd5;
	}

	public String getLnd6() {
		return lnd6;
	}

	public void setLnd6(String lnd6) {
		this.lnd6 = lnd6;
	}
	
}