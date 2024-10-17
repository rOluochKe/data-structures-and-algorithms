class Deque {
  constructor() {
    this.items = [];
  }

  addFront(element) {
    this.items.unshift(element);
  }

  addRear(element) {
    this.items.push(element);
  }

  removeFront() {
    if (this.isEmpty()) {
      return "Underflow";
    }
    return this.items.shift();
  }

  removeRear() {
    if (this.isEmpty()) {
      return "Underflow";
    }
    return this.items.pop();
  }

  isEmpty() {
    return this.items.length === 0;
  }
}

let deque = new Deque();
deque.addRear("a");
deque.addRear("b");
deque.addFront("c");
deque.addFront("d");

console.log(deque.removeFront()); // Output: d
console.log(deque.removeRear()); // Output: b

function isPalindrome(word) {
  let deque = new Deque();

  for (let char of word) {
    deque.addRear(char);
  }

  while (deque.items.length > 1) {
    if (deque.removeFront() !== deque.removeRear()) {
      return false;
    }
  }

  return true;
}

console.log(isPalindrome("radar")); // Output: true
console.log(isPalindrome("hello")); // Output: false
