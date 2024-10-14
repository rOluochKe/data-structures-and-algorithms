package Java;

import java.util.*;

public class FavoritesListMTF {
  private List<Integer> favorites;

  public FavoritesListMTF() {
    favorites = new ArrayList<>();
  }

  public void access(int element) {
    if (favorites.contains(element)) {
      favorites.remove(Integer.valueOf(element));
    }
    favorites.add(0, element);
  }

  public List<Integer> getFavorites() {
    List<Integer> favoritesCopy = new ArrayList<>(favorites);
    favoritesCopy.sort(Collections.reverseOrder());
    return favoritesCopy;
  }

  public static void main(String[] args) {
    FavoritesListMTF favoritesList = new FavoritesListMTF();
    favoritesList.access(5);
    favoritesList.access(3);
    favoritesList.access(7);
    favoritesList.access(3);

    List<Integer> favoriteElements = favoritesList.getFavorites();
    for (Integer element : favoriteElements) {
      System.out.println(element);
    }
  }
}