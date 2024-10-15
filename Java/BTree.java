package Java;

import java.util.ArrayList;
import java.util.List;

class BTreeNode {
  List<Integer> keys;
  List<BTreeNode> children;
  boolean leaf;

  public BTreeNode(boolean leaf) {
    this.leaf = leaf;
    this.keys = new ArrayList<>();
    this.children = new ArrayList<>();
  }
}

public class BTree {
  private BTreeNode root;
  private int blockSize;

  public BTree(int blockSize) {
    this.root = new BTreeNode(true);
    this.blockSize = blockSize;
  }

  public void insert(int key) {
    BTreeNode r = root;
    if (r.keys.size() == 2 * blockSize - 1) {
      BTreeNode s = new BTreeNode(false);
      root = s;
      s.children.add(r);
      splitChild(s, 0);
      insertNonFull(s, key);
    } else {
      insertNonFull(r, key);
    }
  }

  private void splitChild(BTreeNode x, int i) {
    BTreeNode z = new BTreeNode(x.children.get(i).leaf);
    BTreeNode y = x.children.get(i);
    x.keys.add(i, y.keys.get(blockSize - 1));
    x.children.add(i + 1, z);

    for (int j = 0; j < blockSize - 1; j++) {
      z.keys.add(j, y.keys.get(j + blockSize));
    }
    y.keys.subList(blockSize - 1, 2 * blockSize - 1).clear();

    if (!y.leaf) {
      for (int j = 0; j < blockSize; j++) {
        z.children.add(j, y.children.get(j + blockSize));
      }
      y.children.subList(blockSize, 2 * blockSize).clear();
    }
  }

  private void insertNonFull(BTreeNode x, int key) {
    int i = x.keys.size() - 1;
    if (x.leaf) {
      x.keys.add(key);
      while (i >= 0 && key < x.keys.get(i)) {
        x.keys.set(i + 1, x.keys.get(i));
        i--;
      }
      x.keys.set(i + 1, key);
    } else {
      while (i >= 0 && key < x.keys.get(i)) {
        i--;
      }
      i++;
      if (x.children.get(i).keys.size() == 2 * blockSize - 1) {
        splitChild(x, i);
        if (key > x.keys.get(i)) {
          i++;
        }
      }
      insertNonFull(x.children.get(i), key);
    }
  }

  public boolean search(int key) {
    return searchKey(root, key);
  }

  private boolean searchKey(BTreeNode x, int key) {
    int i = 0;
    while (i < x.keys.size() && key > x.keys.get(i)) {
      i++;
    }
    if (i < x.keys.size() && key == x.keys.get(i)) {
      return true;
    }
    if (x.leaf) {
      return false;
    } else {
      return searchKey(x.children.get(i), key);
    }
  }

  public static void main(String[] args) {
    BTree bTree = new BTree(512); // Block size of 1024
    bTree.insert(10);
    bTree.insert(20);
    bTree.insert(5);
    System.out.println(bTree.search(10)); // Output: true
    System.out.println(bTree.search(15)); // Output: false
  }
}