package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PokemonTest {
    @Test
    public void deve_poder_criar_um_pokemon() {
        // Arrange
        var nome = "Pikachu";
        var nivel = 10;
        var felicidade = 80;
        var altura = 40;
        var peso = 2;
        var genero = 'M';
        var numeroPokedex = 26;

        // Act
        Pokemon pokemon = new Pokemon(nome, nivel, felicidade, altura, peso, genero, numeroPokedex);

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
    public void deve_poder_criar_um_pokemon_sem_genero() {
        // Arrange
        var nome = "Pikachu";
        var nivel = 10;
        var felicidade = 80;
        var altura = 40;
        var peso = 2;
        var numeroPokedex = 26;

        // Act
        Pokemon pokemon = new Pokemon(nome, nivel, felicidade, altura, peso, numeroPokedex);

        // Assert
        assertEquals(nome, pokemon.getNome());
        assertEquals(nivel, pokemon.getNivel());
        assertEquals(felicidade, pokemon.getFelicidade());
        assertEquals(altura, pokemon.getAltura());
        assertEquals(peso, pokemon.getPeso());
        assertEquals(numeroPokedex, pokemon.getNumeroPokedex());
    }
}
