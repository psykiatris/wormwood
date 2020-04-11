package core;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Input
 * Encapsulates Wormwood's input of raw data, such as strings.
 * Programmers should use Input.nextLine() instead of the 
 * Scanner class directly. */
public class Input {

   /**
    * Retrieves next line from console.
    * @return next line of text
    */
   public static String nextLine() {
      Scanner k = new Scanner(System.in, StandardCharsets.UTF_8);
      return k.nextLine();
   }


   /**
    * Retrieves the next integer from the console.
    * @return next integer
    */
   public static int nextInt() {
      Scanner k = new Scanner(System.in, StandardCharsets.UTF_8);
      return k.nextInt();
   }
}
      
