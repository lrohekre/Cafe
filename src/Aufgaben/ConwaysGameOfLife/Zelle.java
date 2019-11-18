package Aufgaben.ConwaysGameOfLife;

import java.util.Random;

public class Zelle
{
    private int x, y;
    private boolean lebendig;
    static Random rnd = new Random();

    Zelle (int x, int y, boolean lebendig)
    {
        this.x = x;
        this.y = y;
        this.lebendig = lebendig;
    }


    Zelle (int x, int y)
    {
        this.x = x;
        this.y = y;
        lebendig = rnd.nextBoolean();
    }


    public boolean getLebendig()
    {
        return  lebendig;
    }

    public void setLebendig (boolean lebendig)
    {
        this.lebendig = lebendig;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX (int x)
    {
        this.x = x;
    }

    public void setY (int y)
    {
        this.y = y;
    }


    @Override
    public String toString()
    {
        if (lebendig == false)
            return "x";
        else
            return ".";
    }

}
