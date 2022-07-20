package br.com.digix.pokedigix.ataque;

public class Ataque {
    private int forca;
    private int acuracia;
    private int pontosDePoder;
    private String categoria;
    private Categoria descricao;
    private String nome;

    public Ataque(int forca, int acuracia, int pontosDePoder, String categoria, Categoria descricao, String nome) {
        this.forca = forca;
        this.acuracia = acuracia;
        this.pontosDePoder = pontosDePoder;
        this.categoria = categoria;
        this.descricao = descricao;
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getAcuracia() {
        return acuracia;
    }

    public void setAcuracia(int acuracia) {
        this.acuracia = acuracia;
    }

    public int getPontosDePoder() {
        return pontosDePoder;
    }

    public void setPontosDePoder(int pontosDePoder) {
        this.pontosDePoder = pontosDePoder;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Categoria getDescricao() {
        return descricao;
    }

    public void setDescricao(Categoria descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
