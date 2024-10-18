function Node(data) {
  this.data = data;
  this.next = null;
}

function Set() {
  this.head = null;
  this.add = add;
  this.remove = remove;
  this.size = size;
  this.show = show;
  this.contains = contains;
  this.higher = higher;
  this.lower = lower;
}

function add(data) {
  if (!this.contains(data)) {
    var newNode = new Node(data);
    if (!this.head) {
      this.head = newNode;
    } else {
      var current = this.head;
      while (current.next) {
        current = current.next;
      }
      current.next = newNode;
    }
    return true;
  } else {
    return false;
  }
}

function remove(data) {
  if (!this.head) {
    return false;
  }

  if (this.head.data === data) {
    this.head = this.head.next;
    return true;
  }

  var current = this.head;
  var prev = null;

  while (current && current.data !== data) {
    prev = current;
    current = current.next;
  }

  if (current) {
    prev.next = current.next;
    return true;
  } else {
    return false;
  }
}

function size() {
  var count = 0;
  var current = this.head;
  while (current) {
    count++;
    current = current.next;
  }
  return count;
}

function show() {
  var elements = [];
  var current = this.head;
  while (current) {
    elements.push(current.data);
    current = current.next;
  }
  return elements;
}

function contains(data) {
  var current = this.head;
  while (current) {
    if (current.data === data) {
      return true;
    }
    current = current.next;
  }
  return false;
}

function higher(element) {
  var current = this.head;
  var minHigher = null;

  while (current) {
    if (current.data > element) {
      if (minHigher === null || current.data < minHigher) {
        minHigher = current.data;
      }
    }
    current = current.next;
  }

  return minHigher;
}

function lower(element) {
  var current = this.head;
  var maxLower = null;

  while (current) {
    if (current.data < element) {
      if (maxLower === null || current.data > maxLower) {
        maxLower = current.data;
      }
    }
    current = current.next;
  }

  return maxLower;
}

// Test program
var linkedListSet = new Set();
linkedListSet.add(5);
linkedListSet.add(2);
linkedListSet.add(8);
linkedListSet.add(3);
linkedListSet.add(5); // Trying to add a duplicate
linkedListSet.add(1);

console.log("Linked List Set Elements:", linkedListSet.show());

console.log();

// Test program
var linkedListSet = new Set();
linkedListSet.add(5);
linkedListSet.add(2);
linkedListSet.add(8);
linkedListSet.add(3);
linkedListSet.add(1);

console.log("Linked List Set Elements:", linkedListSet.show());
console.log("Higher than 3:", linkedListSet.higher(3)); // Test the higher function

console.log();

// Test program
var linkedListSet = new Set();
linkedListSet.add(5);
linkedListSet.add(2);
linkedListSet.add(8);
linkedListSet.add(3);
linkedListSet.add(1);

console.log("Linked List Set Elements:", linkedListSet.show());
console.log("Lower than 3:", linkedListSet.lower(3)); // Test the lower function
