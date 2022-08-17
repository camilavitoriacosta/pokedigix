package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.tipo.Tipo;

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

    @ManyToOne(cascade = CascadeType.PERSIST) // salva o tipo caso ele nao esteja no banco
    private Tipo tipo;

    @ManyToMany(mappedBy = "ataques")
    private Collection<Pokemon> pokemons;

    protected Ataque() {
    }

    public Ataque(int forca, int acuracia, int pontosDePoder, Categoria categoria, String descricao,
            String nome, Tipo tipo) throws Exception {
        setCategoria(categoria);
        setForca(forca);
        setAcuracia(acuracia);
        setPontosDePoder(pontosDePoder);
        setDescricao(descricao);
        setNome(nome);
        setTipo(tipo);
    }

    public Ataque(int acuracia, int pontosDePoder, String descricao, String nome) throws Exception {
        setCategoria(Categoria.EFEITO);
        setAcuracia(acuracia);
        setPontosDePoder(pontosDePoder);
        setDescricao(descricao);
        setNome(nome);
    }

    private void validarTipo(Tipo tipo) throws TipoInvalidoParaCategoriaException {
        if (!(categoria.equals(Categoria.EFEITO)) && tipo == null) {
            throw new TipoInvalidoParaCategoriaException(categoria);
        }
    }

    private void validarForca(int forca) throws ForcaInvalidaParaCategoriaException {
        if (!(categoria.equals(Categoria.EFEITO)) && forca <= 0) {
            throw new ForcaInvalidaParaCategoriaException(categoria);
        }
    }

    public Tipo getTipo() {
        return tipo;
    }

    private void setTipo(Tipo tipo) throws TipoInvalidoParaCategoriaException {
        validarTipo(tipo);
        this.tipo = tipo;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) throws ForcaInvalidaParaCategoriaException {
        validarForca(forca);
        this.forca = forca;
    }

    public int getAcuracia() {
        return acuracia;
    }

    public void setAcuracia(int acuracia) throws AcuraciaInvalidaException {
        if (acuracia >= 0 && acuracia <= 100) {
            this.acuracia = acuracia;
        } else {
            throw new AcuraciaInvalidaException();
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

    public Collection<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Collection<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

}
