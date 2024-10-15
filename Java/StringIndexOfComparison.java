package Java;

public class StringIndexOfComparison {
  public static void main(String[] args) {
    String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    String pattern = "ipsum";

    long startTime;
    long endTime;

    // Test and measure indexOf method
    startTime = System.nanoTime();
    int indexOfResult = text.indexOf(pattern);
    endTime = System.nanoTime();
    long indexOfTime = endTime - startTime;

    System.out.println("indexOf method result: " + indexOfResult);
    System.out.println("indexOf method execution time: " + indexOfTime + " nanoseconds");

    // Test and measure pattern-matching algorithms
    startTime = System.nanoTime();
    int bruteForceResult = BruteForce.bruteForce(text, pattern);
    endTime = System.nanoTime();
    long bruteForceTime = endTime - startTime;

    startTime = System.nanoTime();
    int kmpResult = KMP.kmpSearch(text, pattern);
    endTime = System.nanoTime();
    long kmpTime = endTime - startTime;

    startTime = System.nanoTime();
    int boyerMooreResult = BoyerMoore.boyerMoore(text, pattern);
    endTime = System.nanoTime();
    long boyerMooreTime = endTime - startTime;

    System.out.println("Brute-Force algorithm result: " + bruteForceResult);
    System.out.println("Brute-Force algorithm execution time: " + bruteForceTime + " nanoseconds");

    System.out.println("KMP algorithm result: " + kmpResult);
    System.out.println("KMP algorithm execution time: " + kmpTime + " nanoseconds");

    System.out.println("Boyer-Moore algorithm result: " + boyerMooreResult);
    System.out.println("Boyer-Moore algorithm execution time: " + boyerMooreTime + " nanoseconds");
  }
}