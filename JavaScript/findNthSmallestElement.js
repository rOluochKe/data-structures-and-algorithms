// Function to find the nth-smallest element in a dataset
function findNthSmallestElement(dataSet, n) {
  if (n > 0 && n <= dataSet.length) {
    let sortedData = dataSet.slice().sort();
    return sortedData[n - 1];
  } else {
    return "Invalid input for n";
  }
}

// Test data with numbers
let numberDataSet = [5, 8, 2, 10, 3, 6, 1, 9, 4, 7];
let nth = 2; // Find the second-smallest element
console.log(
  `Second-smallest element in numbers: ${findNthSmallestElement(
    numberDataSet,
    nth
  )}`
);

// Test data with text
let textDataSet = [
  "apple",
  "banana",
  "kiwi",
  "orange",
  "mango",
  "grape",
  "pear",
];
nth = 3; // Find the third-smallest element
console.log(
  `Third-smallest element in text: ${findNthSmallestElement(textDataSet, nth)}`
);
