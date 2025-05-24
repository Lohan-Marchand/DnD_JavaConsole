package dice;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dice {
    private int m_val;
    private int m_bonusJet;

    public Dice() {
        this.m_val = 1;
        this.m_bonusJet = 0;
    }
    public Dice(int val) {
        this.m_val = val;
        this.m_bonusJet = 0;
    }
    public int getVal(){
        return m_val;
    }
    public int getBonusJet() {
        return m_bonusJet;
    }
    public void setVal(int val) {
        this.m_val = val;
    }
    public void setBonusJet(int bonusJet) {
        this.m_bonusJet = bonusJet;
    }
    @Override
    public String toString() {
        return ""+ this.m_val;
    }
    public int rollDice(int nRolls) {
//        System.out.println("Lancez les dés (appuyez sur entrer)");
//        Scanner sc = new Scanner(System.in);
//        sc.nextLine();
        Random rnd = new Random();
        int diceSum=0;
        for(int i=0;i<nRolls;i++) {
            int diceVal = rnd.nextInt(this.m_val)+1;
            diceSum+=diceVal;
//            System.out.println("Dé n°"+i+1+" : "+diceVal);
        }
//        System.out.println("Vous avez fait "+diceSum);
        return diceSum+this.m_bonusJet;
    }
    public int rollDice() {
//        System.out.println("Lancez le dé (appuyez sur entrer)");
//        Scanner sc = new Scanner(System.in);
//        sc.nextLine();
        Random rnd= new Random();
        int diceVal = rnd.nextInt(this.m_val)+1;
//        System.out.println("Vous avez fait "+diceVal);
        return diceVal+this.m_bonusJet;
    }
    public int rollDice(int nRolls,ArrayList<Integer> deroulement) {
        Random rnd = new Random();
        int diceSum=0;
        for(int i=0;i<nRolls;i++) {
            int diceVal = rnd.nextInt(this.m_val)+1;
            deroulement.add(diceVal);
            diceSum+=diceVal;
        }
        deroulement.add(diceSum);
        return diceSum;
    }
}
