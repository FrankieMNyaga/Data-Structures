public class BSTNode {
  public String data;
  public BSTNode left;
  public BSTNode right;
  public int key;
  public BSTNode(int key, String data) {
    this.data = data;
    this.key = key;
    right = null;
    left = null;
  }
  public BSTNode getRight() {
    return right;
  }
  public BSTNode getLeft() {
    return left;
  }
  public int getKey() {
    return key;
  }
  public String getData() {
    return data;
  }
  public void setRight(BSTNode r) {
    this.right = r;
  }
  public void setLeft(BSTNode l) {
    this.left = l;
  }
}