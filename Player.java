import java.util.ArrayList;
import java.io.Serializable;

public class Player implements Serializable {
  public String name;
  public ArrayList<String> words;

  public Player(String name) {
    this.name = name;
    words = new ArrayList<>();
  }
  @Override
  public boolean equals(Object o) {
    boolean bool = false;
    if(o instanceof Player) {
      Player player = (Player) o;
      bool = player.name.equals(this.name);
    }
    return bool;
  }
}
