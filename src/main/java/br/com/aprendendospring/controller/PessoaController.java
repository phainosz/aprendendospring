package br.com.aprendendospring.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.aprendendospring.model.Pessoa;
import br.com.aprendendospring.service.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoasService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(pessoasService.getPessoas());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
		Optional<Pessoa> pessoaOptional = pessoasService.buscarPorId(id);
		if (pessoaOptional.isPresent()) {
			return ResponseEntity.ok(pessoaOptional.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
	}

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Pessoa pessoa) {
		pessoa = pessoasService.inserir(pessoa);
		return pessoa != null ? ResponseEntity.created(getUri(pessoa.getId())).body(pessoa) : ResponseEntity.badRequest().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		return pessoasService.deletar(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
