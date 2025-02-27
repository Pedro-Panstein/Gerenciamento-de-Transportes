package com.weg.Gerenciamento_de_Transportes.model.dtos.response;

public record EnderecoResponseDTO(
        Long id,
        String rua,
        Integer numero,
        String cidade,
        String estado,
        String bairro,
        String cep
) {
}
