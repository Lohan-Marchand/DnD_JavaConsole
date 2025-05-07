package entites.personnages.equipements.armures;

public class Armures {
    private String m_nom;
    private int m_CA;
    private int m_MalusVitesse;

    public Armures(String nom,int CA, int MalusVitesse) {
        this.m_CA = CA;
        this.m_MalusVitesse = MalusVitesse;
        this.m_nom = nom;
    }
    public Armures(String nom,int CA) {
        this.m_CA = CA;
        this.m_MalusVitesse = 0;
        this.m_nom = nom;
    }
    public Armures(String nom) {
        this.m_nom = nom;
        this.m_MalusVitesse = 0;
        this.m_CA = 0;
    }
    public Armures() {
        this.m_CA = 0;
        this.m_MalusVitesse = 0;
    }

    public int getCA() {
        return m_CA;
    }
    public int getMalusVitesse() {
        return m_MalusVitesse;
    }
    @Override
    public String toString() {
        return (this.m_nom+" :\n CA= +"+this.m_CA+"\n Vit= -"+this.m_MalusVitesse);
    }
}