package br.gov.caixa.psi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.caixa.psi.entity.ContratoCreditoImobiliario;

@Repository
public interface ContratoCreditoImobiliarioRepository extends JpaRepository<ContratoCreditoImobiliario, Long> {
}
