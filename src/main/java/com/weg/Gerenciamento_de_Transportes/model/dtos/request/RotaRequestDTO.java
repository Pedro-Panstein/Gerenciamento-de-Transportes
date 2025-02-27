package com.weg.Gerenciamento_de_Transportes.model.dtos.request;

import com.weg.Gerenciamento_de_Transportes.model.Endereco;
import com.weg.Gerenciamento_de_Transportes.model.Motorista;
import com.weg.Gerenciamento_de_Transportes.model.Rota;

public record RotaRequestDTO(
        Endereco origem,
        Endereco destino,
        Double distancia,
        Motorista motorista
) {

    public Rota convert() {
        return Rota.builder()
                .origem(this.origem)
                .destino(this.destino)
                .distancia(this.distancia)
                .motorista(this.motorista)
                .build();
    }
}
