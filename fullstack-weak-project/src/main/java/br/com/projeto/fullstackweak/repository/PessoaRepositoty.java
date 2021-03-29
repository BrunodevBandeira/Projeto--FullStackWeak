package br.com.projeto.fullstackweak.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.fullstackweak.domain.Pessoa;


public interface PessoaRepositoty extends JpaRepository<Pessoa, Long>{

}
