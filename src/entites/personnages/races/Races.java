package entites.personnages.races;

public class Races {
    private final String m_nom;

    public Races(){
        m_nom = "Race sans nom";
    }
    public Races(String nom){
        m_nom = nom;
    }
    public String getNom(){
        return m_nom;
    }
    public int getBonusForce(){
        return 0;
    }
    public int getBonusDexterite(){
        return 0;
    }
    public int getBonusVitesse(){
        return 0;
    }
    public int getBonusInitiative(){
        return 0;
    }
    public int getBonusPVMax(){
        return 0;
    }
    @Override
    public String toString(){
        return this.getNom();
    }
}
