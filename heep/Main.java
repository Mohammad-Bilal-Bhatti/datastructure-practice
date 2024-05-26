import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // (15, 10, 3, 8, 12, 9, 4, 1, 24)
    
    Heep heep = new Heep(20);

    // heep.insert(15);
    // heep.insert(10);
    // heep.insert(3);
    // heep.insert(8);
    // heep.insert(12);
    // heep.insert(9);
    // heep.insert(4);
    // heep.insert(1);
    // heep.insert(24);

    int[] numbers = {5, 3, 10, 1, 4, 2};
    int[] sorted = new int[numbers.length];

    for (int number: numbers) {
      heep.insert(number);
    }

    int ith = 0;
    while (!heep.isEmpty()) {
      sorted[ith++] = heep.remove();
    }
   
    System.out.println("The heep is: " + heep);
    System.out.println("The sorted array is: " + Arrays.toString(sorted));
    
    int[] numbers1 = {5,3,8,4,1,2};
    // int[] numbers1 = {3, 12, 4, 19, 5, 20, 42, 26};
    heepify2(numbers1);
    System.out.println("The Sorted array is: " + Arrays.toString(numbers1));


    int[] numbers3 = {8, 4, 2, 9, 3, 7};
    System.out.println("The kth largest element is: " + Main.findKthLargest(numbers3, 7));

  }

  public static void heepify(int[] array) {
    /* bubble it down until find its suitable place */
    int index = 0;

    while(index < array.length) {

      int parent = (index - 1) / 2;
      if (parent > -1 && array[index] > array[parent] ) {
        int temp = array[index];
        array[index] = array[parent];
        array[parent] = temp;
        index = parent;
      }
      else {
        index++;
      }

    }
  }

  public static void heepify2(int[] array) {
    /* bubble it down until find its suitable place */

    for (int index = 0; index < array.length; index++) {
      bubbleDown(array, index++);
    }

    // Optimization 1 - Iterate upto lastParent node (save some iterations for leaf nodes - because leaf nodes have no parent) - lastParent = (number_of_nodes / 2) - 1 
    // Optimization 2 - Loop in reverse order

    // int lastParentIndex = (array.length / 2) - 1;
    // for (int index = lastParentIndex; index >= 0; index--) {
    //   bubbleDown(array, index);
    // }

  }

  public static void swap(int[] array, int p1, int p2) {
    int temp = array[p1];
    array[p1] = array[p2];
    array[p2] = temp;
  }

  public static void bubbleDown(int[] array, int index) {
    int leftChildIndex = Main.findLeftChild(index);
    int rightChildIndex = Main.findRightChild(index);

    int currentValue = index < array.length ? array[index] : -1;

    if (currentValue == -1) return;

    int leftChildValue = leftChildIndex < array.length ? array[leftChildIndex]: -1;
    int rightChildValue = rightChildIndex < array.length ? array[rightChildIndex]: -1;

    if (leftChildValue == -1 && rightChildValue == -1) return;


    int maxValue = Math.max(leftChildValue, rightChildValue);
    int maxIndex = maxValue == leftChildValue ? leftChildIndex : rightChildIndex;

    if (maxValue > currentValue) {
      // swap and bubble down
      Main.swap(array, index, maxIndex);
      Main.bubbleDown(array, maxIndex);
    }

  }


  public static void bubbleUp(int[] array, int index) {
    if (index > array.length) return;

    int left_index = Main.findLeftChild(index);
    int right_index = Main.findRightChild(index);

    int left_value = left_index < array.length ? array[left_index] : -1;
    int right_value = right_index < array.length ? array[right_index]: -1;

    int max = Math.max(left_value, right_value);
    int maxIndex = max == left_value ? left_index : right_index;

    if (max != -1) {
        int temp = array[index];
        array[index] = array[maxIndex];
        array[maxIndex] = temp;

        bubbleUp(array, maxIndex);
    }

  }

  public static int findLeftChild(int index) {
    return (index * 2) + 1;
  }

  public static int findRightChild(int index) {
    return (index * 2) + 2;
  }

  public static int findKthLargest(int[] array, int kth) {

    if (kth < 0 || kth > array.length) throw new IllegalStateException("Illegal params provided");

    Heep heep = new Heep(array.length);
    for (int item : array) {
      heep.insert(item);
    }

    for (int i = 0; i < kth - 1; i++) {
      heep.remove();
    }

    return heep.max();
  }
}