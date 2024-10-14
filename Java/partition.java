package Java;

public static void quickSort(int[] arr, int low, int high) {
  Stack<Integer> stack = new Stack<>();
  stack.push(low);
  stack.push(high);

  while (!stack.isEmpty()) {
    high = stack.pop();
    low = stack.pop();

    int pivotIndex = partition(arr, low, high);

    if (pivotIndex - 1 > low) {
      stack.push(low);
      stack.push(pivotIndex - 1);
    }
    if (pivotIndex + 1 < high) {
      stack.push(pivotIndex + 1);
      stack.push(high);
    }
  }
}

public static int partition(int[] arr, int low, int high) {
  int pivot = arr[high];
  int i = low - 1;

  for (int j = low; j < high; j++) {
    if (arr[j] < pivot) {
      i++;
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  int temp = arr[i + 1];
  arr[i + 1] = arr[high];
  arr[high] = temp;

  return i + 1;
}