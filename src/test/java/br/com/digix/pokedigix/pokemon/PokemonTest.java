package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonTest {
    @Test
    public void deve_poder_criar_um_pokemon() throws Exception {
        // Arrange
        var nome = "Pikachu";
        var nivel = 10;
        var felicidade = 80;
        var altura = 40;
        var peso = 2;
        var genero = Genero.MASCULINO;
        var numeroPokedex = 26;

        List<Tipo> tipos = new ArrayList<Tipo>();
        tipos.add(new Tipo("Eletrico"));

        List<Ataque> ataques = new ArrayList<Ataque>();
        ataques.add(new AtaqueBuilder().construir());

        // Act
        Pokemon pokemon = new Pokemon(nome, nivel, felicidade, altura, peso, genero, numeroPokedex, tipos, ataques);

        // Assert
        assertEquals(nome, pokemon.getNome());
        assertEquals(nivel, pokemon.getNivel());
        assertEquals(felicidade, pokemon.getFelicidade());
        assertEquals(altura, pokemon.getAltura());
        assertEquals(peso, pokemon.getPeso());
        assertEquals(genero, pokemon.getGenero());
        assertEquals(numeroPokedex, pokemon.getNumeroPokedex());
    }

    @Test
    public void deve_poder_criar_um_pokemon_com_tipo() throws Exception {
        // Arrange
        Tipo tipoCadastrado = new Tipo("Eletrico");
        List<Tipo> tipos = new ArrayList<Tipo>();
        tipos.add(tipoCadastrado);

        // Act
        Pokemon pokemon = new PokemonBuilder().comTipo(tipoCadastrado).construir();

        // Assert
        assertEquals(tipos, pokemon.getTipos());
    }

    @Test
    public void deve_ter_nivel_minimo_um() throws Exception {
        int nivelMinimo = 1;

        Pokemon pokemon = new PokemonBuilder().comNivel(nivelMinimo).construir();

        assertEquals(nivelMinimo, pokemon.getNivel());
    }

    @Test
    public void deve_ter_nivel_maximo_cem() throws Exception {
        int nivelMaximo = 100;

        Pokemon pokemon = new PokemonBuilder().comNivel(nivelMaximo).construir();

        assertEquals(nivelMaximo, pokemon.getNivel());
    }

    @Test
    public void nao_deve_ter_nivel_maior_que_cem() throws Exception {
        int nivel = 101;

        assertThrows(ValorNivelInvalidoException.class, () -> {
            new PokemonBuilder().comNivel(nivel).construir();
        });
    }

    @Test
    public void nao_deve_ter_nivel_menor_que_um() throws Exception {
        int nivel = 0;

        assertThrows(ValorNivelInvalidoException.class, () -> {
            new PokemonBuilder().comNivel(nivel).construir();
        });
    }

    @Test
    public void deve_ter_felicidade_minima_zero() throws Exception {
        int felicidadeMinima = 0;

        Pokemon pokemon = new PokemonBuilder().comFelicidade(felicidadeMinima).construir();

        assertEquals(felicidadeMinima, pokemon.getFelicidade());
    }

    @Test
    public void deve_ter_felicidade_maxima_cem() throws Exception {
        int felicidadeMaxima = 100;

        Pokemon pokemon = new PokemonBuilder().comFelicidade(felicidadeMaxima).construir();

        assertEquals(felicidadeMaxima, pokemon.getFelicidade());
    }

    @Test
    public void nao_deve_ter_felicidade_menor_que_zero() throws Exception {
        int felicidade = -1;

        assertThrows(ValorFelicidadeInvalidoException.class, () -> {
            new PokemonBuilder().comFelicidade(felicidade).construir();
        });
    }

    @Test
    public void nao_deve_ter_felicidade_maior_que_cem() throws Exception {
        int felicidade = 101;

        assertThrows(ValorFelicidadeInvalidoException.class, () -> {
            new PokemonBuilder().comFelicidade(felicidade).construir();
        });
    }
}
