import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {

    Scanner kbd = new Scanner(System.in);
    String name = "";
    String word = "";

    try {

      Registry registry = LocateRegistry.getRegistry();
      Hangman hangman = (Hangman) registry.lookup("hangman");

      do {
        System.out.print("Enter your name: ");
        name = kbd.nextLine();
        word = hangman.startGame(name);
        System.out.println(word);
      } while(word.equals("Player Already exists."));

      while(true) {
        String key = "";

        for(int i = 0; i < word.length(); i++) {
          key += (word.charAt(i) + " ");
        }

        System.out.println(key);

        String line = "";

        for(int i = 0; i < word.length(); i++) {
          line += "_ ";
        }
        //start of game

        do {

          System.out.println(line);

          System.out.print("Enter your letter guess: ");
          char input = kbd.nextLine().charAt(0);

          if(hangman.letterGuess(name, input)) {
            String replacement = "";
            for(int i = 0; i < word.length(); i++) {
              //System.out.println(replacement);
              if(word.charAt(i) == input) {
                replacement += (input + " ");
                //System.out.println(replacement);
              } else {
                if(i == 0) {
                  replacement += line.substring(0,2);
                  //System.out.println(replacement);
                } else {
                  replacement += line.substring(i * 2, (i + 1) * 2);
                  //System.out.println(replacement);
                }
              }
            }
            line = replacement;
          } else {
            // this erea can be replaced by the GUI where the line or shape can be drown;
            System.out.println("Wrong!");
          }
          System.out.println("Remaining life: " + hangman.getCurrentLife(name));
        } while(hangman.getCurrentLife(name) != 0 && !key.equals(line));

        if(hangman.getCurrentLife(name) == 0) {
          System.out.println("Do you still want to play?(y/n): ");
          char answer = kbd.nextLine().charAt(0);
          if(answer == 'n') {
            System.out.println(hangman.endGame(name));
            System.exit(0);
          }
        }
        word = hangman.newGame(name);

      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
