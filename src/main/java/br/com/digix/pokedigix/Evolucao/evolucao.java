package br.com.digix.pokedigix.evolucao;

import br.com.digix.pokedigix.pokemon.Pokemon;

public class Evolucao {
    private Pokemon evolucao;
    private String meioDeEvolucao;

    public Evolucao(Pokemon evolucao, String meioDeEvolucao) {
        this.evolucao = evolucao;
        this.meioDeEvolucao = meioDeEvolucao;
    }

    public Pokemon getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(Pokemon evolucao) {
        this.evolucao = evolucao;
    }

    public String getMeioDeEvolucao() {
        return meioDeEvolucao;
    }

    public void setMeioDeEvolucao(String meioDeEvolucao) {
        this.meioDeEvolucao = meioDeEvolucao;
    }
}
