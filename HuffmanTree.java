import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Map;
public class HuffmanTree {
  //scans input file and generates hashtable of characters and their frequencies
  public static HashMap scan(String fileName) {
    HashMap<Character, Integer> table = new HashMap<Character, Integer>();
    File file = new File(fileName);
    try(Scanner sc = new Scanner(file)) {
      int ctr = 0;
      char x = sc.next().charAt(ctr);
      while (sc.hasNext()) {
        if (table.containsKey(x)) {
          int tmpfreq = table.get(x);
          table.replace(x,tmpfreq,tmpfreq + 1);
        }
        else {
          table.put(x,1);
        }
        ctr++;
        x = sc.next().charAt(ctr);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return table;
  }
  //Creates priority queue of HuffmanNodes
  //I used a priority queue because it sorts the data in the optimal format for this project
  public static PriorityQueue createQueue(HashMap<Character,Integer> table) {
    PriorityQueue<HuffmanNode> pQueue = new PriorityQueue<HuffmanNode>(256);
    for (Map.Entry<Character, Integer> entry : table.entrySet()) {
      pQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
    }
    return pQueue;
  }
  //Recursively translates text into huffman code
  public static void getCharCode(HuffmanNode root, String letter, Map codeMap) {
    if (root == null) {
      return;
    }
    if (root.getLeft() == null && root.getRight() == null) {
      codeMap.put(root.getInChar(), letter);
    }
    getCharCode(root.getLeft(), letter + "0", codeMap);
    getCharCode(root.getRight(), letter + "1", codeMap);
  }
  //Main method which creates tree and translates into Hoffman Code using previous helper methods
  public static void huffmanCompressor(String inputFile, String outputFile) {
    PriorityQueue<HuffmanNode> pQueue = new PriorityQueue<HuffmanNode>();
    HashMap<Character, Integer> table = new HashMap<Character, Integer>();
    Map<Character, String> codeMap = new HashMap<Character, String>();
    table = scan(inputFile);
    pQueue = createQueue(table);
    while (pQueue.size() != 1) {
      HuffmanNode tempL = pQueue.poll();
      HuffmanNode tempR = pQueue.poll();
      int sum = tempL.getFrequency() + tempR.getFrequency();
      pQueue.add(new HuffmanNode('\0', sum, tempL, tempR));
    }
    HuffmanNode root = pQueue.peek();
    Map<Character, String> huffmanCodes = new HashMap();
    getCharCode(root, "", huffmanCodes);
    for (Map.Entry<Character, String> entry:huffmanCodes.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}