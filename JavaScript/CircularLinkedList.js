class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class CircularLinkedList {
  constructor() {
    this.head = null;
  }

  insert(data) {
    let newNode = new Node(data);
    if (!this.head) {
      this.head = newNode;
      this.head.next = this.head; // Point to itself for circular behavior
    } else {
      let current = this.head;
      while (current.next !== this.head) {
        current = current.next;
      }
      current.next = newNode;
      newNode.next = this.head;
    }
  }

  josephus(m) {
    let current = this.head;
    let prev = null;

    // Move to the last node
    while (current.next !== current) {
      for (let i = 1; i < m; i++) {
        prev = current;
        current = current.next;
      }
      prev.next = current.next;
      current = prev.next;
    }

    return [current.data, current.next.data];
  }
}

// Test data entry
const n = 7; // Number of people in the circle
const m = 3; // Kill every m-th person

const soldiers = new CircularLinkedList();
for (let i = 1; i <= n; i++) {
  soldiers.insert(i);
}

// Solve the Josephus problem
const [survivor1, survivor2] = soldiers.josephus(m);

console.log(
  `The last two survivors in the circle are: ${survivor1} and ${survivor2}`
);
