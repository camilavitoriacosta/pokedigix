package br.com.digix.pokedigix.pokemon;

public class ValorNivelInvalidoException extends Exception{
    public ValorNivelInvalidoException(){
        super("O nível deve estar entre 1 e 100, considerando os limites.");
    }
}
