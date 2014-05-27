/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw07.bl.command;

import by.epam.lw07.bl.MedicineData;
import by.epam.lw07.bl.manager.ConfigurationManager;
import by.epam.lw07.bl.parser.DomParser;
import by.epam.lw07.bl.parser.SaxParser;
import by.epam.lw07.bl.parser.StaxParser;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anna
 */
public class ParserCommand implements ICommand{
    private static final String PARAM_PARSER = "parser";
    private static final String PARAM_FILE_PATH = "filePath";
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String page = null;
        String filePath = request.getParameter(PARAM_FILE_PATH);
        String parser = request.getParameter(PARAM_PARSER);
        request.setAttribute("parser", parser);
        ArrayList<MedicineData> medicines = null;
        if(parser.equals("sax")){
            SaxParser sp = new by.epam.lw07.bl.parser.SaxParser();
            medicines = sp.parse(filePath);
        }
        if(parser.equals("dom")){
            DomParser dp = new DomParser();
            medicines = dp.parse(filePath);
        }
        if(parser.equals("stax")){
            StaxParser stp = new StaxParser();
            medicines = stp.parse(filePath);
        }
        request.setAttribute("medicines", medicines);
        page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.PARSER_PAGE_PATH);
        return page;
    }
}
