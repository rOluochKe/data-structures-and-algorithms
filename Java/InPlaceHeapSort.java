package Java;

public class InPlaceHeapSort {
  public void heapify(int[] arr, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest]) {
      largest = l;
    }

    if (r < n && arr[r] > arr[largest]) {
      largest = r;
    }

    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, n, largest);
    }
  }

  public void heapSort(int[] arr) {
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      swap(arr, 0, i);
      heapify(arr, i, 0);
    }
  }

  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = { 12, 11, 13, 5, 6, 7 };
    InPlaceHeapSort heapSort = new InPlaceHeapSort();
    heapSort.heapSort(arr);

    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}