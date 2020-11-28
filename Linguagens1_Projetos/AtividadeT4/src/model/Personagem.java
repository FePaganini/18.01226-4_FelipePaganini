package model;

public class Personagem {
    private String nome, raça, profissão;
    private int mana, atk, atkMag, def, defMag, velocidade, destreza, experiencia, nivel;

    public Personagem(String nome, String raça, String profissão, int mana, int atk,
                      int atkMag, int def, int defMag, int velocidade, int destreza, int experiencia, int nivel) {
        this.nome = nome;
        this.raça = raça;
        this.profissão = profissão;
        this.mana = mana;
        this.atk = atk;
        this.atkMag = atkMag;
        this.def = def;
        this.defMag = defMag;
        this.velocidade = velocidade;
        this.destreza = destreza;
        this.experiencia = experiencia;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public String getRaça() {
        return raça;
    }

    public String getProfissão() {
        return profissão;
    }

    public int getMana() {
        return mana;
    }

    public int getAtk() {
        return atk;
    }

    public int getAtkMag() {
        return atkMag;
    }

    public int getDef() {
        return def;
    }

    public int getDefMag() {
        return defMag;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", raça='" + raça + '\'' +
                ", profissão='" + profissão + '\'' +
                ", mana=" + mana +
                ", atk=" + atk +
                ", atkMag=" + atkMag +
                ", def=" + def +
                ", defMag=" + defMag +
                ", velocidade=" + velocidade +
                ", destreza=" + destreza +
                ", experiencia=" + experiencia +
                ", nivel=" + nivel +
                '}';
    }
}
