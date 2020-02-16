package br.com.aprendendospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aprendendospring.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
