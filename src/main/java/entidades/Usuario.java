package entidades;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	private String email;
	private String nome;
	private Double cpf;
	private String senha;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getCpf() {
		return cpf;
	}

	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
