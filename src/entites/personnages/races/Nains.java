package entites.personnages.races;

public class Nains extends Races{
    private final int m_bonusForce;

    public Nains(){
        super("Nain");
        m_bonusForce = 6;
    }
    public int getBonusForce(){
        return m_bonusForce;
    }
    @Override
    public String toString(){
        return this.getNom()+"= (\n Bonus de force= "+m_bonusForce+")";
    }
}