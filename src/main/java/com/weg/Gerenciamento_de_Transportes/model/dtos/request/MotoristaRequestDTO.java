package com.weg.Gerenciamento_de_Transportes.model.dtos.request;

import com.weg.Gerenciamento_de_Transportes.model.Endereco;
import com.weg.Gerenciamento_de_Transportes.model.Motorista;
import com.weg.Gerenciamento_de_Transportes.model.Rota;
import com.weg.Gerenciamento_de_Transportes.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MotoristaRequestDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotNull
        Endereco endereco,
        List<Veiculo> veiculos,
        List<Rota> rotas
) {
    public Motorista convertToEntity() {
        return Motorista.builder()
                .nome(this.nome)
                .email(this.email)
                .telefone(this.telefone)
                .endereco(this.endereco)
                .veiculos(this.veiculos)
                .rotas(this.rotas)
                .build();
    }
}
