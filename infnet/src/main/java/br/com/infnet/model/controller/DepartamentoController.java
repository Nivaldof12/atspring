package br.com.infnet.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.infnet.model.domain.Departamento;
import br.com.infnet.model.service.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public Iterable<Departamento> getAllDepartamentos() {
        return departamentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id) {
        return departamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.save(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        return departamentoService.findById(id)
                .map(departamentoExistente -> {
                    departamento.setId(departamentoExistente.getId());
                    return ResponseEntity.ok(departamentoService.save(departamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id) {
        if (departamentoService.findById(id).isPresent()) {
            departamentoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
