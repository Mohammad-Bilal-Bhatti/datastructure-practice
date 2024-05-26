
public class Main {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    tree.insert(20);
    tree.insert(10);
    tree.insert(2);
    tree.insert(30);
    tree.insert(6);
    tree.insert(14);
    tree.insert(24);
    tree.insert(1);
    tree.insert(3);
    tree.insert(8);
    tree.insert(26);

    // 20,10,2,30,6,14,24,1,3,8,26

    BinaryTree tree2 = new BinaryTree();
    tree2.insert(20);
    tree2.insert(10);
    tree2.insert(2);
    tree2.insert(30);
    tree2.insert(6);
    tree2.insert(14);
    tree2.insert(24);
    tree2.insert(1);
    tree2.insert(3);
    tree2.insert(8);
    tree2.insert(26);
    tree2.insert(50);

    System.out.println("Are tree equals? " + tree.equals(tree2));


    // int findValue = 171;
    // System.out.println("Is " + findValue + " exists in tree ? " + tree.find(findValue));

    tree.traversePreorder();
    tree.traverseInorder();
    tree.traversePostorder();

    System.out.println("The height of the tree is: " + tree.height());
    System.out.println("The min of the tree is: " + tree.min());
    System.out.println("The minv2 of the tree is: " + tree.minv2());

    // tree.swapRoot();

    System.out.println("Is tree valid ? : " + tree.isBinarySearchTree());

    int distance = 3;
    System.out.println("The nodes distance at k=" + distance + " are: ");
    tree.printNodesAtDistanceK(distance);

    tree.levelOrderTraversal();

    System.out.println("Leaf Count are: " + tree.countLeafNodes());


    System.out.println("The size of the tree is: " + tree.size());


    System.out.println("The max value is: " + tree.max());
    System.out.println("The maxv2 value is: " + tree.maxv2());


    int item = 13;
    System.out.println("Do '" + item + "' exists in tree ? " + tree.exists(item));

    int searchItem = 6;
    System.out.println("The parent of item '" + searchItem + "' is: " + tree.findParent(searchItem));

    int item1 = 2;
    int item2 = 14;
    String result = tree.areSiblings(item1, item2) ? "Yes" : "No";
    System.out.println("Are '" + item1 + "' and '" + item2 + "' are sliblings of each other ? " + result);


    int candidate = 6;
    tree.printAncestors(candidate);
  }
}