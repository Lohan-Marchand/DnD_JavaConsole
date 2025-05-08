package dice;
import java.util.Random;

public class Dice {
    private int val;
    public Dice() {
        this.val = 1;
    }
    public Dice(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return ""+val;
    }
    public int rollDice(int n) {
        Random rnd= new Random();
        int diceSum=0;
        for(int i=0;i<n;i++) {
            int diceVal = rnd.nextInt(this.val)+1;
            diceSum+=diceVal;
        }
        return diceSum;
    }
    public int rollDice() {
        Random rnd= new Random();
        int diceVal = rnd.nextInt(this.val)+1;
        return diceVal;
    }
}
