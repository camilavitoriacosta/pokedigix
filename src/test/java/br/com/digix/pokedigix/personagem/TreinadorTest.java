package br.com.digix.pokedigix.personagem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.pokemon.PokemonBuilder;

public class TreinadorTest {

    @Test
    public void deve_comecar_com_um_pokemon() throws Exception {
        var primeiroPokemon = new PokemonBuilder().construir();
        int quantidadeDePokemonsEsperado = 1;

        Treinador treinador = new TreinadorBuilder().comPokemonInicial(primeiroPokemon).construir();

        assertTrue(treinador.getPokemons().contains(primeiroPokemon));
        assertEquals(quantidadeDePokemonsEsperado, treinador.getQuantidadePokemon());
    }

    @Test
    public void deve_poder_capturar_um_pokemon() throws Exception {
        var pokemonACapturar = new PokemonBuilder().construir();
        int quantidadeDePokemonsEsperado = 2;
        Treinador treinador = new TreinadorBuilder().construir();

        treinador.capturar(pokemonACapturar);

        assertTrue(treinador.getPokemons().contains(pokemonACapturar));
        assertEquals(quantidadeDePokemonsEsperado, treinador.getQuantidadePokemon());
    }

    @Test
    public void nao_deve_possuir_mais_que_seis_pokemons() throws Exception {
        Treinador treinador = new TreinadorBuilder().construir();
        for (int i = 0; i < 5; i++) {
            treinador.capturar(new PokemonBuilder().construir());
        }

        assertThrows(LimiteDePokemonException.class, () -> {
            treinador.capturar(new PokemonBuilder().construir());
        });
    }

    @Test
    public void deve_ter_ate_seis_pokemons() throws Exception {
        Treinador treinador = new TreinadorBuilder().construir();
        int quantidadeDePokemonsEsperado = 6;

        for (int i = 0; i < 5; i++) {
            treinador.capturar(new PokemonBuilder().construir());
        }

        assertEquals(quantidadeDePokemonsEsperado, treinador.getQuantidadePokemon());
    }

    @Test
    public void deve_adicionar_um_treinador() throws Exception {
        var nome = "Ash";
        var endereco = new EnderecoBuilder().construir();
        var quantidadePokemonEsperado = 1;
        var primeiroPokemon = new PokemonBuilder().construir();

        Treinador treinador = new Treinador(nome, endereco, primeiroPokemon);

        assertEquals(nome, treinador.getNome());
        assertEquals(quantidadePokemonEsperado, treinador.getQuantidadePokemon());
        assertEquals(endereco, treinador.getEndereco());
    }
}
