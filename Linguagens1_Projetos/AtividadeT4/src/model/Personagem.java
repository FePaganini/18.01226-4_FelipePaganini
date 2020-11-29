package model;

public class Personagem {
    private String nome, raca, profissao;
    private int id, mana, atk, atkMag, def, defMag, velocidade, destreza, experiencia, nivel;
    
    public Personagem(int id){
        this(id,null,null,null,0,0,0,0,
                0,0,0,0,0);
    }

    public Personagem(int id, String nome, String raca, String profissao,int mana, int atk,
                      int atkMag, int def, int defMag, int velocidade, int destreza, int experiencia, int nivel) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.profissao = profissao;
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

    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public String getProfissao() {
        return profissao;
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
        return  "Nome='" + nome + '\'' +
                ", Raça ='" + raca + '\'' +
                ", Profissão ='" + profissao + '\'' +
                ", Mana =" + mana +
                ", Ataque =" + atk +
                ", Ataque Mágico =" + atkMag +
                ", Defesa =" + def +
                ", Defesa Mágica =" + defMag +
                ", Velocidade=" + velocidade +
                ", Destreza=" + destreza +
                ", Experiência=" + experiencia +
                ", Nível=" + nivel + "\n";
    }
}
