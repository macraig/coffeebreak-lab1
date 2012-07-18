package test;

import DAO.LocationDAO;
import DAO.PlaceDAO;
import model.Location;
import model.Place;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class ReadXMLFile {
 
 public static void main(String argv[]) {

          ArrayList<Place> places = new ArrayList<Place>();
      Location location = null;

 
 try {
 
    File fXmlFile = new File("super.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);
    doc.getDocumentElement().normalize();

 
    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
    NodeList nList = doc.getElementsByTagName("place");
    System.out.println("-----------------------");

 
    for (int temp = 0; temp < nList.getLength(); temp++) {
 
       Node nNode = nList.item(temp);	    
       if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
          Element eElement = (Element) nNode;



          places.add(new Place(getTagValue("name", eElement), getTagValue("address", eElement), new Location(Double.parseDouble(getTagValue("latitude",eElement)),Double.parseDouble(getTagValue("longitude", eElement)))));


                  //imprimir todos los locales

//                  System.out.println("Name : " + getTagValue("name", eElement));
//          System.out.println("Address : "  + getTagValue("address",eElement));
//          System.out.println("Lat : "  + getTagValue("latitude",eElement));
//          System.out.println("Lng : "  + getTagValue("longitude",eElement));
 
        }
    }
  } catch (Exception e) {
    e.printStackTrace();
  }

         for(int i=0;i<places.size();i++){
//             System.out.println(places.get(i).getName());
//             System.out.println(places.get(i).getAddress());
//             System.out.println(places.get(i).getLocation().getLatitude());

             LocationDAO.persist(places.get(i).getLocation());
             PlaceDAO.persist(places.get(i));

         }
 }



 
 private static String getTagValue(String sTag, Element eElement){
    NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
    Node nValue = (Node) nlList.item(0); 
 
    return nValue.getNodeValue();    
 }
 
}