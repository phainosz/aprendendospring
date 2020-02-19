package br.com.aprendendospring.api.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String index() {
		return "Bem Vindo ao projeto de aprendizado em Spring Boot";
	}
}
