package com.example.trio_eletro_back.controller;

import com.example.trio_eletro_back.dto.FuncionarioRequestDTO;
import com.example.trio_eletro_back.dto.FuncionarioResponseDTO;
import com.example.trio_eletro_back.entity.FuncionarioEntity;
import com.example.trio_eletro_back.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listar() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarFuncionario());
    }

    // ADICIONAR
    @PostMapping
    public ResponseEntity<Map<String, Object>> addFuncionario(@Valid @RequestBody FuncionarioRequestDTO dto) {
        service.adicionarFuncionario(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Funcionário cadastrado com sucesso!"));
    }

    // ATUALIZAR POR ID
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarFuncionario(
            @PathVariable Long id,
            @RequestBody FuncionarioEntity funcionario) {

        service.atualizarFuncionario(id, funcionario);
        return ResponseEntity.ok(Map.of("Mensagem", "Funcionário atualizado com sucesso!"));
    }

    // EXCLUIR POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluirFuncionario(@PathVariable Long id) {
        service.excluirFuncionario(id);
        return ResponseEntity.ok(Map.of("Mensagem", "Funcionário deletado com sucesso!"));
    }
}