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
        this.descricao = "Da choque nos outros";
        this.tipo = new Tipo("Eletrico");
        this.categoria = Categoria.FISICO;
    }

    public Ataque construir() throws Exception {
        if (this.categoria.equals(Categoria.EFEITO)){
            return new Ataque(acuracia, pontosDePoder, descricao, nome);
        }
        else{
            return new Ataque(forca, acuracia, pontosDePoder, categoria, descricao, nome, tipo);
        }
    }

    public AtaqueBuilder comTipo(Tipo tipo) {
        this.tipo = tipo;
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

    public AtaqueBuilder comCategoriaEfeito() {
        this.categoria = Categoria.EFEITO;
        return this;
    }

    public AtaqueBuilder comForca(int forca) {
        this.forca = forca;
        return this;
    }    
}
