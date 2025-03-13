package com.weg.Gerenciamento_de_Transportes.service;

import com.weg.Gerenciamento_de_Transportes.model.Endereco;
import com.weg.Gerenciamento_de_Transportes.model.dtos.request.EnderecoRequestDTO;
import com.weg.Gerenciamento_de_Transportes.model.dtos.response.EnderecoResponseDTO;
import com.weg.Gerenciamento_de_Transportes.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnderecoService {
    private EnderecoRepository repository;

    public EnderecoResponseDTO criarEndereco(EnderecoRequestDTO enderecoRequestDTO) {
        Endereco endereco = enderecoRequestDTO.convertToEntity();
        return repository.save(endereco).convertToDto();
    }

    public EnderecoResponseDTO editarEndereco(Long id, EnderecoRequestDTO enderecoRequestDTO) {
        Endereco novoEndereco = enderecoRequestDTO.convertToEntity();
        novoEndereco.setId(id);
        return repository.save(novoEndereco).convertToDto();
    }

    public EnderecoResponseDTO buscarEnderecoPorId(Long id) {
        Endereco endereco = repository.findById(id).orElseThrow();
        return endereco.convertToDto();
    }

    public Page<EnderecoResponseDTO> listarTodosEnderecos(Pageable pageable) {
        return repository.findAll(pageable).map(Endereco::convertToDto);
    }

    public String deletarEndereco(Long id) {
        repository.deleteById(id);
        return "Endereço deletado com sucesso";
    }
}