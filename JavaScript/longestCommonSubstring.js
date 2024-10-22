// Function to find the longest common substring using brute-force technique
function longestCommonSubstring(str1, str2) {
  let maxLength = 0;
  let endIndex = 0;

  for (let i = 0; i < str1.length; i++) {
    for (let j = 0; j < str2.length; j++) {
      let k = 0;
      while (
        str1[i + k] === str2[j + k] &&
        i + k < str1.length &&
        j + k < str2.length
      ) {
        k++;
        if (k > maxLength) {
          maxLength = k;
          endIndex = i + k - 1; // Adjust endIndex to reflect the end of the common substring
        }
      }
    }
  }

  // Return the longest common substring using the correct indices
  return str1.slice(endIndex - maxLength + 1, endIndex + 1);
}

// Test data
let string1 = "helloworld";
let string2 = "hello";
console.log(
  "Longest Common Substring:",
  longestCommonSubstring(string1, string2)
);
