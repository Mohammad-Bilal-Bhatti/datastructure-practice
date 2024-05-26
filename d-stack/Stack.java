
public class Stack {

  private int[] stack;
  private int top;

  /* Constructor */
  Stack() {
    this.top = 0;
    this.stack = new int[4];
  }

  public void push(int item) {
    if (top == stack.length - 1) this.grow();
    this.stack[top++] = item;
  }

  public int pop() {
    if (top == 0) throw new IllegalArgumentException();
    int item = this.stack[--top];
    if (top == stack.length / 2) this.shrink();
    return item;
  }

  public int peek() {
    return this.stack[top - 1];
  }

  public boolean isEmpty() {
    return this.top == 0;
  }

  public void print() {
    System.out.print("[");
    for (int i = 0; i < this.top; i++) {
      System.out.print(this.stack[i] + ", ");
    }
    System.out.println("]");
  }

  private void grow() {
    int[] extended = new int[stack.length * 2];
    for (int i = 0; i < stack.length; i++) {
      extended[i] = stack[i];
    }
    this.stack = extended;
  }

  private void shrink() {
    int[] shrinked = new int[stack.length / 2];
    for (int i = 0; i < stack.length / 2; i++) {
      shrinked[i] = stack[i];
    }
    this.stack = shrinked;
  }

  public int size() {
    return this.stack.length;
  }

}