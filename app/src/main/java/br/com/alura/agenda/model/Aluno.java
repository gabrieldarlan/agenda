package br.com.alura.agenda.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Aluno implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String nome;
    private String telefoneFixo;
    private String telefoneCelular;
    private String email;
    private Calendar momentoDeCadastro = Calendar.getInstance();


    @Ignore
    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefoneFixo = telefone;
        this.email = email;
    }

    public Aluno() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public String getEmail() {
        return email;
    }


    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return this.nome + " - " + telefoneFixo;
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

    public Calendar getMomentoDeCadastro() {
        return momentoDeCadastro;
    }

    public void setMomentoDeCadastro(Calendar momentoDeCadastro) {
        this.momentoDeCadastro = momentoDeCadastro;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
}
