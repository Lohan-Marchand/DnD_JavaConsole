package donjons;

public class Positions {
    private int m_x;
    private int m_y;

    public Positions(){
        m_x = 0;
        m_y = 0;
    }
    public Positions(int x, int y){
        m_x = x;
        m_y = y;
    }
    public int getX(){
        return m_x;
    }
    public int getY(){
        return m_y;
    }
    public void setPosition(int x, int y){
        m_x = x;
        m_y = y;
    }
    @Override
    public String toString(){
        return "("+m_x+";"+m_y+")";
    }
}
