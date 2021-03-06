package br.com.projeto.fullstackweak.resourceOUcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.fullstackweak.domain.Pessoa;
import br.com.projeto.fullstackweak.repository.PessoaRepositoty;

@RestController
@RequestMapping("/pessoas")
public class PessoaResourceOUcontroller {

	@Autowired
	private PessoaRepositoty pessoaRepository;

	@GetMapping //
	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll(); // Retorna todos os elementos do banco de dados
	}

	public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@PutMapping("{codigo}")
	public Pessoa atualizar(@PathVariable("codigo") Long codigo, @RequestBody Pessoa pessoa) {
		return pessoaRepository.findById(codigo).map(record -> {
			record.setCpf(pessoa.getCpf());
			record.setDataNascimento(pessoa.getDataNascimento());
			record.setEmail(pessoa.getEmail());
			record.setIdade(pessoa.getIdade());
			record.setNome(pessoa.getNome());
			record.setTelefone(pessoa.getTelefone());

			Pessoa pessoaAtualizada = pessoaRepository.save(null);
			return pessoaRepository.save(record);
		}).orElse(null);
	}

	@GetMapping("/codigo/{codigo}")
	public Pessoa buscarPeloCodigo(@PathVariable Long codigo) {
		return pessoaRepository.findById(codigo).orElse(null);
	}
}
















