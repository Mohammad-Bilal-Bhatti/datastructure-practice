
public class Main {
  public static void main(String[] args) {


    DStack dstack = new DStack();

    dstack.push1(10);
    dstack.push1(20);
    dstack.push1(30);
    dstack.push1(40);
    dstack.push1(50);

    dstack.pop1();
    dstack.pop1();


    dstack.push2(90);
    dstack.push2(80);
    dstack.push2(70);
    dstack.push2(60);
    // dstack.push2(50);

    dstack.print();

    System.out.println("is stack 1 full ? " + dstack.isFull1());
    System.out.println("is stack 2 full ? " + dstack.isFull2());

    System.out.println("is stack 1 empty ? " + dstack.isEmpty1());
    System.out.println("is stack 2 empty ? " + dstack.isEmpty2());



    // Stack stack = new Stack();

    // stack.push(10);
    // stack.push(20);
    // stack.push(30);
    // stack.push(40);
    // stack.push(50);

    // stack.pop();


    // stack.print();
    // System.out.println("is Empty ? " + stack.isEmpty());

    // System.out.println("The length is: " + stack.size());

  }
}