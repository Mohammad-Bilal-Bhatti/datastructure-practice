import java.util.List;

public class Main {
  public static void main(String[] args) {

    Graph flightsMap = new Graph();


    flightsMap.addNode("A");
    flightsMap.addNode("B");
    flightsMap.addNode("C");
    flightsMap.addNode("D");

    flightsMap.addEdge("A", "B");
    flightsMap.addEdge("B", "C");
    flightsMap.addEdge("C", "A");
    flightsMap.addEdge("D", "A");

    System.out.println("Has cycle: " + flightsMap.hasCycle());
    System.out.println("Has cycle mosh: " + flightsMap.hasCycleMosh());

    // flightsMap.addNode("X");
    // flightsMap.addNode("A");
    // flightsMap.addNode("B");
    // flightsMap.addNode("P");

    // flightsMap.addEdge("X", "A");
    // flightsMap.addEdge("X", "B");
    // flightsMap.addEdge("A", "P");
    // flightsMap.addEdge("B", "P");

    // List<String> result = flightsMap.topologicalSort();
    // System.out.println("Result: " + result);

    // flightsMap.addNode("A");
    // flightsMap.addNode("B");
    // flightsMap.addNode("C");
    // flightsMap.addNode("D");

    // flightsMap.addEdge("A", "B");
    // flightsMap.addEdge("A", "C");
    // flightsMap.addEdge("B", "D");
    // flightsMap.addEdge("D", "C");


    // flightsMap.traverseDepth("A");
    // System.out.println("---");
    // flightsMap.traverseDepthIterative("A");
    // System.out.println("---");
    // flightsMap.traverseBredth("A");


    // flightsMap.addNode("Karachi");
    // flightsMap.addNode("Hyderabad");
    // flightsMap.addNode("Morro");
    // flightsMap.addNode("Sukkur");
    // flightsMap.addNode("Multan");
    // flightsMap.addNode("Lahore");
    // flightsMap.addNode("Islamabad");

    // flightsMap.addEdge("Karachi", "Hyderabad");
    // flightsMap.addEdge("Hyderabad", "Morro");
    // flightsMap.addEdge("Morro", "Sukkur");
    // flightsMap.addEdge("Sukkur", "Multan");
    // flightsMap.addEdge("Multan", "Lahore");
    // flightsMap.addEdge("Lahore", "Islamabad");

    // flightsMap.addEdge("Karachi", "Sukkur");
    // flightsMap.addEdge("Sukkur", "Morro");
    // flightsMap.addEdge("Hyderabad", "Karachi");
    // flightsMap.addEdge("Sukkur", "Karachi");
    // flightsMap.addEdge("Karachi", "Islamabad");
    // flightsMap.addEdge("Islamabad", "Karachi");

    // System.out.println("== Initially ==");
    // flightsMap.print();

    // /* we are no longer support direct flights from Hyderabad to Karachi */
    // flightsMap.removeEdge("Karachi", "Hyderabad");
    // System.out.println("== After removing Karachi -> Hyderabad edge ==");
    // flightsMap.print();

    // /* we are no longer support multan flights */
    // flightsMap.removeNode("Multan");
    // System.out.println("== After removing Multan node ==");
    // flightsMap.print();

  }
}