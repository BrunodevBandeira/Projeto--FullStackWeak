package br.com.projeto.fullstackweak.resourceOUcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.fullstackweak.domain.Pessoa;
import br.com.projeto.fullstackweak.repository.PessoaRepositoty;

@RestController
@RequestMapping("/pessoas")
public class PessoaResourceOUcontroller {

	@Autowired
	private PessoaRepositoty pessoaRepository;
	
	public List<Pessoa> listarTodos(){
		
	}
	
}
