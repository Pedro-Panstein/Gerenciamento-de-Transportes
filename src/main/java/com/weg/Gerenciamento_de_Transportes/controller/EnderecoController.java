package com.weg.Gerenciamento_de_Transportes.controller;

import com.weg.Gerenciamento_de_Transportes.model.Endereco;
import com.weg.Gerenciamento_de_Transportes.model.dtos.request.EnderecoRequestDTO;
import com.weg.Gerenciamento_de_Transportes.model.dtos.response.EnderecoResponseDTO;
import com.weg.Gerenciamento_de_Transportes.service.EnderecoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("endereco")
@AllArgsConstructor
public class EnderecoController {
    private EnderecoService service;

    @PostMapping("/adicionar")
    public ResponseEntity<EnderecoResponseDTO> criarEndereco(@RequestBody @Validated EnderecoRequestDTO enderecoRequestDTO) {
        EnderecoResponseDTO novoEndereco = service.criarEndereco(enderecoRequestDTO);
        return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
    }
}
