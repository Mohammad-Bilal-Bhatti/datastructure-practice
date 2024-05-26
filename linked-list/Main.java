


public class Main {
  public static void main(String[] args) {

    LinkedList list = new LinkedList();

    list.addFirst(10);
    list.addFirst(20);
    list.addFirst(30);

    list.addLast(40);
    list.addLast(50);
    list.addLast(60);

    list.addFirst(70);

    list.print();

    // list.printMiddle();

    list.makeLoop();
    System.out.print("Has loop: " + list.hasLoop2());

    // int kth = 10;
    // System.out.println(kth + " Kth Element from last is: " + list.findKthFromEnd(kth));
    // list.reverse();

    // list.print();
    // System.out.println("Index of 10: " + list.indexOf(10));
    // System.out.println("Contains 30: " + list.contains(30));

    // list.deleteFirst();
    // System.out.println("After deleting first");
    // list.print();

    // list.deleteLast(); 
    // System.out.println("After deleting last");
    // list.print();



  }
}