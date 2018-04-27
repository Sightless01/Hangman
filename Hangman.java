import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hangman extends Remote {
  public String startGame(String name) throws RemoteException;
}
