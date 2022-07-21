package br.com.digix.pokedigix.treinador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Treinador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 15)
    private String nome;
    
    @Column(nullable = false)
    private int dinheiro;
    
    @Column(nullable = false)
    private int nivel;
    
    public Treinador(String nome, int dinheiro, int nivel) {
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Long getId() {
        return this.id;
    }
}
