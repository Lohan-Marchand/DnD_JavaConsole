package entites.personnages.races;

public class Halfelins extends Races{
    private final int m_bonusDexterite;
    private final int m_bonusVitesse;

    public Halfelins(){
        super("Halfelin");
        m_bonusDexterite = 6;
        m_bonusVitesse = 2;
    }
    public int getBonusDexterite(){
        return m_bonusDexterite;
    }
    public int getBonusVitesse(){
        return m_bonusVitesse;
    }
    @Override
    public String toString(){
        return this.getNom()+"= (\n Bonus de dextérité= "+m_bonusDexterite+"\n Bonus de vitesse= "+m_bonusVitesse+")";
    }
}