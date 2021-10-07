package br.com.proway.turmab.grupo5.urnaEletronica.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.turmab.grupo5.urnaEletronica.form.UsuarioForm;
import br.com.proway.turmab.grupo5.urnaEletronica.model.Usuario;



@RestController
public class UsuarioController {
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> logar(@RequestBody UsuarioForm form) {
		Usuario usuario = form.conveter();
		if (usuario != null) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	

}
