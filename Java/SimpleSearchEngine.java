package Java;

import java.util.*;

public class SimpleSearchEngine {
  private Map<String, Set<String>> index = new HashMap<>();

  public void indexPage(String pageName, String content) {
    String[] words = content.split("\\s+");
    Set<String> indexedWords = new HashSet<>();

    for (String word : words) {
      // Exclude stop words
      if (!isStopWord(word)) {
        indexedWords.add(word.toLowerCase());
      }
    }

    for (String word : indexedWords) {
      if (!index.containsKey(word)) {
        index.put(word, new HashSet<>());
      }
      index.get(word).add(pageName);
    }
  }

  public Set<String> search(String query) {
    Set<String> result = new HashSet<>();
    String[] queryWords = query.split("\\s+");

    for (String word : queryWords) {
      if (index.containsKey(word.toLowerCase())) {
        result.addAll(index.get(word.toLowerCase()));
      }
    }

    return result;
  }

  private boolean isStopWord(String word) {
    // Define your list of stop words here
    String[] stopWords = { "the", "and", "of", "a", "to", "in", "on" };

    for (String stopWord : stopWords) {
      if (stopWord.equalsIgnoreCase(word)) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    SimpleSearchEngine searchEngine = new SimpleSearchEngine();

    // Index pages of the website
    searchEngine.indexPage("page1", "This is a sample page about Java programming.");
    searchEngine.indexPage("page2", "Java is a popular programming language.");
    searchEngine.indexPage("page3", "Python is another programming language used for data science.");

    // Search for a query
    Set<String> searchResult = searchEngine.search("Java programming language");

    // Display search results
    if (searchResult.isEmpty()) {
      System.out.println("No results found.");
    } else {
      System.out.println("Search results:");
      for (String page : searchResult) {
        System.out.println("- " + page);
      }
    }
  }
}