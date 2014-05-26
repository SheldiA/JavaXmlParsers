/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw07.bl.parser;

import by.epam.lw07.bl.MedicineData;
import java.util.ArrayList;

/**
 *
 * @author Anna
 */
public interface IParser {
        public  ArrayList<MedicineData> parse(String pathName);
}
