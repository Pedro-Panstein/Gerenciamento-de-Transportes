package com.weg.Gerenciamento_de_Transportes.model;

import com.weg.Gerenciamento_de_Transportes.model.dtos.response.EnderecoResponseDTO;
import com.weg.Gerenciamento_de_Transportes.model.dtos.response.MotoristaResponseDTO;
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
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
    private String bairro;
    private String cep;

    public EnderecoResponseDTO convertToDto() {
        return new EnderecoResponseDTO(
                this.id,
                this.rua,
                this.numero,
                this.cidade,
                this.estado,
                this.bairro,
                this.cep
        );
    }
}
