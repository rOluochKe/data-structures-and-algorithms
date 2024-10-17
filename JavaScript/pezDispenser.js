class Stack {
  constructor() {
    this.items = [];
  }

  push(element) {
    this.items.push(element);
  }

  pop() {
    if (this.isEmpty()) {
      return "Underflow";
    }
    return this.items.pop();
  }

  peek() {
    return this.items[this.items.length - 1];
  }

  isEmpty() {
    return this.items.length === 0;
  }
}

let pezDispenser = new Stack();
pezDispenser.push("red");
pezDispenser.push("yellow");
pezDispenser.push("white");
pezDispenser.push("yellow");
pezDispenser.push("red");

let tempStack = new Stack();

while (!pezDispenser.isEmpty()) {
  let candy = pezDispenser.pop();
  if (candy !== "yellow") {
    tempStack.push(candy);
  }
}

while (!tempStack.isEmpty()) {
  pezDispenser.push(tempStack.pop());
}

console.log("Final Pez Dispenser Contents:", pezDispenser.items);
