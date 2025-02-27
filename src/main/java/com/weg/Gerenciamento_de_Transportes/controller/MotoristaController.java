package com.weg.Gerenciamento_de_Transportes.controller;

import com.weg.Gerenciamento_de_Transportes.model.Motorista;
import com.weg.Gerenciamento_de_Transportes.model.dtos.request.MotoristaRequestDTO;
import com.weg.Gerenciamento_de_Transportes.model.dtos.response.MotoristaResponseDTO;
import com.weg.Gerenciamento_de_Transportes.service.MotoristaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("motorista")
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaController {
    private MotoristaService service;

    @PostMapping("/adicionar")
    public ResponseEntity<MotoristaResponseDTO> criarMotorista(@RequestBody @Validated MotoristaRequestDTO motoristaDTO) {
        MotoristaResponseDTO novoMotorista = service.criarMotorista(motoristaDTO);
        return new ResponseEntity<>(novoMotorista, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<MotoristaResponseDTO> editarMotorista(@PathVariable Long id, @RequestBody MotoristaRequestDTO motoristaDTO) {
        MotoristaResponseDTO motoristaEditado = service.editarMotorista(id, motoristaDTO);
        return new ResponseEntity<>(motoristaEditado, HttpStatus.OK);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<MotoristaResponseDTO> buscarMotoristaPorId(@PathVariable Long id) {
        MotoristaResponseDTO motorista = service.buscarMotoristaPorId(id);
        return new ResponseEntity<>(motorista, HttpStatus.OK);
    }

    @GetMapping("/buscatTodos")
    public ResponseEntity<Page<MotoristaResponseDTO>> listarMotoristas(@PageableDefault(page = 0, size = 20, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<MotoristaResponseDTO> motoristas = service.listarTodosMotoristas(pageable);
        return new ResponseEntity<>(motoristas, HttpStatus.OK);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarMotorista(Long id) {
        String mensagem = service.deletarMotorista(id);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }
}
