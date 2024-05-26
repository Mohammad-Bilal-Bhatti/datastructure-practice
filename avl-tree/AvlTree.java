
public class AvlTree {
  private class AvlNode {
    int value;
    int balanceFactor;
    int height;

    AvlNode right;
    AvlNode left;

    AvlNode(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "AVLNode(value="+ this.value+")";
    }

  }

  AvlNode root;

  AvlTree() {}

  void insert(int value) {

    if (root == null) {
      AvlNode node = new AvlNode(value);
      root = node;
      return;
    }

    this.insert(root, value);
  }

  private void insert(AvlNode root, int value) {
    if (value == root.value) {
      throw new IllegalStateException("can not insert same value");
    }
    else if (value > root.value) {
      if (root.right == null) {
        AvlNode node = new AvlNode(value);
        root.right = node;
        return;
      }
      insert(root.right, value);
    }
    else if (value < root.value) {
      if (root.left == null) {
        AvlNode node = new AvlNode(value);
        root.left = node;
        return;
      }
      insert(root.left, value);
    }
  }

  void insertv2(int value) {
    root = insertv2(root, value);
  }

  private AvlNode insertv2(AvlNode root, int value) {
    if (root == null) return new AvlNode(value);
    if (value > root.value) root.right = insertv2(root.right, value);
    if (value < root.value) root.left = insertv2(root.left, value);
 
    setHeight(root);

    return balance(root);
   }

  private AvlNode balance(AvlNode root) {
    if (isLeftHeavy(root)) {
      if ( balanceFactor(root.left) < 0 ) 
        root.left = rotateLeft(root.left);
      root = rotateRight(root);
    }
    if (isRightHeavy(root)) {
      if (balanceFactor(root.right) > 0)
        root.right = rotateRight(root.right);      
      root = rotateLeft(root);
    }

    return root;
  }

  private boolean isLeftHeavy(AvlNode root) {
    return balanceFactor(root) > 1;
  }

  private boolean isRightHeavy(AvlNode root) {
    return balanceFactor(root) < -1;
  }


  private void setHeight(AvlNode node) {
    node.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  private int balanceFactor(AvlNode node) {
    if (node == null) return 0;    
    return getHeight(node.left) - getHeight(node.right);
  }
   
  private int getHeight(AvlNode node) {
    return node == null ? -1 : node.height;
  }


  private AvlNode rotateLeft(AvlNode root) {
    AvlNode newRoot = root.right;
    root.right = newRoot.left;
    newRoot.left = root;

    /* recalculate height of root and new root */
    setHeight(root);
    setHeight(newRoot);

    return newRoot;
  }

  private AvlNode rotateRight(AvlNode root) {
    AvlNode newRoot = root.left;
    root.left = newRoot.right;
    newRoot.right = root;

    /* recalculate height of root and new root */
    setHeight(root);
    setHeight(newRoot);

    return newRoot;
  }

  int height() {
    return this.height(root, 0);
  }

  private int height(AvlNode node, int height) {

    if (node == null) return height;
    if (node.right == null && node.left == null) return height;

    int rightTreeHeight = this.height(node.right, height + 1);
    int leftTreeHeight = this.height(node.left, height + 1);

    return Math.max(rightTreeHeight, leftTreeHeight);
  }


  void populateBalanceFactor() {
    populateBalanceFactor(root);
  }

  private void populateBalanceFactor(AvlNode node) {
    if (node == null) return;

    int heightLeft = this.height(node.left, 0);
    int heightRight = this.height(node.right, 0);

    populateBalanceFactor(node.left);
    populateBalanceFactor(node.right);


    node.balanceFactor = Math.abs(heightRight - heightLeft);
  }

}
