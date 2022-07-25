package br.com.digix.pokedigix.pokemon;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.digix.pokedigix.tipo.Tipo;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 15)
    private String nome;

    @Column(nullable = false)
    private int nivel;

    @Column(nullable = false)
    private int felicidade;

    @Column(nullable = false)
    private double altura;

    @Column(nullable = false)
    private double peso;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Genero genero;

    @Column(nullable = false)
    private int numeroPokedex;

    @ManyToMany
    private Collection<Tipo> tipos;

    public Pokemon(String nome, int nivel, int felicidade, double altura, double peso, Genero genero,
            int numeroPokedex, Collection<Tipo> tipos) {
        this.nome = nome;
        this.nivel = nivel;
        this.felicidade = felicidade;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.numeroPokedex = numeroPokedex;
        this.tipos = tipos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getFelicidade() {
        return felicidade;
    }

    public void setFelicidade(int felicidade) {
        this.felicidade = felicidade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getNumeroPokedex() {
        return numeroPokedex;
    }

    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Collection<Tipo> getTipos() {
        return tipos;
    }
}
