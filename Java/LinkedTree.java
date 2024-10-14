package Java;

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

public class LinkedTree {
  private TreeNode root;

  public LinkedTree() {
    root = null;
  }

  public void insert(int data) {
    root = insertRec(root, data);
  }

  private TreeNode insertRec(TreeNode root, int data) {
    if (root == null) {
      root = new TreeNode(data);
      return root;
    }

    if (data < root.data) {
      root.left = insertRec(root.left, data);
    } else if (data > root.data) {
      root.right = insertRec(root.right, data);
    }

    return root;
  }

  public boolean search(int data) {
    return searchRec(root, data);
  }

  private boolean searchRec(TreeNode root, int data) {
    if (root == null) {
      return false;
    }

    if (data == root.data) {
      return true;
    } else if (data < root.data) {
      return searchRec(root.left, data);
    } else {
      return searchRec(root.right, data);
    }
  }

  // Add other update methods as needed

  public static void main(String[] args) {
    LinkedTree tree = new LinkedTree();
    tree.insert(5);
    tree.insert(3);
    tree.insert(7);

    System.out.println(tree.search(7)); // Output: true
    System.out.println(tree.search(10)); // Output: false
  }
}