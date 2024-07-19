package br.gov.caixa.psi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.caixa.psi.entity.ContratoCreditoImobiliario;
import br.gov.caixa.psi.service.ContratoCreditoImobiliarioService;

@RestController
@RequestMapping("/contratos")
public class ContratoCreditoImobiliarioController {

    @Autowired
    private ContratoCreditoImobiliarioService service;

    @GetMapping("/")
    public ResponseEntity<List<ContratoCreditoImobiliario>> getAll() {
        List<ContratoCreditoImobiliario> contratos = service.findAll();
        return ResponseEntity.ok(contratos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoCreditoImobiliario> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContratoCreditoImobiliario> create(@RequestBody ContratoCreditoImobiliario contrato) {
        ContratoCreditoImobiliario savedContrato = service.save(contrato);
        return ResponseEntity.ok(savedContrato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoCreditoImobiliario> update(@PathVariable Long id, @RequestBody ContratoCreditoImobiliario contrato) {
        return service.findById(id)
                .map(existingContract -> {
                    contrato.setId(existingContract.getId());
                    ContratoCreditoImobiliario updatedContrato = service.save(contrato);
                    return ResponseEntity.ok(updatedContrato);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(contrato -> {
                    service.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}