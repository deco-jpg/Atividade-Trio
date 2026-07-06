package com.example.trio_eletro_back.repository;

import com.example.trio_eletro_back.entity.FuncionarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {

    // Busca um funcionário pelo e-mail
    Optional<FuncionarioEntity> findByEmail(String email);

    // Deleta um funcionário pelo e-mail (precisa do @Transactional por ser uma operação de escrita/exclusão customizada)
    @Transactional
    void deleteByEmail(String email);
}