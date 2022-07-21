package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TreinadorRepositoryTest {
    @Autowired // spring gera as dependencias automaticamente
    private TreinadorRepository treinadorRepository;

    @Test
    public void deve_salvar_um_treinador(){
        Long idEsperado = 3L;
        var nome = "Dawn";
        var dinheiro = 100;
        var nivel = 2;
        var treinador = new Treinador(nome, dinheiro, nivel);

        treinadorRepository.save(treinador);

        assertEquals(idEsperado, treinador.getId());
    }
}
