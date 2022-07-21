package br.com.digix.pokedigix.tipo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TipoRepository extends CrudRepository<Tipo, Long> {
    // @Query("select t from tipo t where nome = ?1")
    // Tipo findByName(String nome);
}
