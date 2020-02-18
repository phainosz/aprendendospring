package br.com.aprendendospring.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.aprendendospring.api.exception.Mensagem;
import br.com.aprendendospring.entity.User;
import br.com.aprendendospring.repository.UserRepository;

@Service(value = "userDetailsService")
public class UserDetaisServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRep.findByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException(new Mensagem("User not found").toString());
		}
		return user;
	}

}
