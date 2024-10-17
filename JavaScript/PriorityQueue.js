class PriorityQueue {
  constructor() {
    this.items = [];
  }

  enqueue(element, priority) {
    let queueElement = { element, priority };
    let added = false;
    for (let i = 0; i < this.items.length; i++) {
      if (queueElement.priority > this.items[i].priority) {
        this.items.splice(i, 0, queueElement);
        added = true;
        break;
      }
    }
    if (!added) {
      this.items.push(queueElement);
    }
  }

  dequeue() {
    if (this.isEmpty()) {
      return "Underflow";
    }
    return this.items.shift();
  }

  front() {
    if (this.isEmpty()) {
      return "No elements in Queue";
    }
    return this.items[0];
  }

  isEmpty() {
    return this.items.length === 0;
  }
}

let priorityQueue = new PriorityQueue();
priorityQueue.enqueue("A", 3);
priorityQueue.enqueue("B", 1);
priorityQueue.enqueue("C", 5);

console.log(priorityQueue.front()); // Output: { element: 'C', priority: 5 }
console.log(priorityQueue.dequeue()); // Output: { element: 'C', priority: 5 }
