const fs = require("fs");

function HashTable(size) {
  this.table = new Array(size);
}

function Node(key, data) {
  this.key = key;
  this.data = data;
  this.next = null;
}

HashTable.prototype.put = function (key, data) {
  var pos = this.betterHash(key);
  if (this.table[pos] === undefined) {
    this.table[pos] = new Node(key, data);
  } else {
    var current = this.table[pos];
    while (current.next !== null) {
      current = current.next;
    }
    current.next = new Node(key, data);
  }
};

HashTable.prototype.get = function (key) {
  var pos = this.betterHash(key);
  var current = this.table[pos];
  while (current !== null) {
    if (current.key === key) {
      return current.data;
    }
    current = current.next;
  }
  return null;
};

HashTable.prototype.betterHash = function (string) {
  const H = 37;
  var total = 0;
  for (var i = 0; i < string.length; i++) {
    total += H * total + string.charCodeAt(i);
  }
  total = total % this.table.length;
  if (total < 0) {
    total += this.table.length - 1;
  }
  return total;
};

function readDictionaryFromFile(filename) {
  try {
    const data = fs.readFileSync(filename, "utf8");
    return data.split("\n");
  } catch (err) {
    console.error("Error reading file:", err);
    return [];
  }
}

// Read words and definitions from file
var dictionary = new HashTable(137);
var data = readDictionaryFromFile("JavaScript/dictionary.txt");

if (data.length > 0) {
  data.forEach(function (entry) {
    var parts = entry.split(",");
    var word = parts[0].trim();
    var definition = parts[1] ? parts[1].trim() : "No definition found";
    dictionary.put(word, definition);
  });

  // Allow user to lookup definitions
  var readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  readline.question("Enter a word to get its definition: ", function (word) {
    var definition = dictionary.get(word);
    if (definition) {
      console.log("Definition: " + definition);
    } else {
      console.log("Definition not found.");
    }
    readline.close();
  });
} else {
  console.log("No data found in the file.");
}
