function Node(element) {
  this.element = element;
  this.next = null;
}

function LList() {
  this.head = new Node("head");
  this.head.next = this.head;
  this.find = find;
  this.insert = insert;
  this.display = display;
  this.findPrevious = findPrevious;
  this.remove = remove;
  this.advance = advance;
  this.back = back;
  this.show = show;
  this.current = this.head;
}

function find(item) {
  var currNode = this.head;
  while (currNode.element != item) {
    currNode = currNode.next;
  }
  return currNode;
}

function insert(newElement, item) {
  var newNode = new Node(newElement);
  var current = this.find(item);
  newNode.next = current.next;
  current.next = newNode;
}

function display() {
  var currNode = this.head;
  while (!(currNode.next == null) && !(currNode.next.element == "head")) {
    console.log(currNode.next.element);
    currNode = currNode.next;
  }
}

function findPrevious(item) {
  var currNode = this.head;
  while (!(currNode.next == null) && currNode.next.element != item) {
    currNode = currNode.next;
  }
  return currNode;
}

function remove(item) {
  var prevNode = this.findPrevious(item);
  if (!(prevNode.next == null)) {
    prevNode.next = prevNode.next.next;
  }
}

function advance(n) {
  for (let i = 0; i < n; i++) {
    if (this.current.next !== this.head) {
      this.current = this.current.next;
    } else {
      break; // Reached the head of the list
    }
  }
}

function back(n) {
  for (let i = 0; i < n; i++) {
    let prevNode = this.findPrevious(this.current.element);
    if (prevNode !== this.head) {
      this.current = prevNode;
    } else {
      break; // Reached the head of the list
    }
  }
}

function show() {
  console.log("Current Node: " + this.current.element);
}

// Create an instance of the LList class
var myList = new LList();

// Insert some nodes
myList.insert("A", "head");
myList.insert("B", "A");
myList.insert("C", "B");
myList.insert("D", "C");

// Display the list
myList.display(); // Output: A, B, C, D

// Move current node forward by 2 spaces
myList.advance(2);

// Display the list after moving forward
myList.display(); // Output: C, D

// Move current node backward by 1 space
myList.back(1);

// Display the list after moving backward
myList.display(); // Output: B, C, D

// Show the data associated with the current node
myList.show(); // Output: B
