
public class Array {
  private int[] list;
  private int next;

  /* Constructor */
  Array(int size) {
    this.list = new int[size];
    this.next = 0;
  }

  public void insert(int item) {
    if (next > list.length - 1) this.grow();
    this.list[next++] = item;
  }

  public void removeAt(int index) {
    if (index < 0 || index > this.next) throw new IllegalArgumentException();
    for (int i = index; i < this.next; i++) {
      this.list[i] = this.list[i + 1];
    }
    if (this.next > 0) {
      this.next--; 
    }
  }

  public void print() {
    System.out.print("[");
    for (int i = 0; i < this.next; i++) {
      System.out.print(list[i] + ", ");
    }
    System.out.println("]");
  }

  public int indexOf(int item) {
    for (int i = 0; i < next; i++ ){
      if (this.list[i] == item) return i;
    }
    return -1;
  }

  private void grow() {
    int[] newList = new int[this.list.length * 2];
    /* copy old list items to new list items */
    for (int i = 0; i < this.list.length; i++) {
      newList[i] = list[i];
    }

    this.list = newList;
  }

}