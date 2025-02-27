package com.weg.Gerenciamento_de_Transportes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "tb_rota")
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origem_id", referencedColumnName = "id")
    private Endereco origem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destino_id", referencedColumnName = "id")
    private Endereco destino;

    private Double distancia;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
}
