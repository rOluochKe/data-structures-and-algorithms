// Function to generate an array of 1000 sorted integers
function generateSortedArray() {
  let array = [];
  for (let i = 1; i <= 1000; i++) {
    array.push(i);
  }
  return array;
}

// Function to shuffle an array
function shuffleArray(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
  return array;
}

// Function to measure the time taken by a function
function measureTime(func, array) {
  let startTime = performance.now();
  func(array);
  let endTime = performance.now();
  return endTime - startTime;
}

// Bubble sort implementation
function bubbleSort(array) {
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < array.length - i - 1; j++) {
      if (array[j] > array[j + 1]) {
        [array[j], array[j + 1]] = [array[j + 1], array[j]];
      }
    }
  }
}

// Selection sort implementation
function selectionSort(array) {
  for (let i = 0; i < array.length; i++) {
    let minIndex = i;
    for (let j = i + 1; j < array.length; j++) {
      if (array[j] < array[minIndex]) {
        minIndex = j;
      }
    }
    if (minIndex !== i) {
      [array[i], array[minIndex]] = [array[minIndex], array[i]];
    }
  }
}

// Generate sorted array
let sortedArray = generateSortedArray();

// Generate shuffled array
let shuffledArray = shuffleArray([...sortedArray]);

// Measure time for sorting sorted array using bubble sort
let bubbleSortTimeSorted = measureTime(bubbleSort, sortedArray.slice());

// Measure time for sorting shuffled array using bubble sort
let bubbleSortTimeShuffled = measureTime(bubbleSort, shuffledArray.slice());

// Measure time for sorting sorted array using selection sort
let selectionSortTimeSorted = measureTime(selectionSort, sortedArray.slice());

// Measure time for sorting shuffled array using selection sort
let selectionSortTimeShuffled = measureTime(
  selectionSort,
  shuffledArray.slice()
);

console.log(
  "Bubble Sort Time (Sorted):",
  bubbleSortTimeSorted.toFixed(2),
  "milliseconds"
);
console.log(
  "Bubble Sort Time (Shuffled):",
  bubbleSortTimeShuffled.toFixed(2),
  "milliseconds"
);
console.log(
  "Selection Sort Time (Sorted):",
  selectionSortTimeSorted.toFixed(2),
  "milliseconds"
);
console.log(
  "Selection Sort Time (Shuffled):",
  selectionSortTimeShuffled.toFixed(2),
  "milliseconds"
);

console.log();

// Function to generate an array of 1000 integers sorted in reverse order
function generateReverseSortedArray() {
  let array = [];
  for (let i = 1000; i >= 1; i--) {
    array.push(i);
  }
  return array;
}

// Generate reverse sorted array
let reverseSortedArray = generateReverseSortedArray();

// Measure time for sorting reverse sorted array using bubble sort
let bubbleSortTimeReverseSorted = measureTime(
  bubbleSort,
  reverseSortedArray.slice()
);

// Measure time for sorting reverse sorted array using selection sort
let selectionSortTimeReverseSorted = measureTime(
  selectionSort,
  reverseSortedArray.slice()
);

console.log(
  "Bubble Sort Time (Reverse Sorted):",
  bubbleSortTimeReverseSorted.toFixed(2),
  "milliseconds"
);
console.log(
  "Selection Sort Time (Reverse Sorted):",
  selectionSortTimeReverseSorted.toFixed(2),
  "milliseconds"
);

console.log();

// Function to generate an array of over 10,000 randomly generated integers
function generateRandomArray(size) {
  let array = [];
  for (let i = 0; i < size; i++) {
    array.push(Math.floor(Math.random() * 10000));
  }
  return array;
}

// Generate random array with over 10,000 integers
let randomArray = generateRandomArray(10000);

// Measure time for sorting random array using Quicksort
let quickSortTime = measureTime(
  (arr) => arr.sort((a, b) => a - b),
  randomArray.slice()
);

// Measure time for sorting random array using JavaScript built-in sorting function
let builtinSortTime = measureTime(
  (arr) => arr.sort((a, b) => a - b),
  randomArray.slice()
);

console.log("Quicksort Time:", quickSortTime.toFixed(2), "milliseconds");
console.log(
  "Built-in Sorting Function Time:",
  builtinSortTime.toFixed(2),
  "milliseconds"
);
