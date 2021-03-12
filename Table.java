import java.util.ArrayList;
import java.lang.StringBuilder;
//Node class
class HashNode<K, V> {
  public K key;
  public V value;
  public HashNode<K, V> next;
  //Node constructor
  public HashNode (K key, V value) {
    this.key = key;
    this.value = value;
  }
}
//table class
class Table<K,V> {
  private ArrayList<HashNode<K, V>> bucketList;
  private int buckets;
  private int size;
  //constructor for table
  public Table() {
    bucketList = new ArrayList<>();
    buckets = 10;
    size = 0;
    for (int i = 0; i < buckets; i++) {
      bucketList.add(null);
    }
  }
  //returns size
  public int size() {
    return size;
  }
  //returns true if table is empty and false otherwise
  public boolean isEmpty() {
    if (size() == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  public V getValue (K key) {
    //setting head of chain
    int index = getBucket(key);
    HashNode<K, V> head = bucketList.get(index);
    while (head != null) {
      //if the key being searched is the head node
      if (head.key == key) {
        return head.value;
      }
      //incrementing to next node
      head = head.next;
    }
    //Key is not in table
    return null;
  }
  //Changes value at given key to desired value (param value)
  public void setValue(K key, V value) {
    int index = getBucket(key);
    HashNode<K, V> head = bucketList.get(index);
    head.value = value;
  }
  public void add(K key, V value) {
    //finding head of chain
    int index = getBucket(key);
    HashNode<K, V> head = bucketList.get(index);
    //checks if key is already in the table
    while (head != null) {
      if (head.key == key) {
        head.value = value;
        return;
      }
      head = head.next;
    }
    //inserting
    size++;
    head = bucketList.get(index);
    HashNode<K, V> node = new HashNode<K, V>(key, value);
    node.next = head;
    bucketList.set(index, node);
    //if bucket is nearly full double size of table
    if (((double) size)/ buckets >= 0.8)
    {
      ArrayList<HashNode<K, V>> tmp = bucketList;
      bucketList = new ArrayList<>();
      buckets *= 2;
      size = 0;
      for (int i = 0; i < buckets; i++) {
        bucketList.add(null);
      }
      for (HashNode<K, V> front : tmp)
      {
        while (head != null)
        {
          this.add(front.key, front.value);
          front = front.next;
        }
      }
    }
  }
  //returns index for key
  private int getBucket(K key) {
    int hashCode = Math.abs(key.hashCode());
    int index = hashCode % buckets;
    return index;
  }
  public V remove(K key) {
    //Helper method to find index for key
    int index = getBucket(key);
    HashNode<K, V> head = bucketList.get(index);
    HashNode<K, V> prev = null;
    while (head != null) {
      if (head.key == key) {
        break;
      }
        prev = head;
        head = head.next;
    }
    if (head == null) {
      return null;
    }
    size--;
    if (prev != null) {
      prev.next = head.next;
    }
    else {
      bucketList.set(index, head.next);
    }
    return head.value;
  }
  //returns String of table entries
  public String tableToString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < this.size() - 1; i++) {
      builder.append("(");
      builder.append(this.bucketList.get(i).key);
      builder.append(" ");
      builder.append(this.bucketList.get(i).value);
      builder.append(")");
    }
    return builder.toString();
  }
}