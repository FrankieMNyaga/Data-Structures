import java.util.NoSuchElementException;
public class PhBLinkedList extends PhoneBook{
  //Stores head node
  private Person head;
  //Default constructor 
  public PhBLinkedList() {
    head = null;
  }
  //Returns front node
  protected Person getFront() {
    return head;
  }
  //Sets front node to parameter Person p
  protected void setFrontPerson(Person p) {
    head = p;
  }
  //Iterator implementation
  private class Iterator implements PhBIterator {
    //Stores head node
    private Person current = head;
    //Returns true if there is next element, false if there is no next element O(n)
    public boolean hasNext() {
      if (current.getNext() == null) {
        return false;
      }
      else {
        return true;
      }
    }
    //If there is next element returns next element, if there is no next element returns null O(n)
    public Person next() {
      if (current.getNext() != null) {
        Person temp = current; 
        current = current.getNext();
        return temp;
      }
      else 
        return null; 
    }
  }
  //Returns current size of sequence O(n)
  public int size() {
    Iterator itr = new Iterator();
    int count = 1;
    while (itr.hasNext()) {
      itr.next();
      count++;
    }
    return count;
  }
  //Inserts parameter Person person before i-th component of sequence, parameter i is position of insertion O(n^2)
  public void insert(int i, Person person) {
    if (head == null) {
        head = person;
        return; 
    }
    //Checks if there is head node and programmer wishes to add parameter person to index 0
    if (head != null && i == 0) {
      Person oldHead = head;
      this.setFrontPerson(person);
      person.setNextPerson(oldHead);
      return; 
    }
    Iterator itr = new Iterator();
    Person temp = head;
    //Checks if programmer wishes to add parameter person to an index equal to or larger than size of sequence
    if (this.size() - 1 <= i) {
      while (itr.hasNext()) {
        temp = itr.next();
      }
      temp.setNextPerson(person);
      return; 
    }
    //Checks if there is head node and programmer wishes to add perameter person to an index less than the size of the sequence -1
    if (head != null && i < this.size() - 1) {
      if (this.lookup(i + 1) != null) {
        person.setNextPerson(this.lookup(i + 1));
      }
      //If there is no person in the sequence at the index after i, the next person in the sequence is set to null
      else {
        person.setNextPerson(null);
      }
      Person previous = this.lookup(i - 1);
      previous.setNextPerson(person);
    }
  }
  //Remove element at position i, returns element removed O(n)
  public Person remove(int i) {
    //if list is empty
    if (head == null) {
      return null;
    }
    Person temp = head;
    //if head node is being removed
    if (i == 1) {
      head = temp.getNext();
      return this.getFront();
    }
    int count = 1;
    //Locates node before node to be deleted
    while (temp != null && count < i-1) {
      temp = temp.getNext();
      count++;
    }
    //returns null if position is after final node
    if (temp == null || temp.getNext() == null) {
      return null;
    }
    Person next = temp.getNext().getNext();
    Person removed = this.lookup(i);
    temp.setNextPerson(next);
    return removed;
  }
  //returns element at position i O(n^2)
  public Person lookup(int i) {
    if (this.size() >= i) {
      Iterator itr = new Iterator();
      int count = 1;
      Person current = this.getFront();
      while (current != null) {
        if(count == i) {
          return current;
        }
        else {
          count++;
          current = current.getNext();
        }
      }
    }
    else {
      throw new NoSuchElementException();
    }
    return null;
  }
}