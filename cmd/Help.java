package cmd;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;
import iface.Command;
import obj.Player;
import core.Output;
import core.HandleData;

/**
 *Help 
 *Prints a message describing the command given to it. 
 *If used without arguments, prints a list of all the game commands.";
 */
public class Help implements Command {
   private String cmdName;
   private File cmdDir = new File("./cmd");

   public void exec (Player p) {
      if (cmdName != null) {
         try {
            Class<?> cmdClass = Class.forName("cmd." + cmdName);
            Object obj = cmdClass.getConstructor().newInstance();
            Output.println(obj);
         } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            Output.println(cmdName + " does not exist.");
         } catch (RuntimeException ignored) {
            // Do nothing
         }
      }

      // Help not supplied with parameters, print a list of commands
      else {
         Output.println("Game Commands: ");


         // Get a list of filenames in the command directory
         String[] cmdList = cmdDir.list();
         // Command names will be .java or .class files
         for (String s : cmdList)
            if ((Pattern.matches(".*java$", s)) || (Pattern.matches(".*class$", s))) {
               // Remove the .java from the command name
               String cmd = s.substring(0, s.indexOf("."));
               Output.println(cmd);
            } else if (cmdList.e)

         Output.println("Type help <cmd_name> for help on a specific command.");
      }
   }

   public void construct (String params[]) {
      if (params.length > 0)
         setName(params[0]); 
   }

   public void setName (String n) {
      cmdName = HandleData.upperFirst(n);
   }

   public String toString () {
      return "Usage: Help <cmd_name> \nPrints a message describing the command given to it. If used without arguments, prints a list of all the game commands.";
   }
   
   public void setDir (String d) {}
}

   
