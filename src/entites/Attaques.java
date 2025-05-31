package entites;

import dice.*;
public class Attaques {

    private String m_nom;
    private int m_portee;
    private Dice m_de;
    private int m_nbDe;

    public Attaques(){
        this.m_nom = "Attaque";
        this.m_portee = 1;
        this.m_de = new Dice();
        this.m_nbDe = 1;
    }

    public Attaques(String nom){
        this.m_nom = nom;
        this.m_portee = 1;
        this.m_de = new Dice();
        this.m_nbDe = 1;
    }

    public Attaques(String nom, int portee){
        this.m_nom = nom;
        this.m_portee = portee;
        this.m_de = new Dice();
        this.m_nbDe = 1;
    }

    public Attaques(String nom, int portee, Dice de){
        this.m_nom = nom;
        this.m_portee = portee;
        this.m_de = de;
        this.m_nbDe = 1;
    }

    public Attaques(String nom, int portee, Dice de, int nbDe){
        this.m_nom = nom;
        this.m_portee = portee;
        this.m_de = de;
        this.m_nbDe = nbDe;
    }
    public int calculerDegats(int bonusJetAttaque, int bonusDegats){
        Dice de = new Dice(m_de.getVal());
        return de.rollDice(m_nbDe)+bonusDegats;

    }
    public String getNom(){
        return m_nom;
    }
    public int getPortee(){
        return m_portee;
    }
    public Dice getDe(){
        return m_de;
    }
    public int getNbDe(){
        return m_nbDe;
    }
    public void setNom(String nom){
        this.m_nom = nom;
    }
    public void setPortee(int portee){
        this.m_portee = portee;
    }
    public void setDe(Dice de){
        this.m_de = de;
    }
    public void setNbDe(int nbDe){
        this.m_nbDe = nbDe;
    }

    @Override
    public String toString(){
        return m_nom + " [Portée : " + m_portee + "| " + m_de.getVal() + "d" + m_nbDe + " de dégâts]";
    }

}
