package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidades.Usuario;

@ManagedBean(name = "UsuarioBean")
@SessionScoped
public class UsuarioBean {

	private String txtNome;
	private String txtEmail;
	private Double txtCpf;
	private String txtSenha;

	private List<Usuario> listaUsuarios;
	private Usuario usuario; 
	private String cadastroUsuario;
	
	private UsuarioDAO usuarioDAO;

	
	public UsuarioBean() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAOImpl();
	}


	public String entrar() {

		boolean achou = false;

		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {

			if (usuarioPesquisa.getEmail().equals(this.txtEmail) && usuarioPesquisa.getSenha().equals(this.txtSenha)) {

				achou = true;
			}
		}

		if (achou) {
			return "PesquisarVeiculo.xhtml";
		} else {
			return "index.xhtml";
		}

	}

	public void criarUsuario() {

		Usuario novo = new Usuario();
		novo.setEmail(this.usuario.getEmail());
		novo.setNome(this.usuario.getNome());
		novo.setCpf(this.usuario.getCpf());
		novo.setSenha(this.usuario.getSenha());

		boolean achou = false;
		
		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {
			if (usuarioPesquisa.getCpf().equals(this.usuario.getCpf())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario já existe!!!"));
		}else {
			this.usuarioDAO.inserir(novo);
			
			this.usuario = new Usuario();	
		}
	}

	public String getTxtNome() {
		return txtNome;
	}

	public void setTxtTxtNome(String txtNome) {
		this.txtNome = txtNome;
	}
	
	public String getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(String TxtEmail) {
		this.txtEmail = TxtEmail;
	}
	
	public Double getTxtCpf() {
		return txtCpf;
	}

	public void setTxtCpf(Double txtCpf) {
		this.txtCpf = txtCpf;
	}
	
	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getcadastroUsuario() {
		return cadastroUsuario;
	}

	public void setcadastroUsuario(String cadastroUsuario) {
		this.cadastroUsuario = cadastroUsuario;
	}

}
