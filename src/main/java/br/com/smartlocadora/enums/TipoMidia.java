package br.com.smartlocadora.enums;

public enum TipoMidia {

    DVD("DVD"),
    BLURAY("BluRay");

    TipoMidia(String label) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }
}
