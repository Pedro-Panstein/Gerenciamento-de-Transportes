package com.weg.Gerenciamento_de_Transportes.repository;

import com.weg.Gerenciamento_de_Transportes.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {
}
