package br.com.infnet.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import br.com.infnet.model.domain.Departamento;
import br.com.infnet.model.repository.DepartamentoRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DepartamentoRepositoryTests {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    public void testCreateAndFindDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNome("Recursos Humanos");
        departamento.setLocal("Bloco A");
        
        departamentoRepository.save(departamento);

        Optional<Departamento> foundDepartamento = departamentoRepository.findById(departamento.getId());

        assertThat(foundDepartamento.isPresent()).isTrue();
        assertThat(foundDepartamento.get().getNome()).isEqualTo("Recursos Humanos");
    }

    @Test
    public void testUpdateDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNome("Recursos Humanos");
        departamento.setLocal("Bloco A");
        
        departamentoRepository.save(departamento);

        departamento.setNome("Recursos Humanos Atualizado");
        departamento.setLocal("Bloco B");
        
        departamentoRepository.save(departamento);

        Optional<Departamento> foundDepartamento = departamentoRepository.findById(departamento.getId());

        assertThat(foundDepartamento.isPresent()).isTrue();
        assertThat(foundDepartamento.get().getNome()).isEqualTo("Recursos Humanos Atualizado");
    }

    @Test
    public void testDeleteDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNome("Recursos Humanos");
        departamento.setLocal("Bloco A");
        
        departamentoRepository.save(departamento);

        departamentoRepository.deleteById(departamento.getId());

        Optional<Departamento> foundDepartamento = departamentoRepository.findById(departamento.getId());

        assertThat(foundDepartamento.isPresent()).isFalse();
    }
}
