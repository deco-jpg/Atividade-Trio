package com.example.trio_eletro_back.dto;

import jakarta.validation.constraints.NotBlank;

public class ProdutoRequestDTO {

    @NotBlank(message = "Informe o nome do produto!")
    private String nome;

    @NotBlank(message = "Informe a marca do produto!")
    private String marca;

    @NotBlank(message = "Informe o modelo do produto!")
    private String modelo;

    @NotBlank(message = "Informe o preço!") // Usando NotBlank por ser String
    private String preco;

    @NotBlank(message = "Informe a quantidade em estoque!") // Usando NotBlank por ser String
    private String quantidadeEstoque;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, String marca, String modelo, String preco, String quantidadeEstoque) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(String quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}