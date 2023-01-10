package br.com.smartlocadora.enums;

public enum ClassificacaoIndicativa {

    LIVRE("Livre"),
    CLASSIFICACAO_10_ANOS("10 Anos"),
    CLASSIFICACAO_14_ANOS("14 Anos"),
    CLASSIFICACAO_16_ANOS("16 Anos"),
    CLASSIFICACAO_18_ANOS("18 Anos");

    ClassificacaoIndicativa(String label) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }
}
