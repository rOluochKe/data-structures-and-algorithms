function findMissingParenthesis(expression) {
  let stack = [];

  for (let i = 0; i < expression.length; i++) {
    if (expression[i] === "(") {
      stack.push(i);
    } else if (expression[i] === ")") {
      if (stack.length === 0) {
        return i;
      } else {
        stack.pop();
      }
    }
  }

  return stack.length > 0 ? stack[stack.length - 1] : -1;
}

let expression = "2.3 + 23 / 12 + (3.14159 * .24";
console.log(findMissingParenthesis(expression)); // Output: 16
