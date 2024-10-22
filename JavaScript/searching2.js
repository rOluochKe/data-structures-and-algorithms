const readline = require("readline");

// Create an interface for input and output
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

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
      return mid; // Found the value, return its index
    }
  }
  return -1; // Value not found
}

// Function to perform insertion sort
function insertionSort(arr) {
  for (let i = 1; i < arr.length; i++) {
    let key = arr[i];
    let j = i - 1;

    // Move elements of arr[0..i-1], that are greater than key,
    // to one position ahead of their current position
    while (j >= 0 && arr[j] > key) {
      arr[j + 1] = arr[j];
      j = j - 1;
    }
    arr[j + 1] = key;
  }
}

// Function to display array
function dispArr(arr) {
  for (let i = 0; i < arr.length; i++) {
    process.stdout.write(arr[i] + " ");
    if (i % 10 === 9) {
      console.log();
    }
  }
  if (arr.length % 10 !== 0) {
    console.log();
  }
}

// Generate random numbers
let nums = [];
for (let i = 0; i < 100; i++) {
  nums[i] = Math.floor(Math.random() * 101);
}

// Sort the array using insertion sort
insertionSort(nums);

// Display the sorted array
dispArr(nums);
console.log(); // Add a newline for better formatting

// Prompt the user for input
rl.question("Enter a value to search for: ", (input) => {
  let val = parseInt(input);
  let retVal = binSearch(nums, val);

  if (retVal >= 0) {
    console.log("Found " + val + " at position " + retVal);
  } else {
    console.log(val + " is not in the array.");
  }

  // Close the readline interface
  rl.close();
});
