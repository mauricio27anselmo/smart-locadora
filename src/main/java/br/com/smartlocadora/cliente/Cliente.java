package br.com.smartlocadora.cliente;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String endereco;

    @Column(nullable = false)
    private String cpf;

    private String email;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false)
    private String nome;

    public Cliente() {
    }

    public Cliente(Long id, String endereco, String cpf, String email, Date dataNascimento, String nome) {
        this.id = id;
        this.endereco = endereco;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getId().equals(cliente.getId()) &&
                Objects.equals(getEndereco(), cliente.getEndereco()) &&
                getCpf().equals(cliente.getCpf()) &&
                Objects.equals(getEmail(), cliente.getEmail()) &&
                getDataNascimento().equals(cliente.getDataNascimento()) &&
                getNome().equals(cliente.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEndereco(), getCpf(), getEmail(), getDataNascimento(), getNome());
    }
}
