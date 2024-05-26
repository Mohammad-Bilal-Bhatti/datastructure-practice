
public class LinkedList {
  private Node first;
  private Node last;

  /* Empty constructor */
  LinkedList() {
    this.first = null;
    this.last = null;
  }

  // Add first
  public void addFirst(int value) {
    Node node = new Node(value, this.first);
    this.first = node;
    if (this.last == null) this.last = node;
  }

  // Add last
  public void addLast(int value) {
    Node node = new Node(value);
    this.last.setNext(node);
    this.last = node;
    if (this.first == null) this.first = node;
  }

  // Delete first
  public void deleteFirst() {
    if (this.first == null) return; /* instead throw error */
    Node firstNode = this.first;
    Node nextNode = firstNode.next();
    this.first = nextNode;
    firstNode.setNext(null);
  }

  // Delete last
  public void deleteLast() {
    Node node = this.first;
    Node nodeBeforeLastNode = null;
    while (node != this.last) {
      nodeBeforeLastNode = node;
      node = node.next();
    }
    if (nodeBeforeLastNode == null) return; /* instead throw error */ 
    nodeBeforeLastNode.setNext(null);
    this.last = nodeBeforeLastNode;
  }

  // Contains
  public boolean contains(int value) {
    Node n = this.first;
    while (n != null) {
      if (n.value() == value) return true;
      n = n.next();
    }
    return false;
  }

  // Index of
  public int indexOf(int value) {
    Node n = this.first;
    int index = 0;
    while (n != null) {
      if (n.value() == value) return index;
      index++;
      n = n.next();
    }
    return -1;
  }

  // Reverse linked list
  public void reverse() {

    Node lastAddedNode = new Node(this.first.value());
    this.last = lastAddedNode;

    Node n = this.first.next();
    while (n != null) {

      Node newNode = new Node(n.value(), lastAddedNode);
      lastAddedNode = newNode;

      n = n.next();
    }


    this.first = lastAddedNode;
  }

  public int findKthFromEnd(int kth) {

    if (kth == 1) return this.last.value();

    Node pt1 = this.first;
    for(int i = 0; i < kth; i++) {
      if (pt1 == null) throw new IllegalArgumentException("kth is too large"); 
      pt1 = pt1.next();
    }

    Node pt2 = this.first;

    while(pt1 != null) {
      pt1 = pt1.next();
      pt2 = pt2.next();
    }

    return pt2.value();
  }

  public void printMiddle() {

    Node pt1 = this.first;
    Node pt2 = this.first.next();
    boolean isEven = false;

    while (pt2 != null) {
      /* move pt1 one step ahead */
      pt1 = pt1.next(); 

      /* move pt2 two step ahead */
      pt2 = pt2.next();
      if (pt2 != null) pt2 = pt2.next();

      /* event length */
      if (pt2 == this.last) {
        isEven = true;
        break; /* break the loop */
      }

    }

    if (isEven) System.out.println( "Middle: " + pt1.value() + " and " + pt1.next().value());
    if (!isEven) System.out.println("Middle: " + pt1.value());
  }

  public void makeLoop() {
    Node randomNode = this.first.next();
    this.last.setNext(randomNode);
  }

  public boolean hasLoop() {
    Node n = this.first;

    int visit = 0;
    Node randomNode = this.first.next().next();
    while(n != null) {
      if (n == randomNode) visit++;

      /* at any point in time if visit is more than 2 that means we have a loop */
      if (visit > 2) return true;

      n = n.next();
    }
    return false;
  }

  public boolean hasLoop2() {
    Node slowpt = this.first;
    Node fastpt = this.first;

    while (slowpt != null) {
      fastpt = fastpt.next().next();
      slowpt = slowpt.next();

      if (fastpt == slowpt) return true;
    }

    return false;
  }

  // Print 
  public void print() {
    Node n = this.first;
    System.out.print("[");
    while (n != null) {   
      System.out.print(n.value() + ", ");
      n = n.next();
    }
    System.out.println("]");
  }
  
}