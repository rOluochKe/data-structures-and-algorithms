public static int findBrute(char[] text, char[] pattern) {
  int n = text.length;
  int m = pattern.length;
  for (int i = 0; i <= n - m; i++) {
    int k = 0;
    while (k < m && text[i + k] == pattern[k])
      k++;
    if (k == m)
      return i;
  }
  return -1;
}

public static int findBoyerMoore(char[] text, char[] pattern) {
  int n = text.length;
  int m = pattern.length;
  if (m == 0)
    return 0;
  Map<Character, Integer> last = new HashMap<>();
  for (int i = 0; i < n; i++)
    last.put(text[i], -1);
  for (int k = 0; k < m; k++)
    last.put(pattern[k], k);
  int i = m - 1;
  int k = m - 1;
  while (i < n) {
    if (text[i] == pattern[k]) {
      if (k == 0)
        return i;
      i--;
      k--;
    } else {
      i += m - Math.min(k, 1 + last.get(text[i]));
      k = m - 1;
    }
  }
  return -1;
}

public static int findKMP(char[] text, char[] pattern) {
  int n = text.length;
  int m = pattern.length;
  if (m == 0)
    return 0;
  int[] fail = computeKMPFail(pattern);
  int j = 0;
  int k = 0;
  while (j < n) {
    if (text[j] == pattern[k]) {
      if (k == m - 1)
        return j - m + 1;
      j++;
      k++;
    } else if (k > 0)
      return fail[k - 1];
    else
      j++;
  }
  return -1;
}

public static int[] computeKMPFail(char[] pattern) {
  int m = pattern.length;
  int[] fail = new int[m];
  int j = 1;
  int k = 0;
  while (j < m) {
    if (pattern[j] == pattern[k]) {
      fail[j] = k + 1;
      j++;
      k++;
    } else if (k > 0)
      k = fail[k - 1];
    else
      j++;
  }
  return fail;
}

public static int[][] matrixChain(int[] d) {
  int n = d.length - 1;
  int[][] N = new int[n][n];
  for (int b = 1; b < n; b++) {
    for (int i = 0; i < n - b; i++) {
      int j = i + b;
      N[i][j] = Integer.MAX_VALUE;
      for (int k = i; k < j; k++) {
        N[i][j] = Math.min(N[i][j], N[i][k] + N[k + 1][j] + d[i] * d[k + 1] * d[j + 1]);
      }
    }
  }
  return N;
}

public static int[][] LCS(char[] X, char[] Y) {
  int n = X.length;
  int m = Y.length;
  int[][] L = new int[n + 1][m + 1];
  for (int j = 0; j < n; j++)
    for (int k = 0; k < m; k++)
      if (X[j] == Y[k])
        L[j + 1][k + 1] = L[j][k] + 1;
      else
        L[j + 1][k + 1] = Math.max(L[j][k + 1], L[j + 1][k]);
  return L;
}

public static char[] reconstructLCS(char[] X, char[] Y, int[][] L) {
  int i = X.length;
  int j = Y.length;
  int k = L[i][j];
  char[] solution = new char[k];
  while (i > 0 && j > 0) {
    if (X[i - 1] == Y[j - 1]) {
      solution[--k] = X[i - 1];
      i--;
      j--;
    } else if (L[i - 1][j] > L[i][j - 1])
      i--;
    else
      j--;
  }
  return solution;
}