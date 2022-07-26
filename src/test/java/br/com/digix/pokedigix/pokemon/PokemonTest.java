package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.ataque.AcuraciaInvalida;
import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonTest {
    @Test
    public void deve_poder_criar_um_pokemon() throws AcuraciaInvalida {
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
    public void deve_poder_criar_um_pokemon_com_tipo() throws AcuraciaInvalida {
        //Arrange
        Tipo tipoCadastrado = new Tipo("Eletrico");
        List<Tipo> tipos = new ArrayList<Tipo>();
        tipos.add(tipoCadastrado);
        
        // Act
        Pokemon pokemon = new PokemonBuilder().comTipo(tipoCadastrado).construir();

        // Assert
        assertEquals(tipos, pokemon.getTipos());
    }
}
