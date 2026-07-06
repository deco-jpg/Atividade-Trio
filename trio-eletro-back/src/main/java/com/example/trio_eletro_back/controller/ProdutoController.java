package com.example.trio_eletro_back.controller;

import com.example.trio_eletro_back.dto.ProdutoRequestDTO;
import com.example.trio_eletro_back.dto.ProdutoResponseDTO;
import com.example.trio_eletro_back.entity.ProdutoEntity;
import com.example.trio_eletro_back.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarProdutos());
    }

    // ADICIONAR
    @PostMapping
    public ResponseEntity<Map<String, Object>> addProduto(@Valid @RequestBody ProdutoRequestDTO dto) {
        service.adicionarProduto(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Produto cadastrado com sucesso!"));
    }

    // ATUALIZAR POR ID
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarProduto(
            @PathVariable Long id,
            @RequestBody ProdutoEntity produto) {

        service.atualizarProduto(id, produto);
        return ResponseEntity.ok(Map.of("Mensagem", "Produto atualizado com sucesso!"));
    }

    // EXCLUIR POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluirProduto(@PathVariable Long id) {
        service.excluirProduto(id);
        return ResponseEntity.ok(Map.of("Mensagem", "Produto deletado com sucesso!"));
    }
}