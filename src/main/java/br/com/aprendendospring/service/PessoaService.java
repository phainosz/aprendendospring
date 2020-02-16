package br.com.aprendendospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aprendendospring.entity.Pessoa;
import br.com.aprendendospring.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> getPessoas() {
		return pessoaRepository.findAll();
	}

	public Pessoa inserir(Pessoa pessoa) {
		return pessoa != null ? pessoaRepository.save(pessoa) : null;
	}

	public Pessoa buscarPorId(Long id) {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		return optional.isPresent() ? optional.get() : optional.orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
	}

	public void deletar(Long id) {
		pessoaRepository.deleteById(id);
	}

	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaDb = buscarPorId(id);
		pessoaDb.setNome(pessoa.getNome());
		pessoaDb.setIdade(pessoa.getIdade());
		pessoaDb.setNascimento(pessoa.getNascimento());
		pessoaRepository.save(pessoaDb);

		return pessoaDb;

	}
}
