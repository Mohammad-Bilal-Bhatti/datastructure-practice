import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
  private class Node {
    private String label;
    Node (String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || this.getClass() != obj.getClass()) return false;

      Node node = (Node)obj;
      return label == node.label;
    }

  }

  private Map<String, Node> nodes;
  private Map<Node, List<Node>> relationship;

  Graph() {
    this.nodes = new HashMap<>();
    this.relationship = new HashMap<>();
  }

  public void addNode(String label) {
    Node node = new Node(label);
    boolean hasNode = nodes.containsKey(label);
    if (hasNode) throw new IllegalArgumentException("Node already exists");

    nodes.putIfAbsent(label, node);
    relationship.putIfAbsent(node, new ArrayList<>());
  }

  public void removeNode(String label) {
    boolean hasNode = nodes.containsKey(label);
    if (!hasNode) throw new IllegalArgumentException("Cannot remove node that doesn't exists");

    Node targetNode = nodes.get(label);

    /* remove all associations of that node */
    for (String key: nodes.keySet()) {
      Node node = nodes.get(key);
      if (node == targetNode) continue;
      relationship.get(node).remove(targetNode);
    }

    /* finally remove the node */
    nodes.remove(label);
    relationship.remove(targetNode);
  }

  public void addEdge(String from, String to) {

    Node fromNode = nodes.get(from);
    Node toNode = nodes.get(to);

    if (fromNode == null) throw new IllegalArgumentException("From node doesn't exists");
    if (toNode == null) throw new IllegalArgumentException("To node doesn't exists");

    relationship.get(fromNode).add(toNode);
  }
  
  public void removeEdge(String from, String to) {

    Node fromNode = nodes.get(from);
    Node toNode = nodes.get(to);

    if (fromNode == null) throw new IllegalArgumentException("From node doesn't exists");
    if (toNode == null) throw new IllegalArgumentException("To node doesn't exists");


    if (relationship.get(fromNode).contains(toNode)) relationship.get(fromNode).remove(toNode);
  }

  public void traverseDepth(String root) {
    Node node = nodes.get(root);
    if (node == null) throw new IllegalArgumentException("node doesn't exists");
    Set<Node> visited = new HashSet<>();
    traverseDepth(node, visited);
  }

  private void traverseDepth(Node node, Set<Node> visited) {
    if (visited.contains(node)) return;

    System.out.println(node.label);
    visited.add(node);

    for (Node child: relationship.get(node)) {
      traverseDepth(child, visited);      
    }
  }

  public void traverseDepthIterative(String root) {

    Node node = nodes.get(root);
    if (node == null) throw new IllegalArgumentException("node doesn't exists");

    Stack<Node> nodeStack = new Stack<>();
    Set<Node> visited = new HashSet<>();
    nodeStack.push(node);

    while (!nodeStack.isEmpty()) {
      Node current = nodeStack.pop();
      System.out.println(current.label);
      visited.add(current);

      for( Node child: relationship.get(current) ) {
        if (!visited.contains(child)) nodeStack.push(child);
      }
    }

  }

  public void traverseBredth(String root) {
    Node node = nodes.get(root);
    if (node == null) throw new IllegalArgumentException("Invalid root given");

    Set<Node> visited = new HashSet<>();
    Queue<Node> queue = new ArrayDeque<>();

    queue.add(node);

    while(!queue.isEmpty()) {
      Node current = queue.poll();

      if (visited.contains(current)) continue;

      System.out.println(current);
      visited.add(current);

      for (Node neighbor: relationship.get(current)) {
        if (!visited.contains(neighbor)) queue.add(neighbor);
      }

    }

  }

  public List<String> topologicalSort() {
    Stack<Node> stack = new Stack<>();
    Set<Node> visited = new HashSet<>();

    for (String key: nodes.keySet()) {
      Node node = nodes.get(key);
      this.topologicalSort(node, stack, visited);
    }

    List<String> sorted = new ArrayList<>();
    while(!stack.isEmpty()) {
      Node node = stack.pop();
      sorted.add(node.label);
    }

    return sorted;
  }

  private void topologicalSort(Node node, Stack<Node> stack, Set<Node> visited) {
    if (visited.contains(node)) return;
    visited.add(node);

    for (Node neighbor: relationship.get(node)) {
      if (visited.contains(neighbor)) continue;
      topologicalSort(neighbor, stack, visited);
    }

    stack.push(node);
  }

  public boolean hasCycle() {
    Set<Node> all = new HashSet<>(nodes.values());
    Set<Node> visiting = new HashSet<>();
    Set<Node> visited = new HashSet<>();


    for (Node nodeItem: all) {
      return hasCycle(nodeItem, visiting, visited);
    }

    return false;
  }

  private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited) {
    if (visiting.contains(node)) return true;

    visiting.add(node);

    for (Node neighbor: relationship.get(node)) {
      return hasCycle(neighbor, visiting, visited);
    }

    visiting.remove(node);
    visited.add(node);

    return false;
  }


  public boolean hasCycleMosh() {
    Set<Node> all = new HashSet<>();
    all.addAll(nodes.values());

    Set<Node> visiting = new HashSet<>();
    Set<Node> visited = new HashSet<>();

    while(!all.isEmpty()) {
      Node node = all.iterator().next();
      if (hasCycleMosh(node, all, visiting, visited)) return true;
    }

    return false;
  }

  private boolean hasCycleMosh(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {

    all.remove(node);
    visiting.add(node);

    for (Node neighbor: relationship.get(node)) {

      if (visited.contains(neighbor)) continue;

      if (visiting.contains(neighbor)) return true;

      if (hasCycleMosh(neighbor, all, visiting, visited)) return true;
    }

    visiting.remove(node);
    visited.remove(node);

    return false;
  }

  public void print() {
    for (String key: nodes.keySet()) {
      Node node = nodes.get(key);

      List<Node> relations = relationship.get(node);
      System.out.println("[" + node + "] connected with: " + relations);
    }
  }
}