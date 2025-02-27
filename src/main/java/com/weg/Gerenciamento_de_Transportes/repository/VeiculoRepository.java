package com.weg.Gerenciamento_de_Transportes.repository;

import com.weg.Gerenciamento_de_Transportes.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
