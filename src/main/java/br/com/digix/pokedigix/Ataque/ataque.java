package br.com.digix.pokedigix.ataque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ataque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private int forca;

    @Column(nullable = false)
    private int acuracia;

    @Column(nullable = false)
    private int pontosDePoder;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Categoria categoria;

    @Column(nullable = false, length = 40)
    private String descricao;

    @Column(nullable = false, length = 20)
    private String nome;

    public Ataque(int forca, int acuracia, int pontosDePoder, Categoria categoria, String descricao,
            String nome) throws AcuraciaInvalida {
        setForca(forca);
        setAcuracia(acuracia);
        setPontosDePoder(pontosDePoder);
        setDescricao(descricao);
        setNome(nome);
        setCategoria(categoria);
    }

    public Ataque(int acuracia, int pontosDePoder, Categoria categoria, String descricao,
            String nome) throws AcuraciaInvalida {
        setAcuracia(acuracia);
        setPontosDePoder(pontosDePoder);
        setDescricao(descricao);
        setNome(nome);
        setCategoria(categoria);
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

    public void setAcuracia(int acuracia) throws AcuraciaInvalida {
        if ( acuracia > 0 && acuracia < 100){
            this.acuracia = acuracia;
        }
        else{
            throw new AcuraciaInvalida();
        }
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
