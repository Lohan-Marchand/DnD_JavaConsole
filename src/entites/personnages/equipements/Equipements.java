package entites.personnages.equipements;

public abstract class Equipements {
    private String m_nom;
    public Equipements(String nom) {
        m_nom = nom;
    }
    public Equipements() {
        m_nom = "Equipement sans nom";
    }
    public String getNom() {
        return m_nom;
    }
    @Override
    public String toString() {
        return m_nom;
    }
}
