package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueBuilder {

    private String nome;
    private int acuracia;
    private int forca;
    private int pontosDePoder;
    private Categoria categoria;
    private String descricao;
    private Tipo tipo;

    public AtaqueBuilder() {
        this.nome = "Choque do Trovao";
        this.acuracia = 50;
        this.forca = 60;
        this.pontosDePoder = 80;
        this.categoria = Categoria.EFEITO;
        this.descricao = "Da choque nos outros";
        this.tipo = new Tipo("Eletrico");
    }

    public Ataque construir() throws AcuraciaInvalida {
        return new Ataque(forca, acuracia, pontosDePoder, categoria, descricao, nome, tipo);
    }

    public AtaqueBuilder comTipo(Tipo tipoEsperado) {
        tipo = tipoEsperado;
        return this;
    }

    public AtaqueBuilder comAcuracia(int acuracia) {
        this.acuracia = acuracia;
        return this;
    }

    public AtaqueBuilder comCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }
}
