const fs = require("fs");

// Function to perform sequential search
function seqSearch(arr, data) {
  for (let i = 0; i < arr.length; ++i) {
    if (arr[i] === data) {
      return i; // Return index if found
    }
  }
  return -1; // Return -1 if not found
}

// Read words from the file
fs.readFile("JavaScript/words.txt", "utf8", (err, data) => {
  if (err) {
    console.error("Error reading the file:", err);
    return;
  }

  // Split the file content into words
  var words = data.split(/\s+/); // Split on whitespace

  var word = "rhetoric"; // The word to search for
  var start = new Date().getTime(); // Start time
  var position = seqSearch(words, word); // Perform the search
  var stop = new Date().getTime(); // Stop time
  var elapsed = stop - start; // Calculate elapsed time

  // Output the result
  if (position >= 0) {
    console.log("Found " + word + " at position " + position + ".");
    console.log("Sequential search took " + elapsed + " milliseconds.");
  } else {
    console.log(word + " is not in the file.");
  }
});
