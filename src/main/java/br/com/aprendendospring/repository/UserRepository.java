package br.com.aprendendospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aprendendospring.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);
}
