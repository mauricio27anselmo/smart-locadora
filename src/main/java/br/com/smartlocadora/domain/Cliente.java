package br.com.smartlocadora.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "SMT_CLIENTE")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome", nullable = false)
    @JsonProperty("name")
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @JsonProperty("birthdate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Column(name = "endereco")
    @JsonProperty("address")
    private String endereco;

    @Column(name="cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name="email", nullable = false)
    @JsonProperty("mail")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SMT_CLIENTE_DEPENDENTE",
            joinColumns = {@JoinColumn(name = "id_cliente")},
            inverseJoinColumns = {@JoinColumn(name = "id_dependente")})
    @JsonProperty("dependents")
    private List<Dependente> dependentes;

    public Cliente() {
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
}
