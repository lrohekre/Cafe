package Tutorium1;

public class Person
{
    //Attribute
    private String Vorname;
    private String Name;
    private String Telefonnummer;
    /*
    private String Strasse;
    private int Plz;
    private date Geburtsdatum;
    private String Email;

     */


    //Konstruktor (reines Objekt)
    public Person()
    {

    }


    //Konstruktor mit Parameterübergabe
    public Person (String vorname, String name, String telefonnummer)
    {
        Vorname = vorname;
        Name = name;
        Telefonnummer = telefonnummer;
    }


    //getter
    public String getName()
    {
        return Name;
    }

    public String getTelefonnummer()
    {
        return Telefonnummer;
    }

    public String getVorname()
    {
        return Vorname;
    }


    //setter
    public void setName (String name)
    {
        Name = name;
    }

    public void setTelefonnummer (String telefonnummer)
    {
        Telefonnummer = telefonnummer;
    }

    public void setVorname (String vorname)
    {
        Vorname = vorname;
    }


    @Override
    public String toString()
    {
        return "Vorname:" + Vorname + "\n" +
               "Name: " + Name + "\n" +
               "Telefonnummer: " + Telefonnummer +
                "\n ----------------";
    }



}
