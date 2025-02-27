package com.weg.Gerenciamento_de_Transportes.model.dtos.request;

import com.weg.Gerenciamento_de_Transportes.model.Motorista;
import com.weg.Gerenciamento_de_Transportes.model.Veiculo;

public record VeiculoRequestDTO(
        String marca,
        String modelo,
        String placa,
        Motorista motorista
) {

    public Veiculo convert() {
        return Veiculo.builder()
                .marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .motorista(this.motorista)
                .build();
    }
}
