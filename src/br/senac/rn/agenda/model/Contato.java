package br.senac.rn.agenda.model;

import java.util.Objects;

public class Contato {

    private Long id;
    private String nome;
    private String fone;

    public Contato() {}

    public Contato(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) &&
                Objects.equals(fone, contato.fone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
