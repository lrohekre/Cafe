package Tutorium1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.List;

public class MyXMLParser
{
    private static Adressbuch Personen = new Adressbuch();


    public static void generateString (List<Person> personen) throws IOException
    {
        //XML-Parser
        String xml = "";
        xml += "<?.....?>";
        xml += "<Personen>";
        for (Person p : personen)
        {
            xml += "\t<Person>";
            xml += "\t\t<Name>" + p.getName() + "</Name>";
            xml += "\t\t<Vorame>" + p.getVorname() + "</Vorname>";
            xml += "\t\t<Telefonnummer>" + p.getTelefonnummer() + "</Telefonnummer>";
            xml += "\t<Person>";
        }
        xml += "<Personen>";

        FileWriter fw = new FileWriter("Personen.xml");
        BufferedWriter writer = new BufferedWriter(fw);
        fw.write(xml);
        writer.write(xml);
        writer.close();
        fw.close();
    }

    public static void main(String[] args)
    {


    }



}
