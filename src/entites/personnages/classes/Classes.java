package entites.personnages.classes;

import entites.personnages.equipements.Equipements;

import java.util.ArrayList;

public class Classes {
    private final String m_nom;
    private int m_PVMax;
    private ArrayList<Equipements> m_inventaire;

    public Classes(){
        m_nom = "Classe sans nom";
        m_PVMax = 10;
        m_inventaire = new ArrayList<>();
    }
    public Classes(String nom){
        m_nom = nom;
        m_inventaire = new ArrayList<>();
    }
    public Classes(String nom, int pvmax){
        m_nom = nom;
        m_PVMax = pvmax;
        m_inventaire = new ArrayList<>();
    }
    public String getNom(){
        return m_nom;
    }
    public int getPVMax(){
        return m_PVMax;
    }
    public ArrayList<Equipements> getInventaire(){
        return m_inventaire;
    }
    public void setInventaire(Equipements equipement){
        m_inventaire.add(equipement);
    }
    @Override
    public String toString(){
        return m_nom+"(\n PV Max= "+m_PVMax+"\n Inventaire= "+m_inventaire+")";
    }
}
