package br.com.proway.turmab.grupo5.urnaEletronica.model;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "votos")
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "rg", columnDefinition = "VARCHAR", unique = true, updatable = false, nullable = true)
	private String rg;

	@Column(name = "nome", columnDefinition = "VARCHAR", unique = false, updatable = false, nullable = false)
	private String nome;

	@Column(name = "numero", columnDefinition = "SMALLINT", unique = false, updatable = false, nullable = false)
	private Integer numero;

	@Basic
	private LocalDate data;

	public Voto() {

	}

	public Voto(String rg, String nome, Integer numero) {
		super();
		setRg(rg);
		setNome(nome);
		setNumero(numero);
		this.data = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
