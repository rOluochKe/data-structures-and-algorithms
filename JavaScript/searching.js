const readline = require("readline");

// Create an interface for input and output
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

// Sequence search function
function seqSearch(arr, target) {
  for (var i = 0; i < arr.length; ++i) {
    if (arr[i] === target) {
      return true; // Number found
    }
  }
  return false; // Number not found
}

// Display array function
function dispArr(arr) {
  for (var i = 0; i < arr.length; ++i) {
    process.stdout.write(arr[i] + " "); // Use process.stdout.write for inline printing
    if (i % 10 == 9) {
      console.log("\n");
    }
  }
  if (arr.length % 10 != 0) {
    console.log("\n");
  }
}

// Generate random numbers
var nums = [];
for (var i = 0; i < 100; ++i) {
  nums[i] = Math.floor(Math.random() * 101);
}

// Display the array
dispArr(nums);
console.log("Enter a number to search for: ");

// Prompt the user for input
rl.question("", (input) => {
  var num = parseInt(input);
  console.log();

  if (seqSearch(nums, num)) {
    console.log(num + " is in the array.");
  } else {
    console.log(num + " is not in the array.");
  }

  console.log();
  dispArr(nums);

  // Close the readline interface
  rl.close();
});
