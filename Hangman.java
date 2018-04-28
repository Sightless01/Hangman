import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hangman extends Remote {
  public String startGame(String name) throws RemoteException;
  public int getCurrentLife(String name) throws RemoteException;
  public boolean letterGuess(String name, char letter) throws RemoteException;
  public boolean wordGuess(String name, String guess) throws RemoteException;
  public String newGame(String name) throws RemoteException;
  public String endGame(String name) throws RemoteException;
}
