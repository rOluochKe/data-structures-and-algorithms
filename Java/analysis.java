import java.util.Arrays;

public static String repeat1(char c, int n) {
  String answer = "";
  for (int j = 0; j < n; j++)
    answer += c;
  return answer;
}

public static String repeat2(char c, int n) {
  StringBuilder sb = new StringBuilder();
  for (int j = 0; j < n; j++)
    sb.append(c);
  return sb.toString();
}

public static double arrayMax(double[] data) {
  int n = data.length;
  double currentMax = data[0];
  for (int j = 1; j < n; j++) {
    if (data[j] > currentMax)
      currentMax = data[j];
    return currentMax;
  }
}

public static boolean disjoint(int[] groupA, int[] groupB, int[] groupC) {
  for (int a : groupA)
    for (int b : groupB)
      for (int c : groupC)
        if ((a == b) && (b == c))
          return false;
  return true;
}

public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
  for (int a : groupA)
    for (int b : groupB)
      if (a == b)
        for (int c : groupC)
          if (a == c)
            return false;
  return true;
}

public static boolean unique1(int[] data) {
  int n = data.length;
  for (int j = 0; j < n - 1; j++)
    for (int k = j + 1; k < n; k++)
      if (data[j] == data[k])
        return false;
  return true;
}

public static boolean unique2(int[] data) {
  int n = data.length;
  int[] temp = Arrays.copyOf(data, n);
  Arrays.sort(temp);
  for (int j = 0; j < n - 1; j++)
    if (temp[j] == temp[j + 1])
      return false;
  return true;
}

public static double[] prefixAverage1(double[] x) {
  int n = x.length;
  double[] a = new double[n];
  for (int j = 0; j < n; j++) {
    double total = 0;
    for (int i = 0; i <= j; i++)
      total += x[i];
    a[j] = total / (j + 1);
  }
  return a;
}

public static double[] prefixAverage2(double[] x) {
  int n = x.length;
  double[] a = new double[n];
  double total = 0;
  for (int j = 0; j < n; j++) {
    total += x[j];
    a[j] = total / (j + 1);
  }
  return a;
}

public static int arrayFind(int[] data, int val) {
  int n = data.length;
  int j = 0;
  while (j < n) {
    if (data[j] == val)
      return j;
    j++;
  }
  return -1;
}