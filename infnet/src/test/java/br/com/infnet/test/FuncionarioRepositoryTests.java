package br.com.infnet.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import br.com.infnet.model.domain.Departamento;
import br.com.infnet.model.domain.Funcionario;
import br.com.infnet.model.repository.DepartamentoRepository;
import br.com.infnet.model.repository.FuncionarioRepository;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class FuncionarioRepositoryTests {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    public void testCreateAndFindFuncionario() {
        Departamento departamento = new Departamento();
        departamento.setNome("Recursos Humanos");
        departamento.setLocal("Bloco A");
        
        departamentoRepository.save(departamento);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João Silva");
        funcionario.setEndereco("Rua ABC, 123");
        funcionario.setTelefone("123456789");
        funcionario.setEmail("joao.silva@example.com");
        funcionario.setDataNascimento(new Date());
        funcionario.setDepartamento(departamento);
        
        funcionarioRepository.save(funcionario);

        Optional<Funcionario> foundFuncionario = funcionarioRepository.findById(funcionario.getId());

        assertThat(foundFuncionario.isPresent()).isTrue();
        assertThat(foundFuncionario.get().getNome()).isEqualTo("João Silva");
        assertThat(foundFuncionario.get().getDepartamento().getNome()).isEqualTo("Recursos Humanos");
    }

    @Test
    public void testUpdateFuncionario() {
        Departamento departamento = new Departamento();
        departamento.setNome("Recursos Humanos");
        departamento.setLocal("Bloco A");
        
        departamentoRepository.save(departamento);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João Silva");
        funcionario.setEndereco("Rua ABC, 123");
        funcionario.setTelefone("123456789");
        funcionario.setEmail("joao.silva@example.com");
        funcionario.setDataNascimento(new Date());
        funcionario.setDepartamento(departamento);
        
        funcionarioRepository.save(funcionario);

        funcionario.setNome("João Silva Atualizado");
        funcionario.setEndereco("Rua XYZ, 456");
        funcionario.setTelefone("987654321");
        funcionario.setEmail("joao.silva.atualizado@example.com");

        funcionarioRepository.save(funcionario);

        Optional<Funcionario> foundFuncionario = funcionarioRepository.findById(funcionario.getId());

        assertThat(foundFuncionario.isPresent()).isTrue();
        assertThat(foundFuncionario.get().getNome()).isEqualTo("João Silva Atualizado");
    }

    @Test
    public void testDeleteFuncionario() {
        Departamento departamento = new Departamento();
        departamento.setNome("Recursos Humanos");
        departamento.setLocal("Bloco A");
        
        departamentoRepository.save(departamento);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João Silva");
        funcionario.setEndereco("Rua ABC, 123");
        funcionario.setTelefone("123456789");
        funcionario.setEmail("joao.silva@example.com");
        funcionario.setDataNascimento(new Date());
        funcionario.setDepartamento(departamento);
        
        funcionarioRepository.save(funcionario);

        funcionarioRepository.deleteById(funcionario.getId());

        Optional<Funcionario> foundFuncionario = funcionarioRepository.findById(funcionario.getId());

        assertThat(foundFuncionario.isPresent()).isFalse();
    }
}
