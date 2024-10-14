package Java;

import java.util.Arrays;

public class HeapAnimation {

  public static void main(String[] args) {
    int[] heap = new int[10];
    int size = 0;

    // Insert elements into the heap
    insert(heap, size++, 5);
    insert(heap, size++, 3);
    insert(heap, size++, 8);
    insert(heap, size++, 2);
    insert(heap, size++, 6);
    insert(heap, size++, 1);

    System.out.println("Heap: " + Arrays.toString(heap));

    // Remove the root element
    int max = remove(heap, size--);
    System.out.println("Removed: " + max);
    System.out.println("Heap after removal: " + Arrays.toString(heap));
  }

  private static void insert(int[] heap, int size, int value) {
    heap[size] = value;
    upHeap(heap, size);
  }

  private static int remove(int[] heap, int size) {
    int max = heap[0];
    heap[0] = heap[size - 1];
    downHeap(heap, size - 1);
    return max;
  }

  private static void upHeap(int[] heap, int index) {
    while (index > 0) {
      int parent = (index - 1) / 2;
      if (heap[parent] < heap[index]) {
        // Swap parent and child
        int temp = heap[parent];
        heap[parent] = heap[index];
        heap[index] = temp;
        index = parent;
      } else {
        break;
      }
    }
  }

  private static void downHeap(int[] heap, int size) {
    int index = 0;
    while (index < size / 2) {
      int leftChild = 2 * index + 1;
      int rightChild = 2 * index + 2;
      int largerChild;

      if (rightChild < size && heap[rightChild] > heap[leftChild]) {
        largerChild = rightChild;
      } else {
        largerChild = leftChild;
      }

      if (heap[index] >= heap[largerChild]) {
        break;
      }

      // Swap parent and larger child
      int temp = heap[index];
      heap[index] = heap[largerChild];
      heap[largerChild] = temp;

      index = largerChild;
    }
  }
}