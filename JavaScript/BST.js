const readline = require("readline");

// Create an interface for input and output
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function Node(data, left, right) {
  this.data = data;
  this.count = 1;
  this.left = left;
  this.right = right;
  this.show = show;
}

function show() {
  return this.data;
}

function BST() {
  this.root = null;
  this.insert = insert;
  this.inOrder = inOrder;
  this.preOrder = preOrder;
  this.postOrder = postOrder;
  this.getMin = getMin;
  this.getMax = getMax;
  this.find = find;
  this.remove = remove;
  this.update = update;
}

function insert(data) {
  var n = new Node(data, null, null);
  if (this.root == null) {
    this.root = n;
  } else {
    var current = this.root;
    var parent;
    while (true) {
      parent = current;
      if (data < current.data) {
        current = current.left;
        if (current == null) {
          parent.left = n;
          break;
        }
      } else {
        current = current.right;
        if (current == null) {
          parent.right = n;
          break;
        }
      }
    }
  }
}

function inOrder(node) {
  if (node != null) {
    inOrder(node.left);
    console.log(node.show() + " ");
    inOrder(node.right);
  }
}

function preOrder(node) {
  if (node != null) {
    console.log(node.show() + " ");
    preOrder(node.left);
    preOrder(node.right);
  }
}

function postOrder(node) {
  if (node != null) {
    postOrder(node.left);
    postOrder(node.right);
    console.log(node.show() + " ");
  }
}

// BST Searches
function getMin() {
  var current = this.root;
  while (current.left != null) {
    current = current.left;
  }
  return current.data;
}

function getMax() {
  var current = this.root;
  while (current.right != null) {
    current = current.right;
  }
  return current.data;
}

function find(data) {
  var current = this.root;
  while (current != null && current.data != data) {
    if (data < current.data) {
      current = current.left;
    } else {
      current = current.right;
    }
  }
  return current;
}

function remove(data) {
  this.root = removeNode(this.root, data);
}

function removeNode(node, data) {
  if (node == null) {
    return null;
  }
  if (data == node.data) {
    if (node.left == null && node.right == null) {
      return null;
    }
    if (node.left == null) {
      return node.right;
    }
    if (node.right == null) {
      return node.left;
    }
    var tempNode = findMin(node.right); // Get smallest node on the right subtree
    node.data = tempNode.data;
    node.right = removeNode(node.right, tempNode.data);
    return node;
  } else if (data < node.data) {
    node.left = removeNode(node.left, data);
    return node;
  } else {
    node.right = removeNode(node.right, data);
    return node;
  }
}

function findMin(node) {
  var current = node;
  while (current.left != null) {
    current = current.left;
  }
  return current;
}

function update(data) {
  var grade = this.find(data);
  if (grade != null) {
    grade.count++;
  }
  return grade;
}

console.log("Load BST!");
var nums = new BST();
nums.insert(23);
nums.insert(45);
nums.insert(16);
nums.insert(37);
nums.insert(3);
nums.insert(99);
nums.insert(22);

console.log("Inorder traversal: ");
inOrder(nums.root);
console.log("Preorder traversal: ");
preOrder(nums.root);
console.log("Postorder traversal: ");
postOrder(nums.root);

var min = nums.getMin();
console.log("The minimum value of the BST is: " + min);
console.log("\n");
var max = nums.getMax();
console.log("The maximum value of the BST is: " + max);

console.log("\nEnter a value to search for: ");
rl.question("Enter a value to search for: ", function (value) {
  var intValue = parseInt(value);
  var found = nums.find(intValue);
  if (found != null) {
    console.log("Found " + intValue + " in the BST.");
  } else {
    console.log(intValue + " was not found in the BST.");
  }
  rl.close(); // Close the readline interface after input is handled
});
