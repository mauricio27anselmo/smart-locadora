package br.com.smartlocadora.domain;

import br.com.smartlocadora.beans.ClienteDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SMT_CLIENTE")
public class Cliente{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "endereco")
    private String endereco;

    @Column(name="cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name="email", nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SMT_CLIENTE_DEPENDENTE",
            joinColumns = {@JoinColumn(name = "id_cliente")},
            inverseJoinColumns = {@JoinColumn(name = "id_dependente")})
    private List<Dependente> dependentes;

    public Cliente() {
    }

    public Cliente(ClienteDTO clienteDTO){

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId()) &&
                Objects.equals(getNome(), cliente.getNome()) &&
                Objects.equals(getDataNascimento(), cliente.getDataNascimento()) &&
                Objects.equals(getEndereco(), cliente.getEndereco()) &&
                Objects.equals(getCpf(), cliente.getCpf()) &&
                Objects.equals(getEmail(), cliente.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getDataNascimento(), getEndereco(), getCpf(), getEmail());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco='" + endereco + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
