function CArray(numElements) {
  this.dataStore = [];
  this.pos = 0;
  this.numElements = numElements;
  this.insert = insert;
  this.toString = toString;
  this.clear = clear;
  this.setData = setData;
  this.swap = swap;
  this.bubbleSort = bubbleSort;
  this.selectionSort = selectionSort;
  this.insertionSort = insertionSort;
  this.shellsort = shellsort;
  this.gaps = [5, 3, 1]; // Typical gap sequence for shell sort
  this.mergeSort = mergeSort;
  this.mergeArrays = mergeArrays;
  this.quickSort = quickSort;

  for (var i = 0; i < numElements; i++) {
    this.dataStore[i] = i;
  }

  function setData() {
    for (var i = 0; i < this.numElements; i++) {
      this.dataStore[i] = Math.floor(Math.random() * (this.numElements + 1));
    }
  }

  function clear() {
    for (var i = 0; i < this.dataStore.length; i++) {
      this.dataStore[i] = 0;
    }
  }

  function insert(element) {
    this.dataStore[this.pos++] = element;
  }

  function toString() {
    var retStr = "";
    for (var i = 0; i < this.dataStore.length; i++) {
      retStr += this.dataStore[i] + " ";
      if ((i + 1) % 10 === 0) {
        retStr += "\n";
      }
    }
    return retStr.trim();
  }

  function swap(arr, index1, index2) {
    var temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  function bubbleSort() {
    var numElements = this.dataStore.length;
    for (var outer = numElements; outer >= 2; --outer) {
      for (var inner = 0; inner <= outer - 2; ++inner) {
        if (this.dataStore[inner] > this.dataStore[inner + 1]) {
          swap(this.dataStore, inner, inner + 1);
        }
      }
    }
  }

  function selectionSort() {
    var min;
    for (var outer = 0; outer < this.dataStore.length - 1; outer++) {
      min = outer;
      for (var inner = outer + 1; inner < this.dataStore.length; inner++) {
        if (this.dataStore[inner] < this.dataStore[min]) {
          min = inner;
        }
      }
      swap(this.dataStore, outer, min);
    }
  }

  function insertionSort() {
    var temp, inner;
    for (var outer = 1; outer < this.dataStore.length; outer++) {
      temp = this.dataStore[outer];
      inner = outer;
      while (inner > 0 && this.dataStore[inner - 1] >= temp) {
        this.dataStore[inner] = this.dataStore[inner - 1];
        inner--;
      }
      this.dataStore[inner] = temp;
    }
  }

  function shellsort() {
    for (var g = 0; g < this.gaps.length; g++) {
      var gap = this.gaps[g];
      for (var i = gap; i < this.dataStore.length; i++) {
        var temp = this.dataStore[i];
        var j;
        for (j = i; j >= gap && this.dataStore[j - gap] > temp; j -= gap) {
          this.dataStore[j] = this.dataStore[j - gap];
        }
        this.dataStore[j] = temp;
      }
    }
  }

  function mergeSort() {
    if (this.dataStore.length < 2) {
      return;
    }
    var step = 1;
    var left, right;
    while (step < this.dataStore.length) {
      left = 0;
      right = step;
      while (right + step <= this.dataStore.length) {
        mergeArrays(this.dataStore, left, left + step, right, right + step);
        left = right + step;
        right = left + step;
      }
      if (right < this.dataStore.length) {
        mergeArrays(
          this.dataStore,
          left,
          left + step,
          right,
          this.dataStore.length
        );
      }
      step *= 2;
    }
  }

  function mergeArrays(arr, startLeft, stopLeft, startRight, stopRight) {
    var rightArr = new Array(stopRight - startRight + 1);
    var leftArr = new Array(stopLeft - startLeft + 1);
    var k = startRight;
    for (var i = 0; i < rightArr.length - 1; ++i) {
      rightArr[i] = arr[k];
      ++k;
    }
    k = startLeft;
    for (var i = 0; i < leftArr.length - 1; ++i) {
      leftArr[i] = arr[k];
      ++k;
    }
    rightArr[rightArr.length - 1] = Infinity; // a sentinel value
    leftArr[leftArr.length - 1] = Infinity; // a sentinel value
    var m = 0;
    var n = 0;
    for (var k = startLeft; k < stopRight; ++k) {
      if (leftArr[m] <= rightArr[n]) {
        arr[k] = leftArr[m];
        m++;
      } else {
        arr[k] = rightArr[n];
        n++;
      }
    }
  }
}

function quickSort() {
  this.dataStore = qSort(this.dataStore);
}

function quickSort() {
  this.dataStore = qSort(this.dataStore);
}

function qSort(list) {
  if (list.length === 0) {
    return [];
  }
  var lesser = [];
  var greater = [];
  var pivot = list[0];
  for (var i = 1; i < list.length; i++) {
    if (list[i] < pivot) {
      lesser.push(list[i]);
    } else {
      greater.push(list[i]);
    }
  }
  return qSort(lesser).concat(pivot, qSort(greater));
}

// Test the CArray class
var numElements = 100;
var myNums = new CArray(numElements);
myNums.setData();
console.log("Initial Array:");
console.log(myNums.toString());

console.log("\nSorted Array (Bubble Sort):");
myNums.bubbleSort();
console.log(myNums.toString());

console.log("\nSorted Array (Selection Sort):");
myNums.setData(); // Reset data
myNums.selectionSort();
console.log(myNums.toString());

console.log("\nSorted Array (Insertion Sort):");
myNums.setData(); // Reset data
myNums.insertionSort();
console.log(myNums.toString());

console.log("\nSorted Array (Shell Sort):");
myNums.setData(); // Reset data
myNums.shellsort();
console.log(myNums.toString());

console.log("\nSorted Array (Merge Sort):");
myNums.setData(); // Reset data
myNums.mergeSort();
console.log(myNums.toString());

console.log("\nSorted Array (Quick Sort):");
myNums.setData();
myNums.quickSort();
console.log(myNums.toString());
