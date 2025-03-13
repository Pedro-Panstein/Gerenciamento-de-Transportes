package com.weg.Gerenciamento_de_Transportes.model;

import com.weg.Gerenciamento_de_Transportes.model.dtos.response.MotoristaResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "tb_motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = true)
    private Endereco endereco;

    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<Rota> rotas;

    public MotoristaResponseDTO convertToDto() {
        return new MotoristaResponseDTO(
                this.id,
                this.nome,
                this.email,
                this.telefone,
                this.endereco,
                this.veiculos,
                this.rotas
        );
    }
}
