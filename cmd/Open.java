package cmd;
import core.Grid;
import core.Output;
import obj.Exit;
import obj.Player;
import obj.Room;
import iface.Command;

/**
 * Open 
 * Opens a door (or other object, such as a box) that lies in the direction 
 * specified,";
 */
public class Open implements Command {
   private String name;
   private String dir;

   public void exec (Player p) {
	  // Get current room to find exits
	  Room r = p.getRoom();
	  Grid g = p.getGrid();
	  Exit e = g.getExit(r, this.dir);
	
	  // A null room is returned if the exit doesn't exist
      if (e != null) {
         if (e.isPassable()) 
            Output.println("The " + e.getName() + " is already open.");
         else if (e.isLocked())
            Output.println("Locked.");
         else if (e.isPassable() == false && e.isLocked() == false)
            e.setPassable(true);
      }

      else 
         Output.println("Nothing to open here.");
   }

   public void construct(String params[]){
	   if (params.length > 0) {
         setDir(params[0]);
         if (params.length == 2)
            setName(params[1]);
      }
   }
   
   public void setDir (String d) {
      dir = d;
   }

   public void setName (String n) {
      name = n;
   }

   public String toString () {
      return "Usage: Open <direction> <object>\nOpens a door (or other object, such as a box) that lies in the direction specified,";
   }
}
