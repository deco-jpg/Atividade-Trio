package com.example.trio_eletro_back.controller;

import com.example.trio_eletro_back.dto.ClienteRequestDTO;
import com.example.trio_eletro_back.dto.ClienteResponseDTO;
import com.example.trio_eletro_back.entity.ClienteEntity;
import com.example.trio_eletro_back.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // LISTAR TODOS (Retorna apenas Nome e E-mail no formato DTO)
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarClientes());
    }

    // ADICIONAR (Recebe o RequestDTO com validações)
    @PostMapping
    public ResponseEntity<Map<String, Object>> addCliente(@Valid @RequestBody ClienteRequestDTO dto) {
        service.adicionarCliente(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Cliente cadastrado com sucesso!"));
    }

    // ATUALIZAR POR ID
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarCliente(
            @PathVariable Long id,
            @RequestBody ClienteEntity cliente) {

        service.atualizarCliente(id, cliente);
        return ResponseEntity.ok(Map.of("Mensagem", "Cliente atualizado com sucesso!"));
    }

    // EXCLUIR POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluirCliente(@PathVariable Long id) {
        service.excluirCliente(id);
        return ResponseEntity.ok(Map.of("Mensagem", "Cliente deletado com sucesso!"));
    }
}