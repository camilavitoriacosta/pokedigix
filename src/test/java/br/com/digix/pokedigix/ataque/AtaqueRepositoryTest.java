package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // indica conexao com o banco
public class AtaqueRepositoryTest {
    @Autowired // spring gera as dependencias automaticamente
    private AtaqueRepository ataqueRepository;

    @Test
    public void deve_salvar_um_ataque() throws AcuraciaInvalida {
        String nomeEsperado = "Choque do Trovao";
        Long idEsperado = 1L;
        Ataque ataque = new Ataque(40, 40, 80,
                Categoria.ESPECIAL, "Da choque nos outros",
                nomeEsperado);

        ataqueRepository.save(ataque);

        assertEquals(idEsperado, ataque.getId());
    }
}
