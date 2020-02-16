package br.com.aprendendospring.aprendendospring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.aprendendospring.entity.Pessoa;
import br.com.aprendendospring.service.PessoaService;

@SpringBootTest
public class PessoaTest {

	@Autowired
	private PessoaService pessoaService;

	@Test
	public void testCrud() {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdade(27);
		pessoa.setNome("Paulo Henrique");
		pessoa.setNascimento(LocalDate.parse("1993-01-19"));

		// inserir
		Pessoa inserir = pessoaService.inserir(pessoa);

		Long id = inserir.getId();

		// buscar
		assertNotNull(id);
		assertTrue(pessoaService.buscarPorId(inserir.getId()) != null);

		// atualizar
		String novoNome = "Novo nome";
		inserir.setNome(novoNome);
		Pessoa atualizar = pessoaService.atualizar(id, inserir);
		assertNotNull(atualizar);
		assertEquals(atualizar.getNome(), novoNome);

		// deletar
		pessoaService.deletar(id);
	}
}
