package com.weg.Gerenciamento_de_Transportes.service;

import com.weg.Gerenciamento_de_Transportes.model.Endereco;
import com.weg.Gerenciamento_de_Transportes.model.dtos.request.EnderecoRequestDTO;
import com.weg.Gerenciamento_de_Transportes.model.dtos.response.EnderecoResponseDTO;
import com.weg.Gerenciamento_de_Transportes.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnderecoService {
    private EnderecoRepository repository;

    public EnderecoResponseDTO criarMotorista(EnderecoRequestDTO enderecoRequestDTO) {
        Endereco endereco = enderecoRequestDTO.convertToEntity();
        return repository.save(endereco).convertToDto();
    }
}
