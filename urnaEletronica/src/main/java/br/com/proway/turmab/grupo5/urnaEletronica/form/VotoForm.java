package br.com.proway.turmab.grupo5.urnaEletronica.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.proway.turmab.grupo5.urnaEletronica.model.Voto;

public class VotoForm {
	private String rg;
	@NotNull
	@NotEmpty
	private String nome;
	private Integer numeroCandidato;

	public String getRg() {
		return rg;
	}

	public String getNome() {
		return nome;
	}

	public Integer getNumeroCandidato() {
		return numeroCandidato;
	}

	public Voto converter() {
		return new Voto(getRg(), getNome(), getNumeroCandidato());
	}
}
