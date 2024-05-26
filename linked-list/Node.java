
public class Node {
  
  private int value;
  private Node next;

  Node(int value) {
    this.value = value;
    this.next = null;
  }

  Node(int value, Node next) {
    this.value = value;
    this.next = next;
  }

  public Node next() {
    return this.next;
  }
  
  public int value() {
    return this.value;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setValue(int value) {
    this.value = value;
  }

}