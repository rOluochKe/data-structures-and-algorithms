import java.io.File;

public static int factorial(int n) throws IllegalArgumentException {
  if (n < 0)
    throw new IllegalArgumentException();
  else if (n == 0)
    return 1;
  else
    return n * factorial(n - 1);
}

public static long diskUsage(File root) {
  long total = root.length();
  if (root.isDirectory()) {
    for (String childname : root.list()) {
      File child = new File(root, childname);
      total += diskUsage(child);
    }
  }
  System.out.println(total + "\t" + root);
  return total;
}

public static int linearSum(int[] data, int n) {
  if (n == 0)
    return 0;
  else
    return linearSum(data, n - 1) + data[n - 1];
}

public static void reverseArray(int[] data, int low, int high) {
  if (low < high) {
    int temp = data[low];
    data[low] = data[high];
    data[high] = temp;
    reverseArray(data, low + 1, high - 1);
  }
}

public static double power(double x, int n) {
  if (n == 0)
    return 1;
  else
    return x * power(x, n - 1);
}

public static int binarySum(int[] data, int low, int high) {
  if (low > high)
    return 0;
  else if (low == high)
    return data[low];
  else {
    int mid = (low + high) / 2;
    return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
  }
}

public static boolean unique3(int[] data, int low, int high) {
  if (low >= high)
    return true;
  else if (!unique3(data, low, high - 1))
    return false;
  else if (!unique3(data, low + 1, high))
    return false;
  else
    return (data[low] != data[high]);
}

public static long[] fibonacciGood(int n) {
  if (n <= 1) {
    long[] answer = { n, 0 };
    return answer;
  } else {
    long[] temp = fibonacciGood(n - 1);
    long[] answer = { temp[0], temp[1], temp[0] };
    return answer;
  }
}

public static boolean binarySearchIterative(int[] data, int target) {
  int low = 0;
  int high = data.length - 1;
  while (low <= high) {
    int mid = (low + high) / 2;
    if (target == data[mid])
      return true;
    else if (target < data[mid])
      high = mid - 1;
    else
      low = mid + 1;
  }
  return false;
}

public static void reverseIterative(int[] data) {
  int low = 0, high = data.length - 1;
  while (low < high) {
    int temp = data[low];
    data[low++] = data[high];
    data[high--] = temp;
  }
}