package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.TipoResponseDTO;

public class AtaqueResponseDTO {
    private Long id;
    private String nome;
    private Categoria categoria;
    private String descricao;
    private int forca;
    private int acuracia;
    private int pontosDePoder;
    private TipoResponseDTO tipo;

    public AtaqueResponseDTO(Long id, String nome, int acuracia, Categoria categoria, String descricao,
            int pontosDePoder, int forca, TipoResponseDTO tipo) {
        this.id = id;
        this.nome = nome;
        this.acuracia = acuracia;
        this.categoria = categoria;
        this.descricao = descricao;
        this.pontosDePoder = pontosDePoder;
        this.forca = forca;
        this.tipo = tipo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoResponseDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoResponseDTO tipo) {
        this.tipo = tipo;
    }

}
