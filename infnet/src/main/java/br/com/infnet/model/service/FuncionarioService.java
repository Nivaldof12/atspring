package br.com.infnet.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.model.domain.Departamento;
import br.com.infnet.model.domain.Funcionario;
import br.com.infnet.model.repository.DepartamentoRepository;
import br.com.infnet.model.repository.FuncionarioRepository;

import java.util.Optional;

@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Iterable<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario save(Funcionario funcionario) {
        // Carregar o departamento completo
        if (funcionario.getDepartamento() != null && funcionario.getDepartamento().getId() != null) {
            Optional<Departamento> departamentoOpt = departamentoRepository.findById(funcionario.getDepartamento().getId());
            departamentoOpt.ifPresent(funcionario::setDepartamento);
        }
        return funcionarioRepository.save(funcionario);
    }

    public void deleteById(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
