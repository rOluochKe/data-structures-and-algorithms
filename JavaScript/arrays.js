// creating arrays
var numbers = [];
console.log(numbers.length); // 0

var numbers = [1, 2, 3, 4, 5];
console.log(numbers.length); // 5

var numbers = new Array();
console.log(numbers.length); // 0

var numbers = new Array(1, 2, 3, 4, 5);
console.log(numbers.length); // 5

var numbers = new Array(10);
console.log(numbers.length); // 10

var objects = [1, "joe", true, null];

var numbers = 3;
var arr = [7, 4, 1886];
console.log(Array.isArray(numbers)); // false
console.log(Array.isArray(arr)); // true

// accessing and writing array elements
var nums = [];
for (var i = 0; i < 100; i++) {
  nums[i] = i + 1;
}

var numbers = [1, 2, 3, 4, 5];
var sum = numbers[0] + numbers[1] + numbers[2] + numbers[3] + numbers[4];
console.log(sum); // 15

var numbers = [1, 2, 3, , 5, 8, 13, 21];
var sum = 0;
for (var i = 0; i < numbers.length; i++) {
  sum += numbers[i];
}
console.log(sum); // 53

// getting arrays from strings
var sentence = "the quick brown fox jumped over the lazy dog";
var words = sentence.split(" ");
for (var i = 0; i < words.length; ++i) {
  console.log("word " + i + ": " + words[i]);
}

/**
 * output:
 * word 0: the
 * word 1: quick
 * word 2: brown
 * word 3: fox
 * word 4: jumped
 * word 5: over
 * word 6: the
 * word 7: lazy
 * word 8: dog
 */

// aggregate array operations
var nums = [];
for (var i = 0; i < 100; i++) {
  nums[i] = i + 1;
}
var samenums = nums;
nums[0] = 400;
console.log(samenums[0]); // 400

// searching for a value
var names = ["David", "Cynthia", "Raymond", "Clayton", "Jennifer"];
var name = readline();
var position = names.indexOf(name);
if (position >= 0) {
  console.log("Found " + name + " at position " + position);
} else {
  console.log(name + " not found in array");
}

var names = [
  "David",
  "Mike",
  "Cynthia",
  "Raymond",
  "Clayton",
  "Mike",
  "Jennifer",
];
var name = "Mike";
var firstPos = names.indexOf(name);
console.log("First found " + name + " at position " + firstPos);
var lastPos = names.lastIndexOf(name);
console.log("Last found " + name + " at position " + lastPos);

/**
 * output:
 * First found Mike at position 1
 * Last found Mike at position 5
 */

// string representation of arrays
var names = ["David", "Cynthia", "Raymond", "Clayton", "Mike", "Jennifer"];
var nameStr = names.join();
console.log(nameStr); // David,Cynthia,Raymond,Clayton,Mike,Jennifer
nameStr = names.toString();
console.log(nameStr); // David,Cynthia,Raymond,Clayton,Mike,Jennifer

// creating new arrays from existing arrays
var cisDept = ["Mike", "Clayton", "Terrill", "Danny", "Jennifer"];
var dmpDept = ["Raymond", "Cynthia", "Bryan"];
var itDiv = cisDept.concat(dmpDept);
console.log(itDiv);
itDiv = dmpDept.concat(cisDept);
console.log(itDiv);

/**
 * output:
 * Mike,Clayton,Terrill,Danny,Jennifer,Raymond,Cynthia,Bryan
 * Raymond,Cynthia,Bryan,Mike,Clayton,Terrill,Danny,Jennifer
 */

var itDiv = [
  "Mike",
  "Clayton",
  "Terrill",
  "Raymond",
  "Cynthia",
  "Danny",
  "Jennifer",
];
var dmpDept = itDiv.splice(3, 3);
var cisDept = itDiv;
console.log(dmpDept); // Raymond,Cynthia,Danny
console.log(cisDept); // Mike,Clayton,Terrill,Jennifer

// mutator functions
// adding elements to an array
var nums = [1, 2, 3, 4, 5];
console.log(nums); // 1,2,3,4,5
nums.push(6);
console.log(nums); // 1,2,3,4,5,6

var nums = [1, 2, 3, 4, 5];
console.log(nums); // 1,2,3,4,5
nums[nums.length] = 6;
console.log(nums); // 1,2,3,4,5,6

var nums = [2, 3, 4, 5];
var newnum = 1;
var N = nums.length;
for (var i = N; i > 0; --i) {
  nums[i] = nums[i - 1];
}
nums[0] = newnum;
console.log(nums); //1,2,3,4,5

