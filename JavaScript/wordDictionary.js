class Dictionary {
  constructor() {
    this.words = {};
  }

  countWords(text) {
    const words = text.toLowerCase().match(/\b\w+\b/g);
    if (words) {
      words.forEach((word) => {
        this.words[word] = this.words[word] ? this.words[word] + 1 : 1;
      });
    }
  }

  displayWordFrequenciesSorted() {
    Object.entries(this.words)
      .sort((a, b) => a[0].localeCompare(b[0]))
      .forEach(([word, count]) => {
        console.log(`${word}: ${count}`);
      });
  }
}

// Test the Dictionary class with sorted word frequencies
const text = "the brown fox jumped over the blue fox";
const wordDictionary = new Dictionary();
wordDictionary.countWords(text);
wordDictionary.displayWordFrequenciesSorted();
