package com.example.trio_eletro_back.service;

import com.example.trio_eletro_back.dto.ProdutoRequestDTO;
import com.example.trio_eletro_back.dto.ProdutoResponseDTO;
import com.example.trio_eletro_back.entity.ProdutoEntity;
import com.example.trio_eletro_back.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    // LISTAR TODOS (Filtrado com nome, preco e estoque do ResponseDTO)
    public List<ProdutoResponseDTO> listarProdutos() {
        return repository.findAll()
                .stream()
                .map(p -> new ProdutoResponseDTO(p.getNome(), p.getPreco(), p.getQuantidadeEstoque()))
                .toList();
    }

    // ADICIONAR
    public ProdutoEntity adicionarProduto(ProdutoRequestDTO dto) {
        if (repository.findByModelo(dto.getModelo()).isPresent()) {
            throw new IllegalArgumentException("Este modelo de produto já está cadastrado!");
        }

        ProdutoEntity novoProduto = new ProdutoEntity();
        novoProduto.setNome(dto.getNome());
        novoProduto.setMarca(dto.getMarca());
        novoProduto.setModelo(dto.getModelo());
        novoProduto.setPreco(dto.getPreco());
        novoProduto.setQuantidadeEstoque(dto.getQuantidadeEstoque());

        return repository.save(novoProduto);
    }

    // ATUALIZAR POR ID
    public ProdutoEntity atualizarProduto(Long id, ProdutoEntity novosDados) {
        ProdutoEntity produtoExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto com ID " + id + " não encontrado"));

        produtoExistente.setNome(novosDados.getNome());
        produtoExistente.setMarca(novosDados.getMarca());
        produtoExistente.setModelo(novosDados.getModelo());
        produtoExistente.setPreco(novosDados.getPreco());
        produtoExistente.setQuantidadeEstoque(novosDados.getQuantidadeEstoque());

        return repository.save(produtoExistente);
    }

    // DELETAR POR ID
    public void excluirProduto(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}