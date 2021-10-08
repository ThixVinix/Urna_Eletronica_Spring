package br.com.proway.turmab.grupo5.urnaEletronica.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.proway.turmab.grupo5.urnaEletronica.model.Voto;

public class VotoForm {
	private String rg;
	@NotNull
	@NotEmpty
	private String nome;

	@Pattern(regexp = "[0-9]+", message = "deve conter apenas numeros")
	@Min(value = 1)
	@Max(value = 2147483647)
	private String numeroCandidato;

	public String getRg() {
		return rg;
	}

	public String getNome() {
		return nome;
	}

	public String getNumeroCandidato() {
		return numeroCandidato;
	}

	public Voto converter() {
		return new Voto(getRg(), getNome(), Integer.parseInt(getNumeroCandidato()));
	}
}
