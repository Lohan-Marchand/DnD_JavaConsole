package entites.personnages.equipements;

public abstract class Equipements {
    private String m_nom;
    private String m_categorie;
    public Equipements(String nom) {
        m_nom = nom;
        m_categorie = "sans catégories";
    }
    public Equipements(String nom, String categorie) {
        m_nom = nom;
        m_categorie = categorie;
    }
    public Equipements() {
        m_nom = "Equipement sans nom";
        m_categorie = "sans catégorie";
    }
    public String getNom() {
        return m_nom;
    }
    public String getCategorie() {
        return m_categorie;
    }
    @Override
    public String toString() {
        return m_nom;
    }
}
