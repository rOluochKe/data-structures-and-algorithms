package Java;

public class Matrix {
  public static int[][] add(int[][] matrix1, int[][] matrix2) {
    int rows = matrix1.length;
    int cols = matrix1[0].length;
    int[][] result = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[i][j] = matrix1[i][j] + matrix2[i][j];
      }
    }

    return result;
  }

  public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
    int rows1 = matrix1.length;
    int cols1 = matrix1[0].length;
    int cols2 = matrix2[0].length;
    int[][] result = new int[rows1][cols2];

    for (int i = 0; i < rows1; i++) {
      for (int j = 0; j < cols2; j++) {
        for (int k = 0; k < cols1; k++) {
          result[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }

    return result;
  }
}