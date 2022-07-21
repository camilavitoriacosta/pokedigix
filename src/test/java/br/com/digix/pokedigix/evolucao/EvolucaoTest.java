// package br.com.digix.pokedigix.evolucao;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

// import br.com.digix.pokedigix.pokemon.Pokemon;

// public class EvolucaoTest {
    
//     @Test
//     public void deve_poder_criar_um_evolucao(){
//         // Arrange
//         var nome = "Pikachu";
//         var nivel = 10;
//         var felicidade = 80;
//         var altura = 40;
//         var peso = 2;
//         var genero = 'M';
//         var numeroPokedex = 26;
//         Pokemon pokemon = new Pokemon(nome, nivel, felicidade, altura, peso, genero, numeroPokedex);
//         MeioDeEvolucao meioDeEvolucao = MeioDeEvolucao.NIVEL;
        
//         //Act
//         Evolucao evolucao = new Evolucao(pokemon, meioDeEvolucao);

//         //Assert
//         assertEquals(meioDeEvolucao, evolucao.getMeioDeEvolucao());
//     }
// }
