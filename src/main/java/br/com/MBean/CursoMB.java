package br.com.MBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.DAO.cursoDAO;
import br.com.entities.Curso;

@ManagedBean
@RequestScoped
public class CursoMB {
	Curso cur;
	cursoDAO cDAO;
	List<Curso> cuu;

public CursoMB(){
	cur = new Curso();
	
	
	
}
}
