const fs = require("fs");

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

// Function to perform sequential search
function seqSearch(arr, data) {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === data) {
      return i; // Return index if found
    }
  }
  return -1; // Return -1 if not found
}

// Generate a dataset
const datasetSize = 1000;
const dataset = Array.from({ length: datasetSize }, () =>
  Math.floor(Math.random() * 100)
);

// Choose a number to search for
const searchValue = dataset[Math.floor(Math.random() * dataset.length)];

// Measure time for sequential search
let startTime = new Date().getTime();
let seqPosition = seqSearch(dataset, searchValue);
let endTime = new Date().getTime();
let seqTime = endTime - startTime;

// Measure time for insertion sort and binary search
startTime = new Date().getTime();
insertionSort(dataset); // Sort the dataset
endTime = new Date().getTime();
let sortTime = endTime - startTime;

startTime = new Date().getTime();
let binPosition = binSearch(dataset, searchValue); // Perform binary search
endTime = new Date().getTime();
let binTime = endTime - startTime;

// Output the results
console.log(
  `Sequential Search: Found ${searchValue} at position ${seqPosition}, time taken: ${seqTime} ms`
);
console.log(`Insertion Sort Time: ${sortTime} ms`);
console.log(
  `Binary Search: Found ${searchValue} at position ${binPosition}, time taken: ${binTime} ms`
);
console.log(`Total Time for Sort and Search: ${sortTime + binTime} ms`);
