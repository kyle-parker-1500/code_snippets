import java.util.*;
import java.io.*;

class Help {
  private String filename;
  private String file2;
  private HashMap<Integer, String> hm;

  Help(String filename, String file2) {
    this.filename = filename;
    this.file2= file2;
    hm = new HashMap<>();
  }
  
  public void cleanFile() {
    ArrayList<String> cleanWords = new ArrayList<>();

    File file = new File(filename);
    try (Scanner scan = new Scanner(file)) {
      
    FileWriter fw = new FileWriter(file2);
      
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        for (String word : line.trim().split("[,|.|'|\"|?|!|-|(|)|\s]")) {
          cleanWords.add(word);     
          cleanWords.add("\n");
        }
      }
      
      for (String word : cleanWords) {
        fw.write(word);
      }

    } catch (IOException e) {
      System.out.println("File error: " + e);
    } 
  }

  public void readFromFile() {
    File file = new File(file2);
    try (Scanner scan = new Scanner(file)) {

      int id = 0;

      while (scan.hasNextLine()) {
        String currentWord = scan.next().trim();
        
        if (!hm.containsValue(currentWord)) {
          hm.put(id, currentWord);
          System.out.printf("hm.put(%d, %s); <br>%n", id, currentWord);
        } else {
          // find current word's id
          int tempId = 0;
          for (int i : hm.keySet()) {
            if (hm.get(i).equals(currentWord)) {
              tempId = i;
            }
          } 
          System.out.printf("hm.get(%d); <br>%n", tempId); 
        }

        id++;
      }

    } catch (IOException e) {
      System.out.println("File error: " + e);
    }
  }
  
  public static void main(String[] args) {
    Help me = new Help("./lose_yourself.txt", "./clean_lose_yourself.txt");
    
    me.cleanFile();
    me.readFromFile();
  }
}
