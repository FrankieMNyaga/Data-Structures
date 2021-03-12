public class DoubleStack {
  private Object items;
  private int top1;
  private int top2;
  private int n;
  private int maxSize;
  public DoubleStack(int n) {
    items = new int[n];
    top1 = 0;
    top2 = 0;
    maxSize = n;
  }
  public boolean isEmpty1() {
    if (top1 == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  public boolean isEmpty2() {
    if (top2 == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  public boolean isFull1() {
    if (top1 == maxSize) {
      return true;
    }
    else {
      return false;
    }
  }
  public boolean isFull2() {
    if(top2 == maxSize) {
      return true;
    }
    else {
      return false;
    }
  }
}