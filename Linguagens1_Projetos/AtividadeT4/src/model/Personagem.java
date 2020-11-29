package model;

/**
 * Classe concreta que representa um Personagem do RPG
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 29/11/2020
 * @version 1.0
 */
public class Personagem {
    private String nome, raca, profissao;
    private int id, mana, atk, atkMag, def, defMag, velocidade, destreza, experiencia, nivel;

    /**
     * @param id Construtor de um personagem a partir de um Id e ele será utilizado para excluir um personagem
     *           do DB
     */
    public Personagem(int id){
        this(id,null,null,null,0,0,0,0,
                0,0,0,0,0);
    }

    /**
     * @param id Número inteiro que é a Id do personagem
     * @param nome String que é o Nome do personagem
     * @param raca String que é a Raça do personagem
     * @param profissao String que é a Profissão do personagem
     * @param mana Número inteiro que é a Mana do personagem
     * @param atk Número inteiro que é o Ataque do personagem
     * @param atkMag Número inteiro que é o Ataque Mágico do personagem
     * @param def Número inteiro que é a Defesa do personagem
     * @param defMag Número inteiro que é a Defesa Mágica do personagem
     * @param velocidade Número inteiro que é a Velocidade do personagem
     * @param destreza Número inteiro que é a Destreza do personagem
     * @param experiencia Número inteiro que é a Experiência do personagem
     * @param nivel Número inteiro que é o Nível do personagem
     */
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

    /**
     * @return retorna um número inteiro que é o Id do personagem
     */
    public int getId(){
        return id;
    }

    /**
     * @return retorna uma String que é o Nome do personagem
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return retorna uma String que é a Raça do personagem
     */
    public String getRaca() {
        return raca;
    }

    /**
     * @return retorna uma String que é a Profissão do personagem
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @return retorna um número inteiro que é a Mana do personagem
     */
    public int getMana() {
        return mana;
    }

    /**
     * @return retorna um número inteiro que é o Ataque do personagem
     */
    public int getAtk() {
        return atk;
    }

    /**
     * @return retorna um número inteiro que é o Ataque Mágico do personagem
     */
    public int getAtkMag() {
        return atkMag;
    }

    /**
     * @return retorna um número inteiro que é a Defesa do personagem
     */
    public int getDef() {
        return def;
    }

    /**
     * @return retorna um número inteiro que é a Defesa Mágica do personagem
     */
    public int getDefMag() {
        return defMag;
    }

    /**
     * @return retorna um número inteiro que é a Velocidade do personagem
     */
    public int getVelocidade() {
        return velocidade;
    }

    /**
     * @return retorna um número inteiro que é a Destreza do personagem
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * @return retorna um número inteiro que é a Experiência do personagem
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * @return retorna um número inteiro que é o Nível do personagem
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @return retorna uma String com os parâmetros do personagem
     */
    @Override
    public String toString() {
        return  "Id = " + id +
                ",Nome = " + nome +
                ", Raça = " + raca +
                ", Profissão = " + profissao +
                ", Mana = " + mana +
                ", Ataque = " + atk +
                ", Ataque Mágico = " + atkMag +
                ", Defesa = " + def +
                ", Defesa Mágica = " + defMag +
                ", \nVelocidade = " + velocidade +
                ", Destreza = " + destreza +
                ", Experiência = " + experiencia +
                ", Nível = " + nivel + "\n";
    }
}
