package br.gov.caixa.psi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.caixa.psi.entity.ContratoCreditoImobiliario;
import br.gov.caixa.psi.repository.ContratoCreditoImobiliarioRepository;

@Service
public class ContratoCreditoImobiliarioService {

    private final ContratoCreditoImobiliarioRepository repository;
    
    @Autowired
    public ContratoCreditoImobiliarioService(ContratoCreditoImobiliarioRepository contratoCreditoImobiliarioRepository) {
    	this.repository = contratoCreditoImobiliarioRepository;
    }

    public List<ContratoCreditoImobiliario> findAll() {
        return repository.findAll();
    }

    public Optional<ContratoCreditoImobiliario> findById(Long id) {
        return repository.findById(id);
    }

    public ContratoCreditoImobiliario save(ContratoCreditoImobiliario contrato) {
        return repository.save(contrato);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}