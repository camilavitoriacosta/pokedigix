package br.com.digix.pokedigix.personagem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.pokemon.PokemonBuilder;

public class TreinadorTest {

    @Test
    public void deve_adiciaonar_um_treinador() throws Exception {
        var nome = "Ash";
        var endereco = new EnderecoBuilder().construir();
        var quantidadePokemonEsperado = 1;
        var primeiroPokemon = new PokemonBuilder().construir();

        Treinador treinador = new Treinador(nome, endereco, primeiroPokemon);

        assertEquals(nome, treinador.getNome());
        assertEquals(quantidadePokemonEsperado, treinador.getQuantidadePokemon());
        assertEquals(endereco, treinador.getEndereco());
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
}
