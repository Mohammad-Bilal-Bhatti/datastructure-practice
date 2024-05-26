import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

  private class Node {
    int value;
    int count;
    Node right;
    Node left;

    Node(int value) {
      this.value = value;
    }

    boolean isLeaf() {
      return right == null && left == null;  
    }

    @Override
    public String toString() {
      return "Node=" + value;
    }

  }

  private Node root;

  /* Constructor */
  BinaryTree() {}

  public void swapRoot() {
    Node temp = root.left;
    root.left = root.right;
    root.right = temp;
  }

  public void insert(int value) {
    Node node = new Node(value);

    if (root == null) {
      root = node;
      return;
    }


    Node current = root;

    while (true) {
      if (value > current.value) {
        if (current.right == null) {
          current.right = node;
          break;
        }
        current = current.right;
      }

      if (value < current.value) {
        if (current.left == null) {
          current.left = node;
          break;
        }
        current = current.left;
      }

      if (value == current.value) {
        current.count++;
        break;
      }

    }
  }

  public boolean find(int value) {

    Node current = root;

    while(current != null) {

      if (value > current.value) {
        current = current.right;
      }
      else if (value < current.value) {
        current = current.left;
      }
      else {
        return true;
      }

    }

    return false;
  }

  public void traversePreorder() {
    /* [root, left, right] */
    System.out.print("Pre order: [");
    traversePreorder(root);
    System.out.println("]");
  }

  private void traversePreorder(Node n) {
    if (n != null) {
      System.out.print(n.value + ", ");
      traverseInorder(n.left);
      traverseInorder(n.right);
    }
  }

  public void traverseInorder() {
    /* [left, root, right] */
    System.out.print("In order: [");
    traverseInorder(root);
    System.out.println("]");

  }

  private void traverseInorder(Node n) {
    if (n != null) {
      traverseInorder(n.left);
      System.out.print(n.value + ", ");
      traverseInorder(n.right);
    }
  }

  public void traversePostorder() {
    /* [left, right, root] */
    System.out.print("Post order: [");
    traversePostorder(root);
    System.out.println("]");

  }

  private void traversePostorder(Node n) {
    if (n != null) {
      traversePostorder(n.left);
      traversePostorder(n.right);
      System.out.print(n.value + ", ");
    }
  }


  public int height() {
    return height(root);
  }

  private int height(Node n) {
    if (n == null) return -1;
    if (n.left == null && n.right == null) return 0;
    return 1 + Math.max(height(n.left), height(n.right));
  }

  public int min() {
    if (root == null) return -1;
    return min(root);
  }

  private int min(Node n) {
    if (n.left == null) return n.value;
    return min(n.left);
  }

  public int minv2() {
    if (root == null) return -1;
    return minv2(root);
  }

  private int minv2(Node n) {
    if (n.left == null || n.right == null) return n.value;
    int leftMin = minv2(n.left);
    int rightMin = minv2(n.right);
    return Math.min(Math.min(leftMin, rightMin), n.value);
  }

  public boolean equals(BinaryTree tree2) {
    return tree2.equals(root, tree2.root);
  }

  private boolean equals(Node first, Node second) {
    if (first == null && second == null) return true;
    if (first != null && second != null) 
      return first.value == second.value && equals(first.left, second.left) && equals(first.right, second.right);
    
    return false;
  }

  public boolean isBinarySearchTree() {
    if (root == null) return false;
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBinarySearchTree(Node n, int min, int max) {
    if (n == null) return true;

    if (n.value < min || n.value > max) return false;

    return isBinarySearchTree(n.left, min, n.value - 1) && isBinarySearchTree(n.right, n.value + 1, max);
  }

  public void printNodesAtDistanceK(int distance) {
    ArrayList<Node> nodes = new ArrayList<>();
    findNodesAtDistanceK(root, distance, nodes);
    for (Node node: nodes) {
      System.out.print(node.value + ", ");
    }
    System.out.println(); // print new line
  }

  private void findNodesAtDistanceK(Node root, int distance, List<Node> list) {
    if (distance == 0 && root != null) list.add(root);
    if (distance > 0 && root != null) {
      findNodesAtDistanceK(root.left, distance - 1, list);
      findNodesAtDistanceK(root.right, distance - 1, list);
    }
  }

  // also known as breadth order traversal
  public void levelOrderTraversal() {
    int treeHeight = this.height();

    for (int i = 0 ; i < treeHeight ; i++) {
      ArrayList<Node> nodes = new ArrayList<>();
      this.findNodesAtDistanceK(root, i, nodes);
      for (Node node: nodes) {
        System.out.print( node.value + ", ");
      }
    }
    System.out.println(); // new line
  }

  public int countLeafNodes() {
    return countLeafNodes(root);
  }

  private int countLeafNodes(Node root) {
    if (root == null) return 0;
    if (root.isLeaf()) return 1;
    return countLeafNodes(root.left) + countLeafNodes(root.right);
  }

  public int size() {
    return size(root);
  }
  
  private int size(Node root) {
    if (root == null) return 0;
    return 1 + size(root.right) + size(root.left); 
  }

  /* implement this method */
  public int max() {
    if (root == null) throw new IllegalStateException("Root is null");
    return this.max(root);
  }

  private int max(Node root) {
    if (root.left == null || root.right == null) return root.value;
    int leftMax = max(root.left);
    int rightMax = max(root.right);
      return Math.max(root.value, Math.max(leftMax, rightMax));
  }


  public int maxv2() {
    if (root == null) throw new IllegalStateException("Root is null");
    return maxv2(root);
  }

  private int maxv2(Node root) {
    if (root.right != null) return maxv2(root.right);
    return root.value;
  }

  /* implement this method using recursion */
  public boolean exists(int value) {    
    return this.exists(root, value);
  }

  private boolean exists(Node root, int value) {
    if (root == null) return false;
    if (root.value == value) return true;
    return exists(root.left, value) || exists(root.right, value);
  }

  /* implement this method */
  public boolean areSiblings(int value1, int value2) {
    try {
      Node p1 = this.findParent(root, value1);
      Node p2 = this.findParent(root, value2);    
      if (p1 != null && p2 != null && p1 == p2) return true;
    } catch (IllegalStateException e) {
      return false;
    }
    return false;
  }

  public int findParent(int value) {
    Node n = findParent(root, value);
    if (n == null) throw new IllegalStateException("Item not found");
    return n.value;
  }

  public Node findParent(Node node, int value) {
    Node current = node;
    Node parent = null;
    while (current != null) {
      if (current.value == value) {
        break;
      }
      else if (value > current.value) {
        parent = current;
        current = current.right;
      }
      else if (value < current.value) {
        parent = current;
        current = current.left;
      }
    }

    if (current != null && current.value == value) return parent;
    return null;
  }

  /* implement this method */
  public void printAncestors(int value) {
    List<Node> ancestors = getAncestors(value);
    if (ancestors.size() == 0) {
      System.out.println("No Ancestors found! of: " + value);
    }
    for (Node n : ancestors) {
      System.out.print(n.value + ", ");
    }
    System.out.println();
  }

  private List<Node> getAncestors(int value) {
    List<Node> ancestors = new ArrayList<>();

    try {

      Node parent = this.findParent(root, value);

      while(parent != null) {
        ancestors.add(parent);
        parent = this.findParent(root, parent.value);
      }


    } catch (IllegalStateException e) {
      return ancestors;
    }

    return ancestors;
  }

}