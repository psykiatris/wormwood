public class Move implements Command {
   private char dir;

   public void exec (Player player) {
      // Get current room to find exits
      Room r = player.getRoom();
      Exit e = r.getExit(dir);      

      // A null room is returned if the exit doesn't exist
      if (e != null) {
         Room newRoom = e.getRoom();
         player.setRoom(newRoom);
         // Print the description of the room
         System.out.println(newRoom);
      }
      else
         Output.println("You cannot go that way.");
   }

   public void setDir (char d) {
      dir = d;
   }

   public void setName (String n) {}
}
