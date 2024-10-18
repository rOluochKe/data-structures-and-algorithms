const fs = require("fs");

function WordCounter() {
  this.wordMap = new Map();
}

WordCounter.prototype.processFile = function (filename) {
  try {
    const data = fs.readFileSync(filename, "utf8");
    const words = data.split(/\s+/);

    words.forEach((word) => {
      const trimmedWord = word.trim();
      if (trimmedWord !== "") {
        const count = this.wordMap.has(trimmedWord)
          ? this.wordMap.get(trimmedWord) + 1
          : 1;
        this.wordMap.set(trimmedWord, count);
      }
    });
  } catch (err) {
    console.error("Error reading file:", err);
  }
};

WordCounter.prototype.printWordCounts = function () {
  this.wordMap.forEach((count, word) => {
    console.log(`${word}: ${count}`);
  });
};

// Read words from file and count occurrences
var wordCounter = new WordCounter();
wordCounter.processFile("JavaScript/textfile.txt");
wordCounter.printWordCounts();
