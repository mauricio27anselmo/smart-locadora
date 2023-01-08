package br.com.smartlocadora.enums;

public enum TipoTelefone {

    COMERCIAL("Comercial"),
    RESIDENCIAL("Residencial"),
    CELULAR("Celular");

    private final String label;

    TipoTelefone(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
