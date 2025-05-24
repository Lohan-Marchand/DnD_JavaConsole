package entites.personnages.classes;

import entites.personnages.equipements.Equipements;
import entites.personnages.sorts.Sorts;

import java.util.ArrayList;

public class Classes {
    private final String m_nom;
    private int m_PVMax;
    private ArrayList<Equipements> m_inventaire;
    private ArrayList<Sorts> m_sortsConnus;

    public Classes(){
        m_nom = "Classe sans nom";
        m_PVMax = 10;
        m_inventaire = new ArrayList<>();
        m_sortsConnus = new ArrayList<>();
    }
    public Classes(String nom){
        m_nom = nom;
        m_PVMax = 10;
        m_inventaire = new ArrayList<>();
        m_sortsConnus = new ArrayList<>();
    }
    public Classes(String nom, int pvmax){
        m_nom = nom;
        m_PVMax = pvmax;
        m_inventaire = new ArrayList<>();
        m_sortsConnus = new ArrayList<>();
    }

    public String getStats(){
        String stats = m_nom+"(PV Max= "+m_PVMax+" Inventaire= [";
        for(Equipements e : m_inventaire){
            stats += e.getNom()+",";
        }
        stats=stats.substring(0,stats.length()-1);
        stats+="])";
        return stats;
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
    public ArrayList<Sorts> getSortsConnus() {
        return m_sortsConnus;
    }
    public void setInventaire(Equipements equipement){
        m_inventaire.add(equipement);
    }
    public void setSortsConnus(Sorts sort) {
        m_sortsConnus.add(sort);
    }
    @Override
    public String toString(){
        return m_nom+"(\n PV Max= "+m_PVMax+"\n Inventaire= "+m_inventaire+")";
    }
}
