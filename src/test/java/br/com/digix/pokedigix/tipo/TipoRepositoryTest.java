package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // indica conexao com o banco
public class TipoRepositoryTest {

    @Autowired // spring gera as dependencias automaticamente
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_tipo() {
        String nomeEsperado = "Eletrico";
        Tipo tipo = new Tipo(nomeEsperado);

        tipoRepository.save(tipo);

        assertNotNull(tipo.getId());
    }

    @Test
    public void deve_procurar_um_tipo_por_nome() {
        String nome = "Eletrico";
        Tipo tipo = new Tipo(nome);
        tipoRepository.save(tipo);

        Collection<Tipo> tiposRetornados = tipoRepository.findByNomeContaining(nome);

        assertTrue(tiposRetornados.contains(tipo));
    }

    @Test
    public void deve_poder_remover_um_tipo_por_nome() {
        String fada = "Fada";
        Tipo tipoFada = new Tipo(fada);
        tipoRepository.save(tipoFada);
        String fantasma = "Fantasma";
        Tipo tipoFantasma = new Tipo(fantasma);
        tipoRepository.save(tipoFantasma);
        Long quantidadeRemovidaEsperada = 2L;

        Long tiposRetornados = tipoRepository.deleteByNomeContaining("F");

        assertEquals(quantidadeRemovidaEsperada, tiposRetornados);
    }
}
