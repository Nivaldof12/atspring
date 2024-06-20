package br.com.infnet.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.infnet.model.domain.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}
