package Java;

public class EnglishRuler {

  public static void drawInterval(int c) {
    for (int i = 0; i < c; i++) {
      drawTicks(c - 1);
      System.out.println();
    }
    drawTicks(c);
  }

  private static void drawTicks(int ticks) {
    if (ticks > 0) {
      drawTicks(ticks - 1);
    }
    drawTick(ticks);
  }

  private static void drawTick(int ticks) {
    for (int i = 0; i < ticks; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    drawInterval(3); // Change the parameter to adjust the length of the English ruler
  }
}