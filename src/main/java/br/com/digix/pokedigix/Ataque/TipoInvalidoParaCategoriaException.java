package br.com.digix.pokedigix.ataque;

public class TipoInvalidoParaCategoriaException extends Exception{
   
    public TipoInvalidoParaCategoriaException(Categoria categoria) {
        super("A categoria " + categoria.name() + " deve ter algum tipo.");
    }
}
