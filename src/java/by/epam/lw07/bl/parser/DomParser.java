/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw07.bl.parser;

import by.epam.lw07.bl.MedicineData;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 *
 * @author Anna
 */
public class DomParser implements IParser{
     public  ArrayList<MedicineData> parse(String pathName){
         ArrayList<MedicineData> medicines = new ArrayList<MedicineData>();
         
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         
         return medicines;
     }
}
