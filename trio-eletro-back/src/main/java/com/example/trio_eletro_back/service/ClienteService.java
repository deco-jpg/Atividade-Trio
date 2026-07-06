package com.example.trio_eletro_back.service;

import com.example.trio_eletro_back.dto.ClienteRequestDTO;
import com.example.trio_eletro_back.dto.ClienteResponseDTO;
import com.example.trio_eletro_back.entity.ClienteEntity;
import com.example.trio_eletro_back.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // LISTAR TODOS (Devolve apenas nome e email)
    public List<ClienteResponseDTO> listarClientes() {
        return repository.findAll()
                .stream()
                .map(c -> new ClienteResponseDTO(c.getNome(), c.getEmail()))
                .toList();
    }

    // ADICIONAR
    public ClienteEntity adicionarCliente(ClienteRequestDTO dto) {
        // Alterado de dto.email() para dto.getEmail()
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado!");
        }

        ClienteEntity novoCliente = new ClienteEntity();
        // Alterados para usar os métodos Getters tradicionais
        novoCliente.setNome(dto.getNome());
        novoCliente.setCpf(dto.getCpf());
        novoCliente.setDataNascimento(dto.getDataNascimento());
        novoCliente.setEmail(dto.getEmail());

        // Criptografa a senha antes de salvar
        novoCliente.setSenha(passwordEncoder.encode(dto.getSenha()));

        return repository.save(novoCliente);
    }

    // ATUALIZAR POR ID
    public ClienteEntity atualizarCliente(Long id, ClienteEntity novosDados) {
        ClienteEntity clienteExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente com ID " + id + " não encontrado"));

        clienteExistente.setNome(novosDados.getNome());
        clienteExistente.setCpf(novosDados.getCpf());
        clienteExistente.setDataNascimento(novosDados.getDataNascimento());
        clienteExistente.setEmail(novosDados.getEmail());

        // Se uma nova senha for enviada, atualiza criptografando-a
        if (novosDados.getSenha() != null && !novosDados.getSenha().isBlank()) {
            clienteExistente.setSenha(passwordEncoder.encode(novosDados.getSenha()));
        }

        return repository.save(clienteExistente);
    }

    // DELETAR POR ID
    public void excluirCliente(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}