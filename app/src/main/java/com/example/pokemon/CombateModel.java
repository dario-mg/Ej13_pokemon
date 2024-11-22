package com.example.pokemon;

public class CombateModel {
    public static class EnviarAlCombate {

        private Pokemon pokemon1, pokemon2;
        private int vidaTotalAliado, vidaTotalEnemigo;

        public EnviarAlCombate(Pokemon pokemon1, Pokemon pokemon2) {
            this.pokemon1 = pokemon1;
            this.pokemon2 = pokemon2;

        }
    }

    private int empieza = 0;

    interface Callback {
        void cuandoEsteCombate(Pokemon uno, Pokemon dos);

    }


    public void combate(EnviarAlCombate combatientes, Callback callback) {

        if (empieza == 0) {
            empieza = (int) ((Math.random() * 2) + 1);
        }

        if (combatientes.pokemon1.getHp() > 0 && combatientes.pokemon2.getHp() > 0) {
            if (empieza == 1) {
                combatientes.pokemon2.setHp(combatientes.pokemon2.getHp() - pokemonMaquina(combatientes.pokemon2, combatientes.pokemon1, empieza));
                combatientes.pokemon1.setHp(combatientes.pokemon1.getHp() - pokemonMaquina(combatientes.pokemon2, combatientes.pokemon1, empieza));
                empieza = 2;
            } else {
                combatientes.pokemon1.setHp(combatientes.pokemon1.getHp() - pokemonMaquina(combatientes.pokemon2, combatientes.pokemon1, empieza));
                combatientes.pokemon2.setHp(combatientes.pokemon2.getHp() - pokemonMaquina(combatientes.pokemon2, combatientes.pokemon1, empieza));
                empieza = 1;
            }
        }

        callback.cuandoEsteCombate(combatientes.pokemon1, combatientes.pokemon2);

    }

    public int pokemonMaquina(Pokemon defensor, Pokemon atacador, int atacante) {
        int danoAtaque = 0;
        int ataque = (int) (Math.random() * 10) + 1;

        if (ataque == 1 || ataque == 2) {
            danoAtaque = atacador.getAtaqueEspecial();
        } else if (ataque >= 3 && ataque <= 9) {
            danoAtaque = atacador.getAtaque();
        }

        int defensa = (int) (Math.random() * 10) + 1;

        if (danoAtaque != 0) {
            if (defensa == 1 || defensa == 2) {
                danoAtaque -= defensor.getDefensaEspecial();
            } else if (defensa >= 3 && defensa <= 9) {
                danoAtaque -= defensor.getDefensa();
            } else {
                danoAtaque = danoAtaque / 2;
            }
        }

        if (danoAtaque<0){
            danoAtaque = 0;
        }

        return danoAtaque;
    }
}
