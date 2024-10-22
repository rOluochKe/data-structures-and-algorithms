// Greedy coin changing algorithm (without using dimes)
function coinChange(coins, amount) {
  coins.sort((a, b) => b - a); // Sort coins in descending order
  let result = [];

  for (let i = 0; i < coins.length; i++) {
    while (amount >= coins[i]) {
      result.push(coins[i]);
      amount -= coins[i];
    }
  }

  if (amount === 0) {
    return result;
  } else {
    return "No solution";
  }
}

// Test data
let coins = [25, 10, 5, 1]; // Quarters, nickels, and pennies (without dimes)
let amount = 30;

console.log(
  "Coins for 30 cents without using dimes:",
  coinChange(coins, amount)
);
