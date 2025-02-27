package com.weg.Gerenciamento_de_Transportes.model.dtos.response;

import com.weg.Gerenciamento_de_Transportes.model.Endereco;
import com.weg.Gerenciamento_de_Transportes.model.Rota;
import com.weg.Gerenciamento_de_Transportes.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MotoristaResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        Endereco endereco,
        List<Veiculo> veiculos,
        List<Rota> rotas) {
}
