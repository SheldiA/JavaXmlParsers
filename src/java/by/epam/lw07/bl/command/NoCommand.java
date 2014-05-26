/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw07.bl.command;
import by.epam.lw07.bl.manager.ConfigurationManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Anna
 */
public class NoCommand implements ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String page = ConfigurationManager.getInstance().
                getProperty(ConfigurationManager.MAIN_PAGE_PATH);
        return page;
    }
    
}
