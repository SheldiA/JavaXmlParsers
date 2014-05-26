/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw07.bl;
import by.epam.lw07.bl.command.ICommand;
import by.epam.lw07.bl.command.NoCommand;
import by.epam.lw07.bl.command.ParserCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Anna
 */
public class RequestHelper {
    private static RequestHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();
    
    private RequestHelper() {
        commands.put("parser", new ParserCommand());
        //commands.put("exit", new ExitCommand());
    }
    
    public static RequestHelper getInstance() {
        if (null == instance) {
            instance = new RequestHelper();
        }
        return instance;
    }
    
    public ICommand getCommand(HttpServletRequest request)  {
        String action = request.getParameter("command");
        ICommand command = commands.get(action);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }

}
