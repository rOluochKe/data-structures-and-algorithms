class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
  }

  insert(data) {
    let newNode = new Node(data);
    if (!this.head) {
      this.head = newNode;
    } else {
      let current = this.head;
      while (current.next) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  display() {
    let current = this.head;
    while (current) {
      console.log(current.data);
      current = current.next;
    }
  }

  calculateAverage() {
    let current = this.head;
    let sum = 0;
    let count = 0;

    while (current) {
      sum += current.data;
      count++;
      current = current.next;
    }

    return sum / count;
  }
}

// Test data entry
const gradesList = new LinkedList();
gradesList.insert(85);
gradesList.insert(92);
gradesList.insert(78);
gradesList.insert(90);

// Display all grades
console.log("All Grades:");
gradesList.display();

// Calculate and display the average grade
const averageGrade = gradesList.calculateAverage();
console.log("Average Grade:", averageGrade);
