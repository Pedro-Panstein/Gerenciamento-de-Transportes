package com.weg.Gerenciamento_de_Transportes.model.dtos.request;

import com.weg.Gerenciamento_de_Transportes.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EnderecoRequestDTO(
        @NotBlank
        String rua,
        @NotNull
        @Positive
        Integer numero,
        @NotBlank
        String cidade,
        @NotBlank
        String estado,
        @NotBlank
        String bairro,
        @NotBlank
        String cep
) {

    public Endereco convertToEntity() {
        return Endereco.builder()
                .rua(this.rua)
                .numero(this.numero)
                .cidade(this.cidade)
                .estado(this.estado)
                .bairro(this.bairro)
                .cep(this.cep)
                .build();
    }

}