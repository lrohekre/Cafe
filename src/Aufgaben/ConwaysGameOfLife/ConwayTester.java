package Aufgaben.ConwaysGameOfLife;

import java.io.IOException;

public class ConwayTester
{
    public void randomGitter()
    {
        Gitter gi = new Gitter(10, 10, true);
        for (int i = 0; i < 2; i++)
        {
            gi.nextGeneration();
            gi.print();
            System.out.println("-------------");
        }
    }


    public static void main(String[] args) throws IOException
    {
        Gitter gi = new Gitter(5, 5, false);
        //Gitter laut Tafelbild
        gi.setZelle(2, 0, true);
        gi.setZelle(3, 0, true);
        gi.setZelle(4, 0, true);
        gi.setZelle(2, 1, true);
        gi.setZelle(3, 1, true);
        gi.setZelle(4, 1, true);
        gi.setZelle(0, 3, true);
        gi.setZelle(0, 4, true);
        gi.setZelle(1, 4, true);
        gi.setZelle(2, 4, true);

        gi.print();
        System.out.println("____________");
        gi.nextGeneration();
        gi.print();

    }


}