var nums = [2, 3, 4, 5];
console.log(nums); // 2,3,4,
var newnum = 1;
nums.unshift(newnum);
console.log(nums); // 1,2,3,4
nums = [3, 4, 5];
nums.unshift(newnum, 1, 2);
console.log(nums); // 1,2,3,4,5

// removing elements from an array
var nums = [1, 2, 3, 4, 5, 9];
nums.pop();
console.log(nums); //1,2,3,4,5

var nums = [9, 1, 2, 3, 4, 5];
console.log(nums);
for (var i = 0; i < nums.length; i++) {
  nums[i] = nums[i + 1];
}
console.log(nums); // 1,2,3,4,5

var nums = [9, 1, 2, 3, 4, 5];
nums.shift();
console.log(nums); // 1,2,3,4,5

var nums = [6, 1, 2, 3, 4, 5];
var first = nums.shift();
nums.push(first);
console.log(nums); // 1,2,3,4,5,6

// adding and removing elements from the middle of an array

var nums = [1, 2, 3, 7, 8, 9];
var newElements = [4, 5, 6];
nums.splice(3, 0, newElements);
console.log(nums); // 1,2,3,4,5,6,7,8,9

var nums = [1, 2, 3, 7, 8, 9];
nums.splice(3, 0, 4, 5, 6);
console.log(nums);

var nums = [1, 2, 3, 100, 200, 300, 400, 4, 5];
nums.splice(3, 4);
console.log(nums); // 1,2,3,4,5

// putting array elements in order
var nums = [1, 2, 3, 4, 5];
nums.reverse();
console.log(nums); // 5,4,3,2,1

var names = ["David", "Mike", "Cynthia", "bryan", "Raymond"];
nums.sort();
console.log(nums); // Bryan,Clayton,David,Mike,Raymond

var nums = [3, 1, 2, 100, 4, 200];
nums.sort();
console.log(nums); // 1,100,2,200,3,4

function compare(num1, num2) {
  return num1 - num2;
}
var nums = [3, 1, 2, 100, 4, 200];
nums.sort(compare);
console.log(nums); // 1,2,3,4,100,200

// iterator functions
function square(num) {
  console.log(num, num * num);
}
var nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
nums.forEach(square);

/**
 * output:
 * 1 1
 * 2 4
 * 3 9
 * 4 16
 * 5 25
 * 6 36
 * 7 49
 * 8 64
 * 9 81
 * 10 100
 */

function isEven(num) {
  return num % 2 == 0;
}
var nums = [2, 4, 6, 8, 10];
var even = nums.every(isEven);
if (even) {
  console.log("All numbers are even");
} else {
  console.log("Not all numbers are even");
}

/**
 * output:
 * All numbers are even
 */

function add(runningTotal, currentValue) {
  return runningTotal + currentValue;
}
var nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
var sum = nums.reduce(add);
console.log(sum); // 55

/**
 * output:
 * add(1,2) -> 3
 * add(3,3) -> 6
 * add(6,4) -> 10
 * add(10,5) -> 15
 * add(15,6) -> 21
 * add(21,7) -> 28
 * add(28,8) -> 36
 * add(36,9) -> 45
 * add(45,10) -> 55
 */

function concat(accumuledString, item) {
  return accumuledString + item;
}

var words = ["the", "quick", "brown", "fox"];
var sentence = words.reduce(concat);
console.log(sentence); // "the quick brown fox"

var words = ["the", "quick", "brown", "fox"];
var sentence = words.reduceRight(concat);
console.log(sentence); // "fox brown quick the"

// iterator functions that return a new array
function curve(grade) {
  return (grade += 5);
}

var grades = [77, 65, 81, 92, 83];
var newgrades = grades.map(curve);
console.log(newgrades); // 82,70,86,97,88

function first(word) {
  return word[0];
}

var words = ["for", "your", "information"];
var acronym = words.map(first);
console.log(acronym.join(" ")); // "fyi"

function passing(num) {
  return num > 60;
}

var grades = [];
for (var i = 0; i < 20; i++) {
  grades[i] = Math.floor(Math.random() * 101);
}
var passGrades = grades.filter(passing);
console.log("All grades:");
console.log(grades);
console.log("Passing grades:");
console.log(passGrades);

/**
 * output:
 * All grades:
 * 39,43,89,19,46,54,48,5,13,31,27,95,62,64,35,75,79,88,73,74
 * Passing grades:
 * 89,95,62,64,75,79,88,73,74
 */

function afterc(str) {
  if (str.indexOf("cie") > -1) {
    return true;
  }
  return false;
}

