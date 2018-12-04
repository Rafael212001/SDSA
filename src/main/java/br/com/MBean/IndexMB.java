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
	////// manha////////////////////////////////////////////////////////
	String lmd1h0;
	String lmd1h1;
	String lmd1h2;
	String lmd1h3;
	String lmd1h4;

	String lmd2h0;
	String lmd2h1;
	String lmd2h2;
	String lmd2h3;
	String lmd2h4;

	String lmd3h0;
	String lmd3h1;
	String lmd3h2;
	String lmd3h3;
	String lmd3h4;

	String lmd4h0;
	String lmd4h1;
	String lmd4h2;
	String lmd4h3;
	String lmd4h4;

	String lmd5h0;
	String lmd5h1;
	String lmd5h2;
	String lmd5h3;
	String lmd5h4;

	String lmd6h0;
	String lmd6h1;
	String lmd6h2;
	String lmd6h3;
	String lmd6h4;
	///////////////////////////////////////////////////////////////////
	String ltd1h0;
	String ltd1h1;
	String ltd1h2;
	String ltd1h3;
	String ltd1h4;

	String ltd2h0;
	String ltd2h1;
	String ltd2h2;
	String ltd2h3;
	String ltd2h4;

	String ltd3h0;
	String ltd3h1;
	String ltd3h2;
	String ltd3h3;
	String ltd3h4;

	String ltd4h0;
	String ltd4h1;
	String ltd4h2;
	String ltd4h3;
	String ltd4h4;

	String ltd5h0;
	String ltd5h1;
	String ltd5h2;
	String ltd5h3;
	String ltd5h4;

	String ltd6h0;
	String ltd6h1;
	String ltd6h2;
	String ltd6h3;
	String ltd6h4;
	///////////////////////////////////////////////////////////////////
	String lnd1h0;
	String lnd1h1;
	String lnd1h2;

	String lnd2h0;
	String lnd2h1;
	String lnd2h2;

	String lnd3h0;
	String lnd3h1;
	String lnd3h2;

	String lnd4h0;
	String lnd4h1;
	String lnd4h2;

	String lnd5h0;
	String lnd5h1;
	String lnd5h2;

	String lnd6h0;
	String lnd6h1;
	String lnd6h2;
	///////////////////////////////////////////////////////////////////
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
		lmd1h0 = iDAO.listarTabela(idColaborador, 1, 1, 0);
		lmd1h1 = iDAO.listarTabela(idColaborador, 1, 1, 1);
		lmd1h2 = iDAO.listarTabela(idColaborador, 1, 1, 2);
		lmd1h3 = iDAO.listarTabela(idColaborador, 1, 1, 3);
		lmd1h4 = iDAO.listarTabela(idColaborador, 1, 1, 4);

		lmd2h0 = iDAO.listarTabela(idColaborador, 2, 1, 0);
		lmd2h1 = iDAO.listarTabela(idColaborador, 2, 1, 1);
		lmd2h2 = iDAO.listarTabela(idColaborador, 2, 1, 2);
		lmd2h3 = iDAO.listarTabela(idColaborador, 2, 1, 3);
		lmd2h4 = iDAO.listarTabela(idColaborador, 2, 1, 4);

		lmd3h0 = iDAO.listarTabela(idColaborador, 3, 1, 0);
		lmd3h1 = iDAO.listarTabela(idColaborador, 3, 1, 1);
		lmd3h2 = iDAO.listarTabela(idColaborador, 3, 1, 2);
		lmd3h3 = iDAO.listarTabela(idColaborador, 3, 1, 3);
		lmd3h4 = iDAO.listarTabela(idColaborador, 3, 1, 4);

		lmd4h0 = iDAO.listarTabela(idColaborador, 4, 1, 0);
		lmd4h1 = iDAO.listarTabela(idColaborador, 4, 1, 1);
		lmd4h2 = iDAO.listarTabela(idColaborador, 4, 1, 2);
		lmd4h3 = iDAO.listarTabela(idColaborador, 4, 1, 3);
		lmd4h4 = iDAO.listarTabela(idColaborador, 4, 1, 4);

		lmd5h0 = iDAO.listarTabela(idColaborador, 5, 1, 0);
		lmd5h1 = iDAO.listarTabela(idColaborador, 5, 1, 1);
		lmd5h2 = iDAO.listarTabela(idColaborador, 5, 1, 2);
		lmd5h3 = iDAO.listarTabela(idColaborador, 5, 1, 3);
		lmd5h4 = iDAO.listarTabela(idColaborador, 5, 1, 4);

		lmd6h0 = iDAO.listarTabela(idColaborador, 6, 1, 0);
		lmd6h1 = iDAO.listarTabela(idColaborador, 6, 1, 1);
		lmd6h2 = iDAO.listarTabela(idColaborador, 6, 1, 2);
		lmd6h3 = iDAO.listarTabela(idColaborador, 6, 1, 3);
		lmd6h4 = iDAO.listarTabela(idColaborador, 6, 1, 4);
	}

	public void listarTarde() {
		ltd1h0 = iDAO.listarTabela(idColaborador, 1, 2, 0);
		ltd1h1 = iDAO.listarTabela(idColaborador, 1, 2, 1);
		ltd1h2 = iDAO.listarTabela(idColaborador, 1, 2, 2);
		ltd1h3 = iDAO.listarTabela(idColaborador, 1, 2, 3);
		ltd1h4 = iDAO.listarTabela(idColaborador, 1, 2, 4);

		ltd2h0 = iDAO.listarTabela(idColaborador, 2, 2, 0);
		ltd2h1 = iDAO.listarTabela(idColaborador, 2, 2, 1);
		ltd2h2 = iDAO.listarTabela(idColaborador, 2, 2, 2);
		ltd2h3 = iDAO.listarTabela(idColaborador, 2, 2, 3);
		ltd2h4 = iDAO.listarTabela(idColaborador, 2, 2, 4);

		ltd3h0 = iDAO.listarTabela(idColaborador, 3, 2, 0);
		ltd3h1 = iDAO.listarTabela(idColaborador, 3, 2, 1);
		ltd3h2 = iDAO.listarTabela(idColaborador, 3, 2, 2);
		ltd3h3 = iDAO.listarTabela(idColaborador, 3, 2, 3);
		ltd3h4 = iDAO.listarTabela(idColaborador, 3, 2, 4);

		ltd4h0 = iDAO.listarTabela(idColaborador, 4, 2, 0);
		ltd4h1 = iDAO.listarTabela(idColaborador, 4, 2, 1);
		ltd4h2 = iDAO.listarTabela(idColaborador, 4, 2, 2);
		ltd4h3 = iDAO.listarTabela(idColaborador, 4, 2, 3);
		ltd4h4 = iDAO.listarTabela(idColaborador, 4, 2, 4);

		ltd5h0 = iDAO.listarTabela(idColaborador, 5, 2, 0);
		ltd5h1 = iDAO.listarTabela(idColaborador, 5, 2, 1);
		ltd5h2 = iDAO.listarTabela(idColaborador, 5, 2, 2);
		ltd5h3 = iDAO.listarTabela(idColaborador, 5, 2, 3);
		ltd5h4 = iDAO.listarTabela(idColaborador, 5, 2, 4);

		ltd6h0 = iDAO.listarTabela(idColaborador, 6, 2, 0);
		ltd6h1 = iDAO.listarTabela(idColaborador, 6, 2, 1);
		ltd6h2 = iDAO.listarTabela(idColaborador, 6, 2, 2);
		ltd6h3 = iDAO.listarTabela(idColaborador, 6, 2, 3);
		ltd6h4 = iDAO.listarTabela(idColaborador, 6, 2, 4);
	}

	public void listarNoite() {
		lnd1h0 = iDAO.listarTabela(idColaborador, 1, 3, 0);
		lnd1h1 = iDAO.listarTabela(idColaborador, 1, 3, 1);
		lnd1h2 = iDAO.listarTabela(idColaborador, 1, 3, 2);

		lnd2h0 = iDAO.listarTabela(idColaborador, 2, 3, 0);
		lnd2h1 = iDAO.listarTabela(idColaborador, 2, 3, 1);
		lnd2h2 = iDAO.listarTabela(idColaborador, 2, 3, 2);

		lnd3h0 = iDAO.listarTabela(idColaborador, 3, 3, 0);
		lnd3h1 = iDAO.listarTabela(idColaborador, 3, 3, 1);
		lnd3h2 = iDAO.listarTabela(idColaborador, 3, 3, 2);

		lnd4h0 = iDAO.listarTabela(idColaborador, 4, 3, 0);
		lnd4h1 = iDAO.listarTabela(idColaborador, 4, 3, 1);
		lnd4h2 = iDAO.listarTabela(idColaborador, 4, 3, 2);

		lnd5h0 = iDAO.listarTabela(idColaborador, 5, 3, 0);
		lnd5h1 = iDAO.listarTabela(idColaborador, 5, 3, 1);
		lnd5h2 = iDAO.listarTabela(idColaborador, 5, 3, 2);

		lnd6h0 = iDAO.listarTabela(idColaborador, 6, 3, 0);
		lnd6h1 = iDAO.listarTabela(idColaborador, 6, 3, 1);
		lnd6h2 = iDAO.listarTabela(idColaborador, 6, 3, 2);
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

	public String getLmd1h0() {
		return lmd1h0;
	}

	public void setLmd1h0(String lmd1h0) {
		this.lmd1h0 = lmd1h0;
	}

	public String getLmd1h1() {
		return lmd1h1;
	}

	public void setLmd1h1(String lmd1h1) {
		this.lmd1h1 = lmd1h1;
	}

	public String getLmd1h2() {
		return lmd1h2;
	}

	public void setLmd1h2(String lmd1h2) {
		this.lmd1h2 = lmd1h2;
	}

	public String getLmd1h3() {
		return lmd1h3;
	}

	public void setLmd1h3(String lmd1h3) {
		this.lmd1h3 = lmd1h3;
	}

	public String getLmd1h4() {
		return lmd1h4;
	}

	public void setLmd1h4(String lmd1h4) {
		this.lmd1h4 = lmd1h4;
	}

	public String getLmd2h0() {
		return lmd2h0;
	}

	public void setLmd2h0(String lmd2h0) {
		this.lmd2h0 = lmd2h0;
	}

	public String getLmd2h1() {
		return lmd2h1;
	}

	public void setLmd2h1(String lmd2h1) {
		this.lmd2h1 = lmd2h1;
	}

	public String getLmd2h2() {
		return lmd2h2;
	}

	public void setLmd2h2(String lmd2h2) {
		this.lmd2h2 = lmd2h2;
	}

	public String getLmd2h3() {
		return lmd2h3;
	}

	public void setLmd2h3(String lmd2h3) {
		this.lmd2h3 = lmd2h3;
	}

	public String getLmd2h4() {
		return lmd2h4;
	}

	public void setLmd2h4(String lmd2h4) {
		this.lmd2h4 = lmd2h4;
	}

	public String getLmd3h0() {
		return lmd3h0;
	}

	public void setLmd3h0(String lmd3h0) {
		this.lmd3h0 = lmd3h0;
	}

	public String getLmd3h1() {
		return lmd3h1;
	}

	public void setLmd3h1(String lmd3h1) {
		this.lmd3h1 = lmd3h1;
	}

	public String getLmd3h2() {
		return lmd3h2;
	}

	public void setLmd3h2(String lmd3h2) {
		this.lmd3h2 = lmd3h2;
	}

	public String getLmd3h3() {
		return lmd3h3;
	}

	public void setLmd3h3(String lmd3h3) {
		this.lmd3h3 = lmd3h3;
	}

	public String getLmd3h4() {
		return lmd3h4;
	}

	public void setLmd3h4(String lmd3h4) {
		this.lmd3h4 = lmd3h4;
	}

	public String getLmd4h0() {
		return lmd4h0;
	}

	public void setLmd4h0(String lmd4h0) {
		this.lmd4h0 = lmd4h0;
	}

	public String getLmd4h1() {
		return lmd4h1;
	}

	public void setLmd4h1(String lmd4h1) {
		this.lmd4h1 = lmd4h1;
	}

	public String getLmd4h2() {
		return lmd4h2;
	}

	public void setLmd4h2(String lmd4h2) {
		this.lmd4h2 = lmd4h2;
	}

	public String getLmd4h3() {
		return lmd4h3;
	}

	public void setLmd4h3(String lmd4h3) {
		this.lmd4h3 = lmd4h3;
	}

	public String getLmd4h4() {
		return lmd4h4;
	}

	public void setLmd4h4(String lmd4h4) {
		this.lmd4h4 = lmd4h4;
	}

	public String getLmd5h0() {
		return lmd5h0;
	}

	public void setLmd5h0(String lmd5h0) {
		this.lmd5h0 = lmd5h0;
	}

	public String getLmd5h1() {
		return lmd5h1;
	}

	public void setLmd5h1(String lmd5h1) {
		this.lmd5h1 = lmd5h1;
	}

	public String getLmd5h2() {
		return lmd5h2;
	}

	public void setLmd5h2(String lmd5h2) {
		this.lmd5h2 = lmd5h2;
	}

	public String getLmd5h3() {
		return lmd5h3;
	}

	public void setLmd5h3(String lmd5h3) {
		this.lmd5h3 = lmd5h3;
	}

	public String getLmd5h4() {
		return lmd5h4;
	}

	public void setLmd5h4(String lmd5h4) {
		this.lmd5h4 = lmd5h4;
	}

	public String getLmd6h1() {
		return lmd6h1;
	}

	public String getLmd6h0() {
		return lmd6h0;
	}

	public void setLmd6h0(String lmd6h0) {
		this.lmd6h0 = lmd6h0;
	}

	public void setLmd6h1(String lmd6h1) {
		this.lmd6h1 = lmd6h1;
	}

	public String getLmd6h2() {
		return lmd6h2;
	}

	public void setLmd6h2(String lmd6h2) {
		this.lmd6h2 = lmd6h2;
	}

	public String getLmd6h3() {
		return lmd6h3;
	}

	public void setLmd6h3(String lmd6h3) {
		this.lmd6h3 = lmd6h3;
	}

	public String getLmd6h4() {
		return lmd6h4;
	}

	public void setLmd6h4(String lmd6h4) {
		this.lmd6h4 = lmd6h4;
	}

	public String getLtd1h0() {
		return ltd1h0;
	}

	public void setLtd1h0(String ltd1h0) {
		this.ltd1h0 = ltd1h0;
	}

	public String getLtd1h1() {
		return ltd1h1;
	}

	public void setLtd1h1(String ltd1h1) {
		this.ltd1h1 = ltd1h1;
	}

	public String getLtd1h2() {
		return ltd1h2;
	}

	public void setLtd1h2(String ltd1h2) {
		this.ltd1h2 = ltd1h2;
	}

	public String getLtd1h3() {
		return ltd1h3;
	}

	public void setLtd1h3(String ltd1h3) {
		this.ltd1h3 = ltd1h3;
	}

	public String getLtd1h4() {
		return ltd1h4;
	}

	public void setLtd1h4(String ltd1h4) {
		this.ltd1h4 = ltd1h4;
	}

	public String getLtd2h0() {
		return ltd2h0;
	}

	public void setLtd2h0(String ltd2h0) {
		this.ltd2h0 = ltd2h0;
	}

	public String getLtd2h1() {
		return ltd2h1;
	}

	public void setLtd2h1(String ltd2h1) {
		this.ltd2h1 = ltd2h1;
	}

	public String getLtd2h2() {
		return ltd2h2;
	}

	public void setLtd2h2(String ltd2h2) {
		this.ltd2h2 = ltd2h2;
	}

	public String getLtd2h3() {
		return ltd2h3;
	}

	public void setLtd2h3(String ltd2h3) {
		this.ltd2h3 = ltd2h3;
	}

	public String getLtd2h4() {
		return ltd2h4;
	}

	public void setLtd2h4(String ltd2h4) {
		this.ltd2h4 = ltd2h4;
	}

	public String getLtd3h0() {
		return ltd3h0;
	}

	public void setLtd3h0(String ltd3h0) {
		this.ltd3h0 = ltd3h0;
	}

	public String getLtd3h1() {
		return ltd3h1;
	}

	public void setLtd3h1(String ltd3h1) {
		this.ltd3h1 = ltd3h1;
	}

	public String getLtd3h2() {
		return ltd3h2;
	}

	public void setLtd3h2(String ltd3h2) {
		this.ltd3h2 = ltd3h2;
	}

	public String getLtd3h3() {
		return ltd3h3;
	}

	public void setLtd3h3(String ltd3h3) {
		this.ltd3h3 = ltd3h3;
	}

	public String getLtd3h4() {
		return ltd3h4;
	}

	public void setLtd3h4(String ltd3h4) {
		this.ltd3h4 = ltd3h4;
	}

	public String getLtd4h0() {
		return ltd4h0;
	}

	public void setLtd4h0(String ltd4h0) {
		this.ltd4h0 = ltd4h0;
	}

	public String getLtd4h1() {
		return ltd4h1;
	}

	public void setLtd4h1(String ltd4h1) {
		this.ltd4h1 = ltd4h1;
	}

	public String getLtd4h2() {
		return ltd4h2;
	}

	public void setLtd4h2(String ltd4h2) {
		this.ltd4h2 = ltd4h2;
	}

	public String getLtd4h3() {
		return ltd4h3;
	}

	public void setLtd4h3(String ltd4h3) {
		this.ltd4h3 = ltd4h3;
	}

	public String getLtd4h4() {
		return ltd4h4;
	}

	public void setLtd4h4(String ltd4h4) {
		this.ltd4h4 = ltd4h4;
	}

	public String getLtd5h0() {
		return ltd5h0;
	}

	public void setLtd5h0(String ltd5h0) {
		this.ltd5h0 = ltd5h0;
	}

	public String getLtd5h1() {
		return ltd5h1;
	}

	public void setLtd5h1(String ltd5h1) {
		this.ltd5h1 = ltd5h1;
	}

	public String getLtd5h2() {
		return ltd5h2;
	}

	public void setLtd5h2(String ltd5h2) {
		this.ltd5h2 = ltd5h2;
	}

	public String getLtd5h3() {
		return ltd5h3;
	}

	public void setLtd5h3(String ltd5h3) {
		this.ltd5h3 = ltd5h3;
	}

	public String getLtd5h4() {
		return ltd5h4;
	}

	public void setLtd5h4(String ltd5h4) {
		this.ltd5h4 = ltd5h4;
	}

	public String getLtd6h0() {
		return ltd6h0;
	}

	public void setLtd6h0(String ltd6h0) {
		this.ltd6h0 = ltd6h0;
	}

	public String getLtd6h1() {
		return ltd6h1;
	}

	public void setLtd6h1(String ltd6h1) {
		this.ltd6h1 = ltd6h1;
	}

	public String getLtd6h2() {
		return ltd6h2;
	}

	public void setLtd6h2(String ltd6h2) {
		this.ltd6h2 = ltd6h2;
	}

	public String getLtd6h3() {
		return ltd6h3;
	}

	public void setLtd6h3(String ltd6h3) {
		this.ltd6h3 = ltd6h3;
	}

	public String getLtd6h4() {
		return ltd6h4;
	}

	public void setLtd6h4(String ltd6h4) {
		this.ltd6h4 = ltd6h4;
	}

	public String getLnd1h0() {
		return lnd1h0;
	}

	public void setLnd1h0(String lnd1h0) {
		this.lnd1h0 = lnd1h0;
	}

	public String getLnd1h1() {
		return lnd1h1;
	}

	public void setLnd1h1(String lnd1h1) {
		this.lnd1h1 = lnd1h1;
	}

	public String getLnd1h2() {
		return lnd1h2;
	}

	public void setLnd1h2(String lnd1h2) {
		this.lnd1h2 = lnd1h2;
	}

	public String getLnd2h0() {
		return lnd2h0;
	}

	public void setLnd2h0(String lnd2h0) {
		this.lnd2h0 = lnd2h0;
	}

	public String getLnd2h1() {
		return lnd2h1;
	}

	public void setLnd2h1(String lnd2h1) {
		this.lnd2h1 = lnd2h1;
	}

	public String getLnd2h2() {
		return lnd2h2;
	}

	public void setLnd2h2(String lnd2h2) {
		this.lnd2h2 = lnd2h2;
	}

	public String getLnd3h0() {
		return lnd3h0;
	}

	public void setLnd3h0(String lnd3h0) {
		this.lnd3h0 = lnd3h0;
	}

	public String getLnd3h1() {
		return lnd3h1;
	}

	public void setLnd3h1(String lnd3h1) {
		this.lnd3h1 = lnd3h1;
	}

	public String getLnd3h2() {
		return lnd3h2;
	}

	public void setLnd3h2(String lnd3h2) {
		this.lnd3h2 = lnd3h2;
	}

	public String getLnd4h0() {
		return lnd4h0;
	}

	public void setLnd4h0(String lnd4h0) {
		this.lnd4h0 = lnd4h0;
	}

	public String getLnd4h1() {
		return lnd4h1;
	}

	public void setLnd4h1(String lnd4h1) {
		this.lnd4h1 = lnd4h1;
	}

	public String getLnd4h2() {
		return lnd4h2;
	}

	public void setLnd4h2(String lnd4h2) {
		this.lnd4h2 = lnd4h2;
	}

	public String getLnd5h0() {
		return lnd5h0;
	}

	public void setLnd5h0(String lnd5h0) {
		this.lnd5h0 = lnd5h0;
	}

	public String getLnd5h1() {
		return lnd5h1;
	}

	public void setLnd5h1(String lnd5h1) {
		this.lnd5h1 = lnd5h1;
	}

	public String getLnd5h2() {
		return lnd5h2;
	}

	public void setLnd5h2(String lnd5h2) {
		this.lnd5h2 = lnd5h2;
	}

	public String getLnd6h0() {
		return lnd6h0;
	}

	public void setLnd6h0(String lnd6h0) {
		this.lnd6h0 = lnd6h0;
	}

	public String getLnd6h1() {
		return lnd6h1;
	}

	public void setLnd6h1(String lnd6h1) {
		this.lnd6h1 = lnd6h1;
	}

	public String getLnd6h2() {
		return lnd6h2;
	}

	public void setLnd6h2(String lnd6h2) {
		this.lnd6h2 = lnd6h2;
	}

}