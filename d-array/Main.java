public class Main {
  public static void main(String[] args) {

    /* hypothetical store that store list of numbers */
    Array store = new Array(3);

    /* Adding item to array */
    store.insert(10);
    store.insert(20);
    store.insert(30);
    store.insert(40);
    store.insert(50);

    /* Removing item at index */
    store.removeAt(0);

    int element = 30;
    /* find the index of the element */
    int index = store.indexOf(element);

    System.out.println("The index of '" + element + "' element is: " + index);

    /* Print array */
    store.print();
  }
}