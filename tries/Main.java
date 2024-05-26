import java.util.List;

public class Main {
  public static void main(String[] args) { 

    Tries searchTries = new Tries();

    searchTries.insert("care");
    searchTries.insert("car");
    searchTries.insert("carefull");
    searchTries.insert("egg");

    List<String> words = searchTries.suggest("car");
    System.out.println(words);
  
    // searchTries.removeRecursive("care");
    // searchTries.removeRecursive("car");


    // searchTries.insert("cat");
    // searchTries.insert("car");
    // searchTries.insert("cattle");
    // searchTries.insert("dog");
    // searchTries.insert("dogma");
    // searchTries.insert("dollar");
    // searchTries.insert("dogmatize");
    // searchTries.insert("catipiller");
    // searchTries.insert("carrot");
    // searchTries.insert("dark");

    // searchTries.insert("canada");

    // searchTries.traverse();

    // System.out.println("search tries contains: " + searchTries.contains("do"));

  }
}
