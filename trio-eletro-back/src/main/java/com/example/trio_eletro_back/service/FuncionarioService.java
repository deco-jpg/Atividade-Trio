package com.example.trio_eletro_back.service;

import com.example.trio_eletro_back.dto.FuncionarioRequestDTO;
import com.example.trio_eletro_back.dto.FuncionarioResponseDTO;
import com.example.trio_eletro_back.entity.FuncionarioEntity;
import com.example.trio_eletro_back.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    // LISTAR TODOS
    public List<FuncionarioResponseDTO> listarFuncionario() {
        return repository
                .findAll()
                .stream()
                .map(f -> new FuncionarioResponseDTO(
                        f.getNome(),
                        f.getEmail(),
                        f.getTelefone(),
                        f.getSetor()
                ))
                .toList();
    }

    // ADICIONAR
    public FuncionarioEntity adicionarFuncionario(FuncionarioRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já em uso!");
        }

        FuncionarioEntity novoFuncionario = new FuncionarioEntity();
        novoFuncionario.setNome(dto.getNome());
        novoFuncionario.setCpf(dto.getCpf());
        novoFuncionario.setEmail(dto.getEmail());
        novoFuncionario.setTelefone(dto.getTelefone());
        novoFuncionario.setSetor(dto.getSetor());
        novoFuncionario.setSalario(dto.getSalario());

        return repository.save(novoFuncionario);
    }

    // ATUALIZAR POR ID
    public FuncionarioEntity atualizarFuncionario(Long id, FuncionarioEntity novosDados) {
        // Busca o funcionário existente pelo ID
        FuncionarioEntity funcionarioExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário com ID " + id + " não encontrado"));

        // Atualiza os dados do funcionário do banco com os novos dados recebidos
        funcionarioExistente.setNome(novosDados.getNome());
        funcionarioExistente.setCpf(novosDados.getCpf());
        funcionarioExistente.setEmail(novosDados.getEmail());
        funcionarioExistente.setTelefone(novosDados.getTelefone());
        funcionarioExistente.setSetor(novosDados.getSetor());
        funcionarioExistente.setSalario(novosDados.getSalario());

        // Salva as alterações
        return repository.save(funcionarioExistente);
    }

    // DELETAR POR ID
    public void excluirFuncionario(Long id) {
        // Verifica se o ID realmente existe antes de tentar deletar
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}