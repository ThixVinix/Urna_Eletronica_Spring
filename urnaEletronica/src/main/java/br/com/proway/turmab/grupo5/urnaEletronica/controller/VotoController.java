package br.com.proway.turmab.grupo5.urnaEletronica.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.proway.turmab.grupo5.urnaEletronica.dto.ApuracaoDTO;
import br.com.proway.turmab.grupo5.urnaEletronica.form.VotoForm;
import br.com.proway.turmab.grupo5.urnaEletronica.model.Candidato;
import br.com.proway.turmab.grupo5.urnaEletronica.model.Voto;
import br.com.proway.turmab.grupo5.urnaEletronica.repository.CandidatoRepository;
import br.com.proway.turmab.grupo5.urnaEletronica.repository.VotoRepository;
import br.com.proway.turmab.grupo5.urnaEletronica.util.Constante;

@RestController
@RequestMapping("/urnaEletronica")
public class VotoController {
	private static final Logger LOGGER = LogManager.getLogger(VotoController.class.getName());

	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private VotoRepository votoRepository;
	@Autowired
	private CandidatoRepository candidatoRepository;

	@GetMapping("/tipoDeVotacao")
	public ResponseEntity<ObjectNode> buscarTipoVotacao() {
		ObjectNode resposta = mapper.createObjectNode();
		preencherCorpoRespostaPadrao(resposta, HttpStatus.OK);
		resposta.put("tipoVotacao", "naoanonimo");
		return ResponseEntity.ok(resposta);
	}

	@GetMapping("/apuracao")
	public ResponseEntity<ObjectNode> exibirRelatorioUrna() {
		ObjectNode resposta = mapper.createObjectNode();
		
		List<Candidato> candidatos = candidatoRepository.findAll();
	
		List<ApuracaoDTO> apuracaoDTO = new ArrayList<ApuracaoDTO>();	
		for (Candidato candidato : candidatos) {
			ApuracaoDTO dto = new ApuracaoDTO(candidato);
			apuracaoDTO.add(dto);
		}
		
		List<Voto> votos = votoRepository.findAll();

		for (Voto voto : votos) {
			for (ApuracaoDTO apuracao :apuracaoDTO) {
				if (apuracao.getNumero() == voto.getNumero()) {	
					apuracao.setVotos(apuracao.getVotos()+1);
					break;
				}
			}
			
		}
		preencherCorpoRespostaPadrao(resposta,HttpStatus.OK);
		resposta.putPOJO("apuracao",apuracaoDTO);
		
		return ResponseEntity.ok(resposta);

	}

	@GetMapping("/votoIndefinido")
	public ResponseEntity<ObjectNode> buscarImgsVotoIndefinido() {

		ObjectNode resposta = mapper.createObjectNode();

		final String CAMINHO = Constante.DIRETORIO_IMGS + "votosIndefinidos/";
		final String CANDIDATO_NAO_IDENTIFICADO = "candidato-nao-identificado.jpg";
		final String VOTO_BRANCO = "voto-branco.jpg";
		final String VOTO_NULO = "voto-nulo.png";

		preencherCorpoRespostaPadrao(resposta, HttpStatus.OK);
		resposta.putPOJO("urlVotosIndefinidos",
				Arrays.asList((CAMINHO + CANDIDATO_NAO_IDENTIFICADO), (CAMINHO + VOTO_BRANCO), (CAMINHO + VOTO_NULO)));

		LOGGER.info("Acessou a rota VotoIndefinido...");

		return ResponseEntity.ok(resposta);
	}

	@PostMapping("/voto")
	public ResponseEntity<ObjectNode> registrarVoto(@RequestBody @Valid VotoForm votoForm, BindingResult br) {

		ObjectNode resposta = mapper.createObjectNode();

		if (br.hasErrors()) {
			preencherCorpoRespostaPadrao(resposta, HttpStatus.BAD_REQUEST, "Nao foi possivel registrar o voto");
			resposta.putPOJO(Constante.ERROS, listarErros(br));
			return ResponseEntity.badRequest().body(resposta);
		}

		Voto voto = votoForm.converter();
		votoRepository.save(voto);

		preencherCorpoRespostaPadrao(resposta, HttpStatus.OK, "Voto registrado com sucesso!");

		LOGGER.info("Registrou o voto!");

		return ResponseEntity.ok(resposta);
	}

	/**
	 * <p>
	 * Preenche o corpo da resposta (response body) com uma "mensagem"(Exemplo: ,
	 * "status" e "motivo" para ser utilizado no retorno do endpoint
	 * </p>
	 * 
	 * @param resposta - Objeto da classe {@link ObjectNode} no qual vai formatar a
	 *                 resposta no formato JSON.
	 * @param hs       - Objeto do enum {@link HttpStatus} no qual vai ser utilizado
	 *                 para preencher o numero (Exemplo: 200) e motivo (Exemplo:
	 *                 'OK') da resposta.
	 * @param mensagem - Mensagem ({@link String}) da resposta (Exemplo: 'Enviado
	 *                 com sucesso').
	 * 
	 */
	private void preencherCorpoRespostaPadrao(ObjectNode resposta, HttpStatus hs, String mensagem) {
		resposta.put(Constante.MSG, mensagem);
		resposta.put(Constante.STATUS, hs.value());
		resposta.put(Constante.MOTIVO, hs.getReasonPhrase());
	}

	/**
	 * <p>
	 * Preenche o corpo da resposta (response body) com o "status" e "motivo" para
	 * ser utilizado no retorno do endpoint
	 * </p>
	 * 
	 * @param resposta - Objeto da classe {@link ObjectNode} no qual vai formatar a
	 *                 resposta no formato JSON.
	 * @param hs       - Objeto do enum {@link HttpStatus} no qual vai ser utilizado
	 *                 para preencher o numero (Exemplo: 200) e motivo (Exemplo:
	 *                 'OK') da resposta.
	 * 
	 */
	private void preencherCorpoRespostaPadrao(ObjectNode resposta, HttpStatus hs) {
		resposta.put(Constante.STATUS, hs.value());
		resposta.put(Constante.MOTIVO, hs.getReasonPhrase());
	}

	/**
	 * <p>
	 * Lista o(s) erro(s) encontrado(s) no formulario pelo Spring
	 * </p>
	 * 
	 * @param br - Objeto da interface {@link BindingResult} que coleta a situacao
	 *           do formulario passado pela requisicao
	 */
	private List<String> listarErros(BindingResult br) {
		List<String> listaErros = new ArrayList<>();
		List<FieldError> errors = br.getFieldErrors();
		for (FieldError error : errors) {
			String msgErro = error.getField() + " - " + error.getDefaultMessage();
			listaErros.add(msgErro);
		}
		return listaErros;
	}
	
	

	
}