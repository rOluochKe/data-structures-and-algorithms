class Node {
  constructor(key) {
    this.left = null;
    this.right = null;
    this.val = key;
    this.count = 1;
  }
}

class BST {
  constructor() {
    this.root = null;
  }

  insert(word) {
    this.root = this._insertNode(this.root, word);
  }

  _insertNode(node, word) {
    if (node === null) {
      return new Node(word);
    }
    if (word === node.val) {
      node.count++;
    } else if (word < node.val) {
      node.left = this._insertNode(node.left, word);
    } else {
      node.right = this._insertNode(node.right, word);
    }
    return node;
  }

  countOccurrences() {
    this._inOrder(this.root);
  }

  _inOrder(node) {
    if (node !== null) {
      this._inOrder(node.left);
      console.log(node.val + " | " + node.count);
      this._inOrder(node.right);
    }
  }
}

// Test data
let bst = new BST();
let text = "hello world hello code world";
let words = text.split(" ");
for (let word of words) {
  bst.insert(word);
}

// Display the number of occurrences
console.log("Counting Occurrences");
bst.countOccurrences();
