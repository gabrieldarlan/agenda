package br.com.alura.agenda.model;


import java.io.Serializable;

public class Aluno implements Serializable {

    private int id = 0;
    private String nome;
    private String telefone;
    private String email;
    @SuppressWarnings("unused")
    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Aluno() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }


    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return this.nome + " - " + telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean temIdValido() {
        return this.id > 0;
    }
}
