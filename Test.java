import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

  public static void main(String[] rags) throws Exception {
    File file = new File("words.txt");
    Scanner read = new Scanner(file);
    ArrayList<String> words = new ArrayList<>();
    do {
      words.add(read.nextLine());
    } while(read.hasNext());

    System.out.println(words);
  }
}
