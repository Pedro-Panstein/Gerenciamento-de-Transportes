package com.weg.Gerenciamento_de_Transportes.service;

import com.weg.Gerenciamento_de_Transportes.model.Motorista;
import com.weg.Gerenciamento_de_Transportes.model.dtos.request.MotoristaRequestDTO;
import com.weg.Gerenciamento_de_Transportes.model.dtos.response.MotoristaResponseDTO;
import com.weg.Gerenciamento_de_Transportes.repository.MotoristaRepository;
import com.weg.Gerenciamento_de_Transportes.repository.specs.MotoristaSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MotoristaService {
    private MotoristaRepository repository;
    private MotoristaSpecification specification;

    public MotoristaResponseDTO criarMotorista(MotoristaRequestDTO motoristaDTO) {
        Motorista motorista = motoristaDTO.convertToEntity();
        return repository.save(motorista).convertToDto();
    }

    public MotoristaResponseDTO editarMotorista(Long id, MotoristaRequestDTO motoristaDTO) {
        Motorista novoMotorista = motoristaDTO.convertToEntity();
        novoMotorista.setId(id);
        return repository.save(novoMotorista).convertToDto();
    }

    public MotoristaResponseDTO buscarMotoristaPorId(Long id) {
        Motorista motorista = repository.findById(id).orElseThrow();
        return motorista.convertToDto();
    }

    public Page<MotoristaResponseDTO> listarTodosMotoristas(Pageable pageable) {
        return repository.findAll(pageable).map(Motorista::convertToDto);
    }

    public String deletarMotorista(Long id) {
        repository.deleteById(id);
        return "Motorista deletado com sucesso";
    }

    public List<Motorista> getFilterText(String text) {
        Specification.where(filterText(text).and(filterText(text)));
        return repository.findAll(filterText(text));
    }

    public Specification<Motorista> filterText(String texto) {
        return specification.filterText(texto);
    }
}