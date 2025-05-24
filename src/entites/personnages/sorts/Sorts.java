package entites.personnages.sorts;

import entites.personnages.Personnages;

import java.util.Objects;

public class Sorts {
    private String m_nom;
    private String m_description;

    public Sorts() {
        this.m_nom = "Sort sans nom";
        this.m_description = "Description du sort";
    }
    public Sorts(String nom, String description) {
        this.m_nom = nom;
        this.m_description = description;
    }

    public String getNom() {
        return m_nom;
    }
    public String getDescription() {
        return m_description;
    }

    //Je sais pas trop comment faire pour celle-ci dcp chaque sort la surcharge
    public void lancerSort(){
        //Je sais pas quoi mettre ici, elle est surchargée dans les sous-classes
        System.out.println("lancerSort n'est pas implémenté pour ce sort.");
    }
    @Override
    public String toString() {
        return "Sort: "+m_nom+"\nDescription: "+m_description;
    }
}
