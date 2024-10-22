// Knapsack problem solver function
function knapsackSolver(capacity, values, weights) {
  let n = values.length;
  let dp = Array(n + 1)
    .fill(null)
    .map(() => Array(capacity + 1).fill(0));

  for (let i = 1; i <= n; i++) {
    for (let w = 1; w <= capacity; w++) {
      if (weights[i - 1] <= w) {
        dp[i][w] = Math.max(
          dp[i - 1][w],
          values[i - 1] + dp[i - 1][w - weights[i - 1]]
        );
      } else {
        dp[i][w] = dp[i - 1][w];
      }
    }
  }

  return dp[n][capacity];
}

// Test data with initial constraints
let capacity = 10;
let values = [6, 10, 12];
let weights = [1, 2, 3];

console.log(
  "Max value for initial constraints:",
  knapsackSolver(capacity, values, weights)
);

// Test data with changed capacity
let newCapacity = 15;
console.log(
  "Max value with changed capacity:",
  knapsackSolver(newCapacity, values, weights)
);

// Test data with changed values
let newValues = [8, 11, 14];
console.log(
  "Max value with changed values:",
  knapsackSolver(capacity, newValues, weights)
);

// Test data with changed weights
let newWeights = [2, 3, 4];
console.log(
  "Max value with changed weights:",
  knapsackSolver(capacity, values, newWeights)
);
