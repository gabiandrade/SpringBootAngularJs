package com.gabrielaandrade.model;

public class Pessoa {

    private Long id;
    private String matricula;
    private String nome;
    private String periodo;

    public Pessoa(){}

    public Pessoa(PessoaForm pessoaForm){
        this.id= pessoaForm.getId();
        this.matricula= pessoaForm.getMatricula();
        this.nome= pessoaForm.getNome();
        this.periodo = pessoaForm.getPeriodo();

    }

    public Pessoa(Long id, String matricula, String nome, String periodo) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.periodo = periodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo =periodo;
    }
}
