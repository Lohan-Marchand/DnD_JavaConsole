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

    @Override
    public String toString(){
        return m_nom + " :\n" + "Portée : " + m_portee + "\n Dé " + m_de + "\n Nombre de dé : " + m_nbDe + "\n";
    }

}
