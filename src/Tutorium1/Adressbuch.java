package Tutorium1;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Adressbuch
{
    //Personen-ArrayListe
    private List<Person> Personen = new ArrayList<Person>();

    public List<Person> getPersonen()
    {

        return Personen;
    }


    public void hinzufuegen (Person person)
    {
        this.Personen.add(person);
        try {
            MyXMLParser.generateString(Personen);
        } catch (IOException e) {
            System.out.println("Datei konnte nicht erstellt werden. Versuche es erneut.");
        }
    }


    public void loeschen (Person person)
    {

        this.Personen.remove(person);
    }



    public List<Person> suchen (Person gesuchtePerson)
    {
        List<Person> foundPerson = new ArrayList<>();
        for (Person p : Personen)
        {
            if (gesuchtePerson.getName().equals(p.getName()))
                foundPerson.add(p);
            else if (gesuchtePerson.getVorname().equals(p.getVorname()))
                foundPerson.add(p);
            else
                foundPerson.add(p);
        }
        return foundPerson;
    }

}
