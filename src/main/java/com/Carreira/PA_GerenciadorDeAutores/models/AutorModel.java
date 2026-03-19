package com.Carreira.PA_GerenciadorDeAutores.models;


import jakarta.persistence.*;

@Entity
@Table(name = "TBL_Aluno")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nome Autor")
    private String nome;
    @Column(name = "Nacionalidade Autor")
    private String nacionalidade;
    @Column(name = "Data Nascimento Autor")
    private String dataNascimento;

    public AutorModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}