package br.com.digix.pokedigix.evolucao;

import br.com.digix.pokedigix.pokemon.Pokemon;

public class Evolucao {
    private Pokemon evolucao;
    private MeioDeEvolucao meioDeEvolucao;

    public Evolucao(Pokemon evolucao, MeioDeEvolucao meioDeEvolucao) {
        this.evolucao = evolucao;
        this.meioDeEvolucao = meioDeEvolucao;
    }

    public Pokemon getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(Pokemon evolucao) {
        this.evolucao = evolucao;
    }

    public MeioDeEvolucao getMeioDeEvolucao() {
        return meioDeEvolucao;
    }

    public void setMeioDeEvolucao(MeioDeEvolucao meioDeEvolucao) {
        this.meioDeEvolucao = meioDeEvolucao;
    }
}
