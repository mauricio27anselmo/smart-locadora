package br.com.smartlocadora.beans;

import br.com.smartlocadora.domain.Cliente;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO implements IDTO<Cliente> {

    private Long code;

    @NotEmpty(message = "{br.com.smartlocadora.cliente.name.notEmpty}")
    private String name;

    @NotEmpty(message = "{br.com.smartlocadora.cliente.birthDate.notEmpty}")
    private String birthDate;

    private String address;

    @NotEmpty(message = "{br.com.smartlocadora.cliente.cpf.notEmpty}")
    @CPF
    private String cpf;

    @NotEmpty(message = "{br.com.smartlocadora.cliente.mail.notEmpty}")
    private String mail;

    private List<DependenteDTO> dependentsList;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        if (cliente != null) {
            this.code = cliente.getId();
            this.name = cliente.getNome();
            this.birthDate = cliente.getDataNascimento() != null ? cliente.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
            this.address = cliente.getEndereco();
            this.cpf = cliente.getCpf();
            this.mail = cliente.getEmail();
            if (cliente.getDependentes() != null && !cliente.getDependentes().isEmpty()) {
                dependentsList = cliente.getDependentes().stream().map(DependenteDTO::new).collect(Collectors.toList());
            }
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<DependenteDTO> getDependentsList() {
        return dependentsList;
    }

    public void setDependentsList(List<DependenteDTO> dependentsList) {
        this.dependentsList = dependentsList;
    }

    @Override
    public Cliente convertToDomain() {
        Cliente cliente = new Cliente();
        cliente.setId(this.code);
        cliente.setNome(this.name);
        cliente.setDataNascimento(LocalDate.parse(this.birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        cliente.setEndereco(this.address);
        cliente.setCpf(this.cpf);
        cliente.setEmail(this.mail);
        if (this.dependentsList != null && !this.dependentsList.isEmpty()) {
            cliente.setDependentes(this.dependentsList.stream().map(DependenteDTO::convertToDomain).collect(Collectors.toList()));
        }
        return cliente;
    }
}
