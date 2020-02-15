package br.com.aprendendospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aprendendospring.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
