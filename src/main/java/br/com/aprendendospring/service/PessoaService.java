package br.com.aprendendospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aprendendospring.model.Pessoa;
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

	public Optional<Pessoa> buscarPorId(Long id) {
		return pessoaRepository.findById(id);
	}

	public Boolean deletar(Long id) {
		if (buscarPorId(id).isPresent()) {
			pessoaRepository.deleteById(id);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
