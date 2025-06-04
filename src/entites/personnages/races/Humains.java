package entites.personnages.races;

public class Humains extends Races{
    private final int m_bonusForce;
    private final int m_bonusDexterite;
    private final int m_bonusVitesse;
    private final int m_bonusInitiative;

    public Humains(){
        super("Humain");
        m_bonusForce = 2;
        m_bonusDexterite = 2;
        m_bonusVitesse = 2;
        m_bonusInitiative = 2;
    }
    public int getBonusForce(){
        return m_bonusForce;
    }
    public int getBonusDexterite(){
        return m_bonusDexterite;
    }
    public int getBonusVitesse(){
        return m_bonusVitesse;
    }
    public int getBonusInitiative(){
        return m_bonusInitiative;
    }

    public String getStats(){
        return this.getNom()+" (For= +"+m_bonusForce+" | Dex= +"+m_bonusDexterite+" | Vit= +"+m_bonusVitesse+" | Initiative= +"+m_bonusInitiative+")";
    }
    @Override
    public String toString(){
        return this.getNom()+"= (\n Bonus de force= "+m_bonusForce+"\n Bonus de dextérité= "+m_bonusDexterite+"\n Bonus de vitesse= "+m_bonusVitesse+"\n Bonus d'initiative= "+m_bonusInitiative+")";
    }
}