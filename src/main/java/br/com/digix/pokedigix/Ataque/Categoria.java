package br.com.digix.pokedigix.ataque;

public enum Categoria{
    FISICO("Físico"),
    ESPECIAL("Especial"),
    EFEITO("Efeito");

    private String descricao;

    private Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}