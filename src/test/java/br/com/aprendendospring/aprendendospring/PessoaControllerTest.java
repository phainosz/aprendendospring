//package br.com.aprendendospring.aprendendospring;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import br.com.aprendendospring.entity.Pessoa;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//public class PessoaControllerTest {
//
//	@Autowired
//	protected TestRestTemplate rest;
//
//	private ResponseEntity<Pessoa> getPessoa(String url) {
//		return rest.withBasicAuth("user", "123").getForEntity(url, Pessoa.class);
//	}
//
//	private ResponseEntity<List<Pessoa>> getPessoas(String url) {
//		return rest.withBasicAuth("user", "123").exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Pessoa>>() {
//		});
//	}
//
//	private ResponseEntity<Pessoa> postPessoa(String url, Pessoa pessoa) {
//		return rest.withBasicAuth("admin", "123").postForEntity(url, pessoa, null);
//	}
//
//	@Test
//	public void teste1() {
//		Pessoa pessoa = new Pessoa();
//		pessoa.setIdade(27);
//		pessoa.setNome("Paulo");
//		pessoa.setNascimento(LocalDate.parse("1993-01-19"));
//		ResponseEntity<Pessoa> pessoaResponse = postPessoa("/pessoas", pessoa);
//
//		assertEquals(HttpStatus.CREATED, pessoaResponse.getStatusCode());
//
//		String location = pessoaResponse.getHeaders().get("Location").get(0);
//		Pessoa pessoaInserida = getPessoa(location).getBody();
//
//		assertNotNull(pessoaInserida);
//		assertEquals(pessoaInserida.getId(), 1L);
//
//		rest.withBasicAuth("user", "123").delete(location);
//
//	}
//
//	@Test
//	public void teste2() {
//		List<Pessoa> pessoas = getPessoas("/pessoas").getBody();
//		assertTrue(pessoas.isEmpty());
//	}
//}
