package br.com.proway.turmab.grupo5.urnaEletronica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.proway.turmab.grupo5.urnaEletronica.repository.CandidatoRepository;

@RestController
public class CandidatoController {
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	
	
//	@GetMapping("/candidatos1")
//	public List<Candidato>listarCandidatos() {
//		Candidato candidato = new Candidato("João", 16, "url");
//		List<Candidato> candidatos = new ArrayList<Candidato>();
//		
//		candidatos.add(candidato);
//		candidatos.add(candidato);
//		return candidatos;
//		
//		
//		
//	}
	@GetMapping("/candidatos")
	public ResponseEntity<ObjectNode> listaCandidatos() {
		ObjectNode resposta = mapper.createObjectNode();
		
		resposta.putPOJO("candidatos", candidatoRepository.findAll());
		return ResponseEntity.ok(resposta);
		
	}
	
	
	
	

}
