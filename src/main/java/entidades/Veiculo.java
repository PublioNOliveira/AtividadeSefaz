package entidades;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="VEICULO")
public class Veiculo {
	private String modelo;
	private String marca;
	private Integer ano;
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
		
		
	
	
}
