

public class DStack {

  private int initialSize;
  private int[] dstack;
  private int p1;
  private int p2;

  // Constructor.
  DStack() {
    int initialSize = 10;
    this.dstack = new int[initialSize];
    this.p1 = 0;
    this.p2 = initialSize - 1;
    this.initialSize = initialSize;
  }

  public void push1(int item) {
    if (p1 == p2) throw new IllegalStateException("stack 1 is full when inserting: " + item);
    dstack[p1++] = item;
  }

  public void push2(int item) {
    if (p2 == p1) throw new IllegalStateException("stack 2 is full when inserting: " + item);
    dstack[p2--] = item;
  }

  public int pop1() {
    if (p1 == 0) throw new IllegalStateException("stack 1 is empty");
    int item = dstack[p1 - 1];
    dstack[p1 - 1] = 0;
    --p1;
    return item;
  }

  public int pop2() {
    if (p2 == initialSize - 1) throw new IllegalStateException("stack 2 is empty");
    int item = dstack[p2 + 1];
    dstack[p2 + 1] = 0;
    ++p2;
    return item;
  }

  public boolean isEmpty1() {
    return p1 == 0;
  }

  public boolean isEmpty2() {
    return p2 == initialSize - 1;
  }

  public boolean isFull1() {
    return p1 == p2;
  }

  public boolean isFull2() {
    return p2 == p1;
  }

  public void print() {
    System.out.println("[");
    for (int i = 0; i < dstack.length; i++) {
      System.out.print(dstack[i]+ ", ");
    }
    System.out.println("]");
  }

}