import java.util.Arrays;

public class Heep {
  
  private int[] heep;
  private int nextIndex;

  Heep(int size) {
    heep = new int[size];
    nextIndex = 0;
  }

  void insert(int value) {
    heep[nextIndex] = value;


    int parentIndex = getParent(nextIndex);
    if (parentIndex > -1) {
      if (heep[nextIndex] > heep[parentIndex]) bubbleUp(nextIndex);
    } 

    nextIndex++;
  }

  private int getParent(int nextIndex) {
    return nextIndex % 2 == 0 ? (nextIndex - 2) / 2 : (nextIndex - 1) / 2; // Implementation A
  }

  private void bubbleUp(int childIndex) {

    int parentIndex = getParent(childIndex);

    if (parentIndex < 0) return;
    if (heep[childIndex] < heep[parentIndex]) return; /* stop condition */

    // swapping
    int temp = heep[parentIndex];
    heep[parentIndex] = heep[childIndex];
    heep[childIndex] = temp;

    bubbleUp(parentIndex);
  }

  int remove() {
    int itemRemoved = heep[0];
    heep[0] = heep[nextIndex - 1];
    heep[nextIndex -1] = 0;
    --nextIndex;

    bubbleDown(0);
    return itemRemoved;
  }

  private void bubbleDown(int parentIndex) {
    int rightChildIndex = getRightChildIndex(parentIndex);
    int leftChildIndex = getLeftChildIndex(parentIndex);

    if (leftChildIndex >= nextIndex) return;
    if (rightChildIndex >= nextIndex) return;

    int leftValue = heep[leftChildIndex];
    int rightValue = heep[rightChildIndex];

    int max = Math.max(leftValue, rightValue);

    int maxIndex = max == leftValue ? leftChildIndex : rightChildIndex;

    int temp = heep[maxIndex];
    heep[maxIndex] = heep[parentIndex];
    heep[parentIndex] = temp;

    bubbleDown(maxIndex);
  }

  private int getRightChildIndex(int parentIndex) {
    return parentIndex * 2 + 1;
  }

  private int getLeftChildIndex(int parentIndex) {
    return parentIndex * 2 + 2;
  }

  public boolean isFull() {
    return nextIndex == heep.length;
  }

  public boolean isEmpty() {
    return nextIndex == 0;
  }

  public int max() {
    if (isEmpty()) throw new IllegalStateException("Heep is emtpy");
    return heep[0];
  }

  @Override
  public String toString() {
    return "[Heep]" + Arrays.toString(heep);
  }
}
