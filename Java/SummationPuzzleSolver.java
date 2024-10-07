package Java;

import java.util.Arrays;

public class SummationPuzzleSolver {

  public static boolean solvePuzzle(int[] numbers, int target) {
    return solve(numbers, target, 0, 0);
  }

  private static boolean solve(int[] numbers, int target, int index, int sum) {
    if (index == numbers.length) {
      return sum == target;
    }

    return solve(numbers, target, index + 1, sum + numbers[index]) ||
        solve(numbers, target, index + 1, sum - numbers[index]);
  }

  public static void main(String[] args) {
    int[] puzzle1 = { 1, 3, 4, 6 };
    int target1 = 8;
    System.out.println("Puzzle 1 solution: " + solvePuzzle(puzzle1, target1));

    int[] puzzle2 = { 3, 1, 3, 7 };
    int target2 = 6;
    System.out.println("Puzzle 2 solution: " + solvePuzzle(puzzle2, target2));

    int[] puzzle3 = { 3, 4, 6, 8, 10 };
    int target3 = 28;
    System.out.println("Puzzle 3 solution: " + solvePuzzle(puzzle3, target3));
  }
}