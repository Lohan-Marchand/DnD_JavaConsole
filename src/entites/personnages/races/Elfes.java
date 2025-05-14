package entites.personnages.races;

public class Elfes extends Races{
    private int m_bonusDexterite;

    public Elfes(){
        super("Elfe");
        m_bonusDexterite = 6;
    }
    public int getBonusDexterite(){
        return m_bonusDexterite;
    }
    public String getStats(){
        return this.getNom()+" (Dex= +"+m_bonusDexterite+")";
    }
    @Override
    public String toString(){
        return this.getNom()+"= (\n Bonus de dextérité= "+m_bonusDexterite+")";
    }
}