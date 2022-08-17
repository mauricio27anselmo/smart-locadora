package br.com.smartlocadora.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "SMT_DEPENDENTE")
public class Dependente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dependente")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public Dependente() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dependente)) return false;
        Dependente that = (Dependente) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }

    @Override
    public String toString() {
        return "Dependente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
