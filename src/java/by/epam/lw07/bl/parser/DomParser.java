/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw07.bl.parser;

import by.epam.lw07.bl.MedicineData;
import by.epam.lw07.bl.constant.XmlConst;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Anna
 */
public class DomParser implements IParser{
     public  ArrayList<MedicineData> parse(String pathName){
         ArrayList<MedicineData> medicines = new ArrayList<MedicineData>();
         
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         try {
             DocumentBuilder db = dbf.newDocumentBuilder();
             Document document = db.parse(new FileInputStream(pathName));
             Element root = document.getDocumentElement();
             NodeList medicineNodes = root.getElementsByTagName(XmlConst.XML_MEDICINE);
             for(int i = 0; i < medicineNodes.getLength(); ++i){
                 MedicineData medicine = new MedicineData();
                 Element medicineElement = (Element)medicineNodes.item(i);
                 medicine.setId(medicineElement.getAttribute(XmlConst.XML_ATTRIBUTE_ID));
                 medicine.setCompany(getBabyValue(medicineElement, XmlConst.XML_COMPANY));
                 medicine.setName(getBabyValue(medicineElement, XmlConst.XML_NAME));
                 medicine.setGroup(getBabyValue(medicineElement, XmlConst.XML_GROUP));
                 medicine.setConsistence(getBabyValue(medicineElement, XmlConst.XML_CONSISTENCE));
                 
                 Element dosageElement = getBaby(medicineElement, XmlConst.XML_DOSAGE);
                 medicine.setDosageId(dosageElement.getAttribute(XmlConst.XML_ATTRIBUTE_ID));
                 medicine.setDosageFrequency(getBabyValue(dosageElement, XmlConst.XML_FREQUENCY));
                 medicine.setDosageNumber(getBabyValue(dosageElement, XmlConst.XML_NUMBER));
                 medicine.setIsAfterFood(getBabyValue(dosageElement, XmlConst.XML_ISAFTERFOOD));
                 
                 Element packageElement = getBaby(medicineElement, XmlConst.XML_PACKAGE);
                 medicine.setPackageId(packageElement.getAttribute(XmlConst.XML_PACKAGE));
                 medicine.setPackageType(getBabyValue(packageElement, XmlConst.XML_TYPE));
                 medicine.setPackagePrice(getBabyValue(packageElement, XmlConst.XML_PRICE));
                 medicine.setNumberPerPackage(getBabyValue(packageElement, XmlConst.XML_NUMBER_PER_PACKAGE));
                 medicines.add(medicine);
             }
             
         } catch (ParserConfigurationException ex) {
             Logger.getLogger(DomParser.class.getName()).log(Level.SEVERE, null, ex);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(DomParser.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SAXException ex) {
             Logger.getLogger(DomParser.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(DomParser.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return medicines;
     }
     
     private Element getBaby(Element parent, String childName){
         NodeList nList = parent.getElementsByTagName(childName);
         Element child = (Element)nList.item(0);
         return child;
     }
     
     private String getBabyValue(Element parent,String childName){
         Element child = getBaby(parent, childName);
         Node node = child.getFirstChild();
         String value = node.getNodeValue();
         return value;
     }
}
