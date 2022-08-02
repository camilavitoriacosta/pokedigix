package br.com.digix.pokedigix.pokemon;

public class ValorFelicidadeInvalidoException extends Exception{
    public ValorFelicidadeInvalidoException(){
        super("A felicidade deve ser entre 0 e 100");
    }
}
