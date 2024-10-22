const fs = require("fs");

// Function to perform binary search
function binSearch(arr, data) {
  let upperBound = arr.length - 1;
  let lowerBound = 0;

  while (lowerBound <= upperBound) {
    let mid = Math.floor((upperBound + lowerBound) / 2);
    if (arr[mid] < data) {
      lowerBound = mid + 1;
    } else if (arr[mid] > data) {
      upperBound = mid - 1;
    } else {
      return mid; // Found the item
    }
  }
  return -1; // Item not found
}

// Function to perform insertion sort
function insertionSort(arr) {
  let temp, inner;
  for (let outer = 1; outer < arr.length; outer++) {
    temp = arr[outer];
    inner = outer;

    while (inner > 0 && arr[inner - 1] >= temp) {
      arr[inner] = arr[inner - 1];
      inner--;
    }
    arr[inner] = temp;
  }
}

// Read words from the file
fs.readFile("JavaScript/words.txt", "utf8", (err, data) => {
  if (err) {
    console.error("Error reading the file:", err);
    return;
  }

  // Split the file content into words
  const words = data.split(/\s+/); // Split on whitespace

  // Sort the words using insertion sort
  insertionSort(words);

  const word = "rhetoric"; // The word to search for
  const start = new Date().getTime(); // Start time
  const position = binSearch(words, word); // Perform the search
  const stop = new Date().getTime(); // Stop time
  const elapsed = stop - start; // Calculate elapsed time

  // Output the result
  if (position >= 0) {
    console.log("Found " + word + " at position " + position + ".");
    console.log("Binary search took " + elapsed + " milliseconds.");
  } else {
    console.log(word + " is not in the file.");
  }
});
