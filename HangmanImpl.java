
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanImpl extends UnicastRemoteObject implements Hangman {
  ArrayList<Player> players = new ArrayList<>();
  ArrayList<String> words = new ArrayList<>();

  public HangmanImpl() throws RemoteException, Exception {
    getWords();
  }

  @Override
  public String startGame(String name) throws RemoteException {
    Random random = new Random();
    String word = "";
    if(players.contains(name)) {
      players.add(new Player(name));
      do {
        int num = random.nextInt(words.size());
        word = words.get(num);
      } while(!getPlayerByName(name).words.contains(word));
      getPlayerByName(name).words.add(word);
    } else {
      return "Player Already exists.";
    }
    return word;
  }

  private Player getPlayerByName(String name) {
    return players.get(players.indexOf(new Player(name)));
  }

  private void getWords() throws Exception {
    File file = new File("words.txt");
    Scanner read = new Scanner(file);
    ArrayList<String> words = new ArrayList<>();
    do {
      words.add(read.nextLine());
    } while(read.hasNext());
  }
}
