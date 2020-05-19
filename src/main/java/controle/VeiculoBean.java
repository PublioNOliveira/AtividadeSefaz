package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;
import entidades.Veiculo;

@ManagedBean(name = "VeiculoBean")
@SessionScoped
public class VeiculoBean {

	private String txtModelo;
	private String txtMarca;
	private Integer txtAno;
	
	private List<Veiculo> listaVeiculo;
	private Veiculo veiculo; 
	private String cadastroVeiculo;
	
	private VeiculoDAO veiculoDAO;

	public VeiculoBean() {
		this.listaVeiculo = new ArrayList<Veiculo>();
		this.veiculo = new Veiculo();
		this.veiculoDAO = new VeiculoDAOImpl();
	}

	public String entrar() {

		boolean achou = false;

		this.listaVeiculo = this.veiculoDAO.listarTodos();
		
		for (Veiculo veiculoPesquisa : listaVeiculo) {

			if (veiculoPesquisa.getModelo().equals(this.txtModelo)) {

				achou = true;
			}
		}

		if (achou) {
			return "txtModelo";
		} else {
			return "index.xhtml";
		}

	}


	public void criarVeiculo() {

		Veiculo novo = new Veiculo();

		novo.setModelo(this.veiculo.getModelo());
		novo.setMarca(this.veiculo.getMarca());
		novo.setAno(this.veiculo.getAno());

		boolean achou = false;
		
		this.listaVeiculo = this.veiculoDAO.listarTodos();
		
		for (Veiculo veiculoPesquisa : listaVeiculo) {
			if (veiculoPesquisa.getModelo().equals(this.veiculo.getModelo())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Veiculo já existe!!!"));
		}else {

			this.veiculoDAO.inserir(novo);
			
			this.veiculo = new Veiculo();	
		}
	}

	public String getTxtModelo() {
		return txtModelo;
	}

	public void setTxtModelo(String txtModelo) {
		this.txtModelo = txtModelo;
	}

	public String getTxtMarca() {
		return txtMarca;
	}

	public void setTxtMarca(String txtMarca) {
		this.txtMarca = txtMarca;
	}
	
	public int getTxtAno() {
		return txtAno;
	}

	public void setTxtAno(int txtAno) {
		this.txtAno = txtAno;
	}

	public List<Veiculo> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(List<Veiculo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getCadastroVeiculo() {
		return cadastroVeiculo;
	}

	public void setCadastroVeiculo(String cadastroVeiculo) {
		this.cadastroVeiculo = cadastroVeiculo;
	}

}
