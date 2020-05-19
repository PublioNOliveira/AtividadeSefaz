package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.PecaDAO;
import dao.PecaDAOImpl;
import entidades.Peca;

@ManagedBean(name = "PecaBean")
@SessionScoped
public class PecaBean {

	private String txtNome;
	private String txtReferencia;

	private List<Peca> listaPeca;
	private Peca peca; 
	private String cadastroPeca;
	
	private PecaDAO pecaDAO;

	
	public PecaBean() {
		this.listaPeca = new ArrayList<Peca>();
		this.peca = new Peca();
		this.pecaDAO = new PecaDAOImpl();
	}

	
	public void criarPeca() {

		Peca novo = new Peca();

		novo.setNome(this.peca.getNome());
		novo.setReferencia(this.peca.getReferencia());
		

		boolean achou = false;
		
		this.listaPeca = this.pecaDAO.listarTodos();
		
		for (Peca pecaPesquisa : listaPeca) {
			if (pecaPesquisa.getNome().equals(this.getTxtNome())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Peça já existe!!!"));
		}else {
			this.pecaDAO.inserir(peca);
			
			this.peca = new Peca();	
		}
	}

	public String getTxtNome() {
		return txtNome;
	}

	public void setTxtEmail(String txtNome) {
		this.txtNome = txtNome;
	}

	public String getTxtReferencia() {
		return txtReferencia;
	}

	public void setTxtReferencia(String txtReferencia) {
		this.txtReferencia = txtReferencia;
	}

	public List<Peca> getListaPeca() {
		return listaPeca;
	}

	public void setListaUsuarios(List<Peca> listaPeca) {
		this.listaPeca = listaPeca;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public String getCadastroPeca() {
		return cadastroPeca;
	}

	public void setCadastroPeca(String cadastroPeca) {
		this.cadastroPeca = cadastroPeca;
	}

}
