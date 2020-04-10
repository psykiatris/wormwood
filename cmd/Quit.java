package cmd;
import core.Input;
import core.Output;
import obj.Player;
import iface.Command;
import core.Game;

/**
 * Quit 
 * Quits the game.
 */
public class Quit implements Command {
   
   public void exec (Player p) {
      Output.println("Are you sure you wish to quit? (y/n)");
      String answer;

      do {
         answer = Input.nextLine(); 
         if ("y".equalsIgnoreCase(answer))
            Game.kill();
         else if (!"n".equalsIgnoreCase(answer) && !"y".equalsIgnoreCase(answer))
            // Continue loop
            Output.println("You must answer with y or n.");
      } while (!"n".equalsIgnoreCase(answer) && !"y".equalsIgnoreCase(answer));
   }
   
   public String toString () {
      return "Usage: Quit\nQuits the game.";
   }

   public void construct(String params[]){}
}
