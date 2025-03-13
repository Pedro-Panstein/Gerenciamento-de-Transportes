package com.weg.Gerenciamento_de_Transportes.repository;

import com.weg.Gerenciamento_de_Transportes.model.Motorista;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long>, JpaSpecificationExecutor<Motorista> {
}
