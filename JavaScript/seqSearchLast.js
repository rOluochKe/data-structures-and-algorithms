// Function to perform sequential search for the last occurrence
function seqSearchLast(arr, data) {
  let lastIndex = -1; // Initialize last index to -1 (not found)

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === data) {
      lastIndex = i; // Update lastIndex whenever data is found
    }
  }

  return lastIndex; // Return the last index found (or -1 if not found)
}

// Test data
const testData = [
  "apple",
  "banana",
  "cherry",
  "date",
  "fig",
  "banana", // last occurrence
  "grape",
  "banana", // another occurrence
  "kiwi",
];

// Test the function
const searchWord = "banana";
const position = seqSearchLast(testData, searchWord);

if (position >= 0) {
  console.log(`Found "${searchWord}" at last position ${position}.`);
} else {
  console.log(`"${searchWord}" is not in the array.`);
}
