package br.com.smartlocadora.beans;

import br.com.smartlocadora.domain.Dependente;

import javax.validation.constraints.NotEmpty;

public class DependenteDTO implements IDTO<Dependente> {

    private Long code;

    @NotEmpty(message = "{br.com.smartlocadora.dependente.name.notEmpty}")
    private String name;

    public DependenteDTO() {
    }

    public DependenteDTO(Dependente dependente) {
        if (dependente != null) {
            this.code = dependente.getId();
            this.name = dependente.getNome();
        }
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Dependente convertToDomain() {
        Dependente dependente = new Dependente();
        dependente.setId(this.code);
        dependente.setNome(this.name);
        return dependente;
    }
}
