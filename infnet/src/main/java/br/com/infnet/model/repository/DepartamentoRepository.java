package br.com.infnet.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.infnet.model.domain.Departamento;

public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
}
