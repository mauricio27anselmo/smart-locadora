package br.com.smartlocadora.enums;

public enum StatusCliente {

    ATIVO("Ativo"),
    INADIMPLENTE("Inadimplente");

    StatusCliente(String label) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }
}