var words = ["receive", "deceive", "perceive", "deceit", "conceive"];
var misspelled = words.filter(afterc);
console.log(misspelled); // receive,perceive,conceive

// two dimensional arrays
// creating two dimensional arrays
var twod = [];
var rows = 5;
for (var i = 0; i < rows; i++) {
  twod[i] = [];
}

Array.matrix = function (numrows, numcols, initial) {
  var arr = [];
  for (var i = 0; i < numrows; i++) {
    var columns = [];
    for (var j = 0; j < numcols; j++) {
      columns[j] = initial;
    }
    arr[i] = columns;
  }
  return arr;
};

// var nums Array.matrix(5,5,0)
// console.log(nums[1][1]) // 0
// var names Array.matrix(3,3,"")
// names[1][2]="Joe"
// console.log(names[1][2]) // Joe

var grades = [
  [89, 77, 78],
  [76, 82, 81],
  [91, 94, 89],
];
console.log(grades[2][2]); // 89

// nested loops
var grades = [
  [89, 77, 78],
  [76, 82, 81],
  [91, 94, 89],
];
var total = 0;
var average = 0.0;
for (var row = 0; row < grades.length; row++) {
  for (var col = 0; col < grades[row].length; col++) {
    total += grades[row][col];
  }
  average = total / grades[row].length;
  console.log(
    "Student " + parseInt(row + 1) + " average: " + average.toFixed(2)
  );
  total = 0;
  average = 0.0;
}

/**
 * output:
 * Student 1 average: 81.33
 * Student 2 average: 79.67
 * Student 3 average: 91.33
 */

// row-wise computation

var grades = [
  [89, 77, 78],
  [76, 82, 81],
  [91, 94, 89],
];
var total = 0;
var average = 0.0;
for (var col = 0; col < grades.length; ++col) {
  for (var row = 0; row < grades[col].length; ++row) {
    total += grades[row][col];
  }
  average = total / grades[col].length;
  print("Test " + parseInt(col + 1) + " average: " + average.toFixed(2));
  total = 0;
  average = 0.0;
}

/**
 * output:
 * Test 1 average: 85.33
 * Test 2 average: 84.33
 * test 3 average: 82.67
 */

// jagged arrays

var grades = [
  [89, 77],
  [76, 82, 81],
  [91, 94, 89, 99],
];
var total = 0;
var average = 0.0;
for (var row = 0; row < grades.length; row++) {
  for (var col = 0; col < grades[row].length; col++) {
    total += grades[row][col];
  }
  average = total / grades[row].length;
  console.log(
    "Student " + parseInt(row + 1) + " average: " + average.toFixed(2)
  );
  total = 0;
  average = 0.0;
}

/**
 * Output:
 * Student 1 average: 83.00
 * Student 2 average: 79.67
 * Student 3 average: 93.25
 */

// arrays of objects

function Point(x, y) {
  this.x = x;
  this.y = y;
}

function diplayPts(arr) {
  for (var i = 0; i < arr.length; i++) {
    console.log(arr[i].x + "," + arr[i].y);
  }
}

var p1 = new Point(1, 2);
var p2 = new Point(3, 5);
var p3 = new Point(2, 8);
var p4 = new Point(4, 4);
var points = [p1, p2, p3, p4];
for (var i = 0; i < points.length; i++) {
  console.log(
    "Points " + parseInt(i + 1) + ": " + points[i].x + ", " + points[i].y
  );
}

var p5 = new Point(12, -3);
points.push(p5);
console.log("After push: ");
displayPts(points);
points.shift();
console.log("After shift: ");
displayPts(points);

/**
 * Output:
 * Points 1: 1,2
 * Points 2: 3,5
 * Points 3: 2,8
 * Points 4: 4,4
 * After push:
 * 1,2
 * 3,5
 * 2,8
 * 4,4
 * 12,-3
 * After shift:
 * 3,5
 * 2,8
 * 4,4
 * 12,-3
 */

// arrays in objects
function weekTemp() {
  this.dataStore = [];
  this.add = add;
  this.average = average;
}

function add(temp) {
  this.dataStore.push(temp);
}

function average() {
  var total = 0;
  for (var i = 0; i < this.dataStore.length; i++) {
    total += this.dataStore[i];
  }
  return total / this.dataStore.length;
}

var thisWeek = new weekTemp();
thisWeek.add(52);
thisWeek.add(55);
thisWeek.add(61);
thisWeek.add(65);
thisWeek.add(55);
thisWeek.add(50);
thisWeek.add(52);
thisWeek.add(49);
console.log(thisWeek.average()); // 54.875
