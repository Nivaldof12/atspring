package br.com.infnet.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.model.domain.Departamento;
import br.com.infnet.model.repository.DepartamentoRepository;

import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Iterable<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }
}
