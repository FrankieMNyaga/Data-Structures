public class BTS {
  private BSTNode root;
  public BTS() {
    root = null;
  }
  public BSTNode getRoot() {
    return root;
  }
  public void insert(int key, String data) {
    BSTNode parent = null;
    BSTNode trav = root;
    while (trav != null) {
      {
        parent = trav;
        if (key < trav.key) {
          trav = trav.left;
        }
        else {
          trav = trav.right;
        }
      }
      if (parent == null) {
        root = new BSTNode(key, data);
      }
      else if (key < parent.key) {
        parent.left = new BSTNode(key,data);
      }
      else {
        parent.right = new BSTNode(key,data);
      }
    }
  }
}