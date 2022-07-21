package br.com.digix.pokedigix.ataque;

public class AcuraciaInvalida extends Exception{
    @Override
    public String getMessage() {
        return "O valor da acuracia deve estar entre 0 e 100.";
    } 
}
