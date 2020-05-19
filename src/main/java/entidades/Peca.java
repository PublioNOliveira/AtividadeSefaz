package entidades;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="PECA")
public class Peca {
	private String nome;
	private String referencia;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
}
