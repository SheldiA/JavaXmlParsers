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
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Anna
 */
public class StaxParser implements IParser{
    public  ArrayList<MedicineData> parse(String pathName){
        ArrayList<MedicineData> medicines = new ArrayList<MedicineData>();
        String currString = null;
        
        InputStream input = null;
        try {
            input = new FileInputStream(pathName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StaxParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            String name = "";
            MedicineData currData = null;
            
            while(reader.hasNext()){                
                int type = reader.next();
                switch(type){
                    
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        if(name.equals(XmlConst.XML_MEDICINE)){
                            currData = new MedicineData();
                            currData.setId(reader.getAttributeValue(null, XmlConst.XML_ATTRIBUTE_ID));
                        }
                        if(currData != null){
                            if(name.equals(XmlConst.XML_DOSAGE))
                                currData.setDosageId(reader.getAttributeValue(null, XmlConst.XML_ATTRIBUTE_ID));
                            if(name.equals(XmlConst.XML_PACKAGE))
                                currData.setPackageId(reader.getAttributeValue(null, XmlConst.XML_ATTRIBUTE_ID));
                        }
                        
                    break;
                        
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if(name.equals(XmlConst.XML_MEDICINE) && currData != null){
                            medicines.add(currData);
                            currData = null;
                        }
                        if(!(XmlConst.XML_MEDICINE).equals(name) && !name.equals(XmlConst.XML_MEDICINES) && !name.equals(XmlConst.XML_DOSAGE) && !name.equals(XmlConst.XML_PACKAGE))
                            if(currData != null){
                                switch(MedicineEnum.valueOf(name.toUpperCase())){
                                    case COMPANY:
                                        currData.setCompany(currString);
                                        break;
                                    case NAME:
                                        currData.setName(currString);
                                        break;
                                    case GROUP:
                                        currData.setGroup(currString);
                                        break;
                                    case CONSISTENCE:
                                        currData.setConsistence(currString);
                                        break;
                                    case FREQUENCY:
                                        currData.setDosageFrequency(currString);
                                        break;
                                    case ISAFTERFOOD:
                                        currData.setIsAfterFood(currString);
                                        break;
                                    case NUMBER:
                                        currData.setDosageNumber(currString);
                                        break;
                                    case NUMBERPERPACKAGE:
                                        currData.setNumberPerPackage(currString);
                                        break;
                                    case PRICE:
                                        currData.setPackagePrice(currString);
                                        break;
                                    case TYPE:
                                        currData.setPackageType(currString);
                                        break;
                                    default:
                                        break;
                                }
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        currString = reader.getText().trim();
                        break;
                }
            }
        } catch (XMLStreamException ex) {
            Logger.getLogger(StaxParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return medicines;
    }
    
}
