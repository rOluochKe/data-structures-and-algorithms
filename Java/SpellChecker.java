package Java;

import java.util.*;

public class SpellChecker {
  private Set<String> lexicon;

  public SpellChecker(Set<String> lexicon) {
    this.lexicon = lexicon;
  }

  public List<String> check(String word) {
    List<String> suggestions = new ArrayList<>();

    // Check if the word is in the lexicon
    if (lexicon.contains(word)) {
      suggestions.add(word);
      return suggestions;
    }

    // Generate possible corrections based on common misspelling patterns
    suggestions.addAll(swappedChars(word));
    suggestions.addAll(insertedChars(word));
    suggestions.addAll(deletedChars(word));
    suggestions.addAll(replacedChars(word));
    suggestions.addAll(phoneticSubstitutions(word));

    // Remove duplicates from suggestions
    suggestions = new ArrayList<>(new HashSet<>(suggestions));

    return suggestions;
  }

  private List<String> swappedChars(String word) {
    List<String> suggestions = new ArrayList<>();
    for (int i = 0; i < word.length() - 1; i++) {
      char[] chars = word.toCharArray();
      char temp = chars[i];
      chars[i] = chars[i + 1];
      chars[i + 1] = temp;
      String swapped = String.valueOf(chars);
      if (lexicon.contains(swapped)) {
        suggestions.add(swapped);
      }
    }
    return suggestions;
  }

  private List<String> insertedChars(String word) {
    List<String> suggestions = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        String inserted = word.substring(0, i) + c + word.substring(i);
        if (lexicon.contains(inserted)) {
          suggestions.add(inserted);
        }
      }
    }
    return suggestions;
  }

  private List<String> deletedChars(String word) {
    List<String> suggestions = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      String deleted = word.substring(0, i) + word.substring(i + 1);
      if (lexicon.contains(deleted)) {
        suggestions.add(deleted);
      }
    }
    return suggestions;
  }

  private List<String> replacedChars(String word) {
    List<String> suggestions = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        String replaced = word.substring(0, i) + c + word.substring(i + 1);
        if (lexicon.contains(replaced)) {
          suggestions.add(replaced);
        }
      }
    }
    return suggestions;
  }

  private List<String> phoneticSubstitutions(String word) {
    // Implement phonetic substitutions (e.g., Soundex algorithm) for an extra
    // challenge
    // This requires a more complex algorithm to handle phonetic similarities
    return new ArrayList<>();
  }
}