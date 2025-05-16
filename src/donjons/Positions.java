package donjons;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Positions)) return false;
        Positions other = (Positions) o;
        return m_x == other.m_x && m_y == other.m_y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(m_x, m_y);
    }
}
