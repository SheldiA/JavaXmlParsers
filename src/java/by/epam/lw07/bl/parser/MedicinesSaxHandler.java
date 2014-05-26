/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw07.bl.parser;

import by.epam.lw07.bl.MedicineData;
import by.epam.lw07.bl.constant.XmlConst;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Anna
 */
enum MedicineEnum{
    NAME,
    COMPANY,
    GROUP,
    CONSISTENCE,
    FREQUENCY,
    NUMBER,
    ISAFTERFOOD,
    TYPE,
    PRICE,
    NUMBERPERPACKAGE
}

public class MedicinesSaxHandler extends DefaultHandler{
    private ArrayList<MedicineData> medicineDatas = new ArrayList<MedicineData>();
    private MedicineData curr = null;
    private MedicineEnum currEnum = null;
    
    public ArrayList<MedicineData> getMedicineDatas(){
        return medicineDatas;
    }
    
    public void startElement(String uri,String localName,String qName,Attributes attrs){
        if(qName.equals(XmlConst.XML_MEDICINE)){
            curr = new MedicineData();
            curr.setId(attrs.getValue(XmlConst.XML_ATTRIBUTE_ID)) ;
        }
        if(qName.equals(XmlConst.XML_DOSAGE)){
            curr.setDosageId(attrs.getValue(XmlConst.XML_ATTRIBUTE_ID));
        }
        if(qName.equals(XmlConst.XML_PACKAGE)){
            curr.setPackageId(attrs.getValue(XmlConst.XML_ATTRIBUTE_ID));
        }
        if(!(XmlConst.XML_MEDICINE).equals(qName) && !qName.equals(XmlConst.XML_MEDICINES) && !qName.equals(XmlConst.XML_DOSAGE) && !qName.equals(XmlConst.XML_PACKAGE))
            currEnum = MedicineEnum.valueOf(qName.toUpperCase());
    }
    
    public  void endElement(String uri,String localName,String qName){
        if(qName.equals(XmlConst.XML_MEDICINE))
            medicineDatas.add(curr);
        currEnum = null;
    }
    
    public void characters(char[] ch,int start,int length){
        String s = new String(ch,start,length).trim();
        if(currEnum == null)
            return;
        switch(currEnum){
            case COMPANY:
                curr.setCompany(s);
                break;
            case CONSISTENCE:
                curr.setConsistence(s);
                break;
            case FREQUENCY:
                curr.setDosageFrequency(s);
                break;
            case GROUP:
                curr.setGroup(s);
                break;
            case ISAFTERFOOD:
                curr.setIsAfterFood(s);
                break;
            case NAME :
                curr.setName(s);
                break;
            case NUMBER:
                curr.setDosageNumber(s);
                break;
            case NUMBERPERPACKAGE:
                curr.setNumberPerPackage(s);
                break;
            case PRICE:
                curr.setPackagePrice(s);
                break;
            case TYPE:
                curr.setPackageType(s);
                break;
        }
    }

    
}
