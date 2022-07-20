package br.com.digix.pokedigix.evolucao;

public enum MeioDeEvolucao{
    NIVEL("Nível"),
    PEDRA("Pedra"),
    FELICIDADE("Felicidade");

    private String descricao;

    private MeioDeEvolucao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}