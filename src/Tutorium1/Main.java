package Tutorium1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main
{

    private static Adressbuch adressbuch = new Adressbuch();
    private static boolean running = true;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    //Main-Methode
    public static void main(String[] args) throws IOException
    {
        while (running)
        {
            //alle Daten aus der XML in die Liste speichern!!!



            System.out.println("Geben Sie die Buchstaben für einen der Befehle ein:");
            System.out.println("[S] - show entries");
            System.out.println("[A] - add");
            System.out.println("[E] - exit");
            System.out.println("[D] - delete");
            System.out.println("[Q] - query");

            try
            {
                String cmd = reader.readLine();
                executeCommand(cmd.toUpperCase()); //macht aus kleinen Buchstaben automatisch große
            }
            catch (Exception e)
            {
                System.out.println("Fehler bei der Eingabe");
            }
        }

    }


    //Befehle ausführen
    private static void executeCommand (String cmd)
    {
        switch (cmd)
        {
            case "S" :
                showAllEntries();
                break;
            case "A" :
                newEntry();
                break;
            case "E" :
                exitApplication();
                break;
            case "D" :
                deleteUser();
                break;
            case "Q" :
                searchUser();
                break;
            default:
                System.out.println("unbekanntes Kürzel");
        }
    }


    //neuer Eintrag
    private static void newEntry()
    {
        try
        {
            System.out.println("Vorname:");
            String vorname = reader.readLine();

            System.out.println("Name:");
            String name = reader.readLine();

            System.out.println("Telefonnummer");
            String telefonnummer = reader.readLine();

            //Variablen dem Konstruktor übergeben
            adressbuch.hinzufuegen(new Person(vorname, name, telefonnummer));
            System.out.println("Nutzer hinzugefügt!");
        }
        catch (Exception e)
        {
            System.out.println("Eintrag nicht möglich !!");
        }
    }


    //Anwendung beenden
    private static void exitApplication()
    {

        System.exit(0);
    }


    //alle Einträge anzeigen
    private static void showAllEntries()
    {
        List<Person> personen = adressbuch.getPersonen();
        int i = 1;
        for (Person p: personen )
        {
            System.out.println("Eintrag " + i++ +":");
            System.out.println("Vorname: " + p.getVorname());
            System.out.println("Name: " + p.getName());
            System.out.println("Telefonnummer: " + p.getTelefonnummer());
            System.out.println("--------------- \n");
        }
    }


    //Eintrag löschen
    private static void deleteUser()
    {
        System.out.println("Geben Sie den Namen des zu löschenden Users an:");
        try {
            String name = reader.readLine();
            List<Person> deletedPerson = adressbuch.getPersonen();
            for (Person p : deletedPerson)
            {
                if (p.getName().equals(name))
                    adressbuch.loeschen(p);
                if (deletedPerson == null  ||  deletedPerson.isEmpty()  ||  deletedPerson.lastIndexOf(p) == 0)
                    break;
            }
        } catch (IOException e) {
            System.out.println("Fehler");
        }
    }


    private static void searchUser()
    {
        try {
            System.out.println("Geben Sie die Suchparameter ein. Unbekannte Felder leer lassen.");
            System.out.println("Geben Sie den Vorname ein: ");
            String vorname = reader.readLine();
            System.out.println("Geben Sie den Namen ein: ");
            String name = reader.readLine();
            Person gesuchtePerson = new Person();

            if (!name.isEmpty())
                gesuchtePerson.setName(name);
            if (!vorname.isEmpty())
                gesuchtePerson.setVorname(vorname);

            System.out.println("Gefundene Person: ");
            List<Person> gefundenePerson = adressbuch.suchen(gesuchtePerson);
            for (Person p : gefundenePerson)
                System.out.println("Person gefunden: " + p);

        } catch (IOException e) {
            System.out.println("Fehler beim Einlesen der Eingabe!");
        }
    }


}
