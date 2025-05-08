package dice;
import java.util.Random;

public class Dice {
    private int m_val;

    public Dice() {
        this.m_val = 1;
    }
    public Dice(int val) {
        this.m_val = val;
    }
    @Override
    public String toString() {
        return ""+ this.m_val;
    }
    public int rollDice(int nRolls) {
        Random rnd = new Random();
        int diceSum=0;
        for(int i=0;i<nRolls;i++) {
            int diceVal = rnd.nextInt(this.m_val)+1;
            diceSum+=diceVal;
        }
        return diceSum;
    }
    public int rollDice() {
        Random rnd= new Random();
        int diceVal = rnd.nextInt(this.m_val)+1;
        return diceVal;
    }
}
