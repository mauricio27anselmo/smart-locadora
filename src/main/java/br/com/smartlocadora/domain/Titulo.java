package br.com.smartlocadora.domain;

import br.com.smartlocadora.enums.ClassificacaoIndicativa;
import br.com.smartlocadora.enums.Genero;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "SMT_TITULO")
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_titulo")
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    @JsonProperty("name")
    private String nome;

    @Column(name = "diretor", length = 50, nullable = false)
    @JsonProperty("director")
    private String diretor;

    @Column(name = "classificacao_indicativa", nullable = false)
    @JsonProperty("parentalRating")
    private ClassificacaoIndicativa classificacaoIndicativa;

    @Column(name = "ano", nullable = false)
    @JsonProperty("year")
    private Long ano;

    @Column(name = "genero", length= 20, nullable = false)
    @JsonProperty("genre")
    private Genero genero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ator_id", referencedColumnName = "id_ator", nullable = false)
    @JsonProperty("actor")
    private Ator ator;

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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public ClassificacaoIndicativa getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }
}
