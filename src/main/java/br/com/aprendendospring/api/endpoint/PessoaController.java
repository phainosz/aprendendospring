package br.com.aprendendospring.api.endpoint;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sun.istack.NotNull;

import br.com.aprendendospring.entity.Pessoa;
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
		Pessoa pessoa = pessoasService.buscarPorId(id);
			return ResponseEntity.ok(pessoa);
	}

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Pessoa pessoa) {
		pessoa = pessoasService.inserir(pessoa);
		return pessoa != null ? ResponseEntity.created(getUri(pessoa.getId())).body(pessoa) : ResponseEntity.badRequest().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		pessoasService.deletar(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@NotNull @PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
		Pessoa atualizar = pessoasService.atualizar(id, pessoa);

		return atualizar != null ? ResponseEntity.ok(atualizar) : ResponseEntity.notFound().build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
