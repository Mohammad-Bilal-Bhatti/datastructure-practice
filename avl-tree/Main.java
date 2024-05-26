
public class Main {
  public static void main(String[] args) {

    AvlTree tree = new AvlTree();

    tree.insertv2(10);
    tree.insertv2(5);
    tree.insertv2(20);
    tree.insertv2(7);
    tree.insertv2(3);
    tree.insertv2(4);
    tree.insertv2(2);
    tree.insertv2(1);


    // tree.populateBalanceFactor();

    int heightTree = tree.height();
    System.out.println("The height of the tree is: " + heightTree);
  
  }
}