package com.weg.Gerenciamento_de_Transportes.repository;

import com.weg.Gerenciamento_de_Transportes.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
