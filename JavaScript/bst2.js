class Node {
  constructor(key) {
    this.left = null;
    this.right = null;
    this.val = key;
  }
}

class BST {
  constructor() {
    this.root = null;
  }

  countNodes(node) {
    if (node === null) {
      return 0;
    }
    return 1 + this.countNodes(node.left) + this.countNodes(node.right);
  }

  countEdges(node) {
    if (node === null) {
      return 0;
    }
    return this.countEdges(node.left) + this.countEdges(node.right) + 1;
  }

  maxValue(node) {
    let current = node;
    while (current.right !== null) {
      current = current.right;
    }
    return current.val;
  }

  minValue(node) {
    let current = node;
    while (current.left !== null) {
      current = current.left;
    }
    return current.val;
  }
}

// Test data
let bst = new BST();
bst.root = new Node(5);
bst.root.left = new Node(3);
bst.root.right = new Node(8);
bst.root.left.left = new Node(2);
bst.root.left.right = new Node(4);
bst.root.right.left = new Node(7);
bst.root.right.right = new Node(9);

// Test the countNodes function
let nodeCount = bst.countNodes(bst.root);
console.log("Number of nodes in the BST:", nodeCount);

let edgeCount = bst.countEdges(bst.root) - 1;
console.log("Number of edges in the BST:", edgeCount);

let maxVal = bst.maxValue(bst.root);
console.log("Maximum value in the BST:", maxVal);

let minVal = bst.minValue(bst.root);
console.log("Minimum value in the BST:", minVal);
