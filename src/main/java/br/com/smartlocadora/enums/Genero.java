package br.com.smartlocadora.enums;

public enum Genero {

    ACAO("Ação"),
    COMEDIA("Comédia"),
    ROMANCE("Romance"),
    TERROR("Terror"),
    SUSPENSE("Suspense"),
    ARTES_MARCIAIS("Artes Marciais"),
    ANIMACAO("Animação"),
    DRAMA("Drama"),
    INFANTIL("Infantil"),
    AVENTURA("Aventura");

    Genero(String label) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }
}
