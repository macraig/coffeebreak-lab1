package test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Parser
{
    public static void main(String[] args) throws TransformerException {
        String baseURL = "http://guiaoleo.com.ar/u/";
        File file = new File("super2.xml");
        Writer output =null;
        ArrayList<Resto> a = new ArrayList<Resto>();
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        try {
            output = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            //   SOLO HICE 560  .... arranca de 560..
            for (int i = 600; i < 10000; i++) {
                System.out.println(i);
                URL url = new URL(baseURL.concat(""+i));
                URLConnection connection = url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("ISO-8859-1")));

                Resto resto = new Resto();
                String inputLine;

                while ((inputLine = in.readLine()) != null)
                {
                    if(inputLine.contains("var contentString="))
                    {
                        nameAddressLineParser(resto, inputLine);
                    }
                    if(inputLine.contains("var Latitud ="))
                    {
                        latitudLineParser(resto, inputLine);
                    }
                    if(inputLine.contains("var  Longitud ="))
                    {
                        longitudLineParser(resto, inputLine);
                    }

                    if(!resto.isEmpty())
                        break;
                }
                in.close();

                if(!resto.isEmpty())
                {
                    System.out.println(resto);
                    System.out.println();
                    a.add(resto);
                    output.write(resto.toString());

//                    Aca la caldeo yo




                    // aca termina lo cualquiera



                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

          Document doc = docBuilder.newDocument();
          Element rootElement = doc.createElement("Locales");
            doc.appendChild(rootElement);



        for (int i=0; i<a.size();i++){

            Resto resto = a.get(i);
            //root elements

            Element place = doc.createElement("place");
            rootElement.appendChild(place);

            //firstname elements
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(resto.getName()));
            rootElement.appendChild(name);

            //lastname elements
            Element address = doc.createElement("address");
            address.appendChild(doc.createTextNode(resto.getAddress()));
            rootElement.appendChild(address);

            //nickname elements
            Element latitude = doc.createElement("latitude");
            latitude.appendChild(doc.createTextNode(resto.getLatitud()));
            rootElement.appendChild(latitude);

            //salary elements
            Element longitude = doc.createElement("longitude");
            longitude.appendChild(doc.createTextNode(resto.getLongitud()));
            rootElement.appendChild(longitude);

        }

            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("locales2.xml"));
            transformer.transform(source, result);

            System.out.println("Done");

    }

    private static void longitudLineParser(Resto resto, String line) {
        String longitud = line.substring(19, line.length()-1);
        resto.setLongitud(longitud);
    }

    private static void latitudLineParser(Resto resto, String line)
    {
        String latitud = line.substring(17, line.length()-1);
        resto.setLatitud(latitud);
    }

    private static void nameAddressLineParser(Resto resto, String line)
    {
        line = line.substring(31, line.length()-2);
        int i = 0;
        StringBuilder name =  new StringBuilder();
        while(line.charAt(i) != '<')
        {
            name.append(line.charAt(i));
            i++;
        }

        line = line.substring(i+15, line.length());
        i = 0;
        StringBuilder address = new StringBuilder();
        while(line.charAt(i) != '<')
        {
            address.append(line.charAt(i));
            i++;
        }

        resto.setName(name.toString());
        resto.setAddress(address.toString());
    }

}
