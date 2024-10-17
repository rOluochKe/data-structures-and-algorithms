function infixToPostfix(expression) {
  let operatorStack = [];
  let output = [];
  let precedence = {
    "+": 1,
    "-": 1,
    "*": 2,
    "/": 2,
  };

  for (let token of expression) {
    if (/\d/.test(token)) {
      output.push(token);
    } else if (token === "(") {
      operatorStack.push(token);
    } else if (token === ")") {
      while (operatorStack[operatorStack.length - 1] !== "(") {
        output.push(operatorStack.pop());
      }
      operatorStack.pop();
    } else {
      while (
        operatorStack.length &&
        precedence[operatorStack[operatorStack.length - 1]] >= precedence[token]
      ) {
        output.push(operatorStack.pop());
      }
      operatorStack.push(token);
    }
  }

  while (operatorStack.length) {
    output.push(operatorStack.pop());
  }

  return output;
}

function evaluatePostfix(expression) {
  let stack = [];

  for (let token of expression) {
    if (/\d/.test(token)) {
      stack.push(parseFloat(token));
    } else {
      let operand2 = stack.pop();
      let operand1 = stack.pop();
      if (token === "+") {
        stack.push(operand1 + operand2);
      } else if (token === "-") {
        stack.push(operand1 - operand2);
      } else if (token === "*") {
        stack.push(operand1 * operand2);
      } else if (token === "/") {
        stack.push(operand1 / operand2);
      }
    }
  }

  return stack.pop();
}

let infixExpression = ["2", "+", "3", "*", "5"];
let postfixExpression = infixToPostfix(infixExpression);
console.log("Postfix Expression:", postfixExpression);
console.log("Evaluation Result:", evaluatePostfix(postfixExpression));
