import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
  public static void main(String[] args) throws Exception {
    Registry registry = LocateRegistry.getRegistry();
    Hangman hangman = new HangmanImpl();
    registry.rebind("hangman", hangman);
    System.out.println("Server is already running");
  }
}
