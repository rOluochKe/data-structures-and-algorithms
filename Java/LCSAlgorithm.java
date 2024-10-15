package Java;

public class LCSAlgorithm {
  public static String findLCS(String str1, String str2) {
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];

    for (int i = 1; i <= str1.length(); i++) {
      for (int j = 1; j <= str2.length(); j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    int i = str1.length();
    int j = str2.length();
    StringBuilder lcs = new StringBuilder();

    while (i > 0 && j > 0) {
      if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
        lcs.insert(0, str1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    return lcs.toString();
  }

  public static void main(String[] args) {
    String dna1 = "AGGTAB";
    String dna2 = "GXTXAYB";

    String lcs = findLCS(dna1, dna2);
    System.out.println("Longest Common Subsequence: " + lcs);
  }
}