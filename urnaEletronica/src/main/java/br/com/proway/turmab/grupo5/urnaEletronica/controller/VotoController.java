package br.com.proway.turmab.grupo5.urnaEletronica.controller;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.proway.turmab.grupo5.urnaEletronica.form.VotoForm;
import br.com.proway.turmab.grupo5.urnaEletronica.model.Voto;

@RestController
@RequestMapping("/urnaEletronica")
public class VotoController {
	private static final Logger LOGGER = LogManager.getLogger(VotoController.class.getName());

	@Autowired
	private ObjectMapper mapper;

	@GetMapping("/tipoDeVotacao")
	public ResponseEntity<ObjectNode> buscarTipoVotacao() {
		ObjectNode resposta = mapper.createObjectNode();
		resposta.put("status", HttpStatus.OK.value());
		resposta.put("tipoVotacao", "naoanonimo");
		return ResponseEntity.ok(resposta);
	}

	@GetMapping("/votoIndefinido")
	public ResponseEntity<ObjectNode> buscarImgsVotoIndefinido() {
		ObjectNode resposta = mapper.createObjectNode();
		resposta.put("status", HttpStatus.OK.value());
		resposta.putPOJO("urlVotosIndefinidos", Arrays.asList("url1", "url2", "url3"));
		LOGGER.info("Acessou a rota VotoIndefinido...");
		return ResponseEntity.ok(resposta);
	}

	@PostMapping("/voto")
	public ResponseEntity<ObjectNode> registrarVoto(@RequestBody @Validated VotoForm votoForm) {
		ObjectNode resposta = mapper.createObjectNode();
		Voto voto = votoForm.converter();
		resposta.put("status", HttpStatus.OK.value());
		resposta.put("mensagem", "Voto registrado com sucesso!");
		LOGGER.info("Registrou o voto!");

		return ResponseEntity.ok(resposta);
	}


}
