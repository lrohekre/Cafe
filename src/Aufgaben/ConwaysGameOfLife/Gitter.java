package Aufgaben.ConwaysGameOfLife;

public class Gitter
{
    private Zelle[][] gitter;
    final int GITTERSIZEX, GITTERSIZEY;


    Gitter(int gitterSizeX, int gitterSizeY, boolean rndm)
    {
        GITTERSIZEX = gitterSizeX;
        GITTERSIZEY = gitterSizeY;

        gitter = new Zelle[GITTERSIZEX][GITTERSIZEY];

        for (int i = 0; i <= GITTERSIZEX - 1; i++)
        {
            for (int k = 0; k <= GITTERSIZEY - 1; k++)
            {
                if (rndm)
                    gitter[i][k] = new Zelle(i, k);
                if (!rndm)
                    gitter[i][k] = new Zelle(i, k, false);
            }
        }
    }


    public void lebenOderSterben (Zelle z)
    {
        int nachbar = 0;

        //links mitte
        if (gitter[z.getX() - 1][z.getY()]    .getLebendig() == true)
            nachbar++;
        //links oben
        if (gitter[z.getX() - 1][z.getY() + 1].getLebendig() == true)
            nachbar++;
        //links unten
        if (gitter[z.getX() - 1][z.getY() - 1].getLebendig() == true)
            nachbar++;
        //mitte oben
        if (gitter[z.getX()    ][z.getY() + 1].getLebendig() == true)
            nachbar++;
        //mitte unten
        if (gitter[z.getX()]    [z.getY() - 1].getLebendig() == true)
            nachbar++;
        //mitte rechts
        if (gitter[z.getX() + 1][z.getY()]    .getLebendig() == true)
            nachbar++;
        //rechts unten
        if (gitter[z.getX() + 1][z.getY() + 1].getLebendig() == true)
            nachbar++;
        //rechts unten
        if (gitter[z.getX() + 1][z.getY() - 1].getLebendig() == true)
            nachbar++;


        if (z.getLebendig() == true)
        {
            if (nachbar == 3  ||  nachbar == 2)
                z.setLebendig(true);
            if (nachbar < 2)
                z.setLebendig(false);
            if (nachbar > 3)
                z.setLebendig(false);
        }
        else
        {
            if (nachbar == 3)
                z.setLebendig(true);
        }

    }


    /**
     * geht zur nächsten Zelle und initialisiert die Methode lebenOderSterben
     */
    public void nextGeneration()
    {
        for (int i = 1; i < GITTERSIZEX - 1; i++)
        {
            for (int k = 1; k < GITTERSIZEY - 1; k++)
            {
                lebenOderSterben(gitter[i][k]);
            }
        }
    }


    public void print()
    {
        for (int i = 0; i < GITTERSIZEY; i++)
        {
            for (int k = 0; k < GITTERSIZEX; k++)
            {
                System.out.print(gitter[k][i]);
            }
            System.out.print("\n");
        }
    }

    public Zelle[][] getGitter()
    {
        return gitter;

    }

    public void setZelle(int x, int y, boolean lebendig)
    {
        if (x < GITTERSIZEX  &&  x >= 0
            &&  y < GITTERSIZEY  &&  y >= 0)
        gitter[x][y].setLebendig(lebendig);
    }
}
