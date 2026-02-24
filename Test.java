import java.util.*;

class Test {
  public static void main(String[] args) {
    HashMap<Integer, String> hm = new HashMap<>();

    hm.put(0, "Hi");
    hm.put(1, "My");
    hm.put(3, "Is");
    hm.put(2, "Name");
    hm.put(4, "Bob");

    int mapSize = hm.size(); // returns size of map
    String ele = hm.get(1); // finds the key provided and returns the value associated with it
    System.out.println(mapSize + " " + ele);
    hm.remove(3);
    // current hm:
    /*
     * Hi
     * My
     * Name
     * Bob
     */
    hm.replace(2, "Charlie");
    /*
     * Hm is now:
     * Hi
     * My
     * Charlie
     * Bob
     */

    System.out.println("Hm key 2 value: " + hm.get(2));
    hm.put(0, "Hola"); // also replaces value at key 0 with "Hola"

    // make sure if you run this code to use import java.util.HashMap;

    // prints only keys
    System.out.println("Keys:");
    for (Integer key : hm.keySet()) {
      System.out.println(key);
    }

    // prints only values
    System.out.println("Values:");
    for (String value : hm.values()) {
      System.out.println(value);
    }
  }
}
