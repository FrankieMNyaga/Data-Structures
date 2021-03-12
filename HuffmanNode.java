public class HuffmanNode {
  private char inChar;
  private int frequency;
  private HuffmanNode left;
  private HuffmanNode right;
  public HuffmanNode(char inChar, int frequency, HuffmanNode left, HuffmanNode right) {
    this.inChar =inChar;
    this.frequency = frequency;
    this.left = left;
    this.right = right;
  }
  HuffmanNode(char inChar, int frequency) {
    this.inChar = inChar;
    this.frequency = frequency;
  }
  public int getFrequency() {
    return this.frequency;
  }
  public HuffmanNode getLeft() {
    return this.left;
  }
  public HuffmanNode getRight() {
    return this.right;
  }
  public char getInChar() {
    return this.inChar;
  }
}
  