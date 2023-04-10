package dsaUsingJava;
public class LinkedList {
  private Node head;
  private Node tail;
  private int length = 0;

  class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if (length == 0)
      return null;
    Node temp = head;
    Node pre = head;
    while (temp.next != null) {
      pre = temp;
      temp = temp.next;
    }
    // edge case for only one node
    tail = pre;
    tail.next = null;
    length--;
    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public int get(int value) {
    if (value > length || value < 0)
      return -1;
    Node temp = head;
    // while(value!=0){
    // value--;
    // temp=temp.next;
    // }
    for (int i = 0; i < value; i++) {
      temp = temp.next;
    }
    return temp.value;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0)
      return null;

    Node temp = head;
    head = head.next;
    temp.next = null;
    length--;
    if (length == 0)
      tail = null;
    return temp;

  }

  public void reverse() {
    Node temp = head;
    head = tail;
    tail = temp;
    Node after = temp.next;
    Node before = null;
    for (int i = 0; i < length - 1; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  public Node remove(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    if (index == 0) {
      length--;
      return removeFirst();
    }
    if (index == length - 1) {
      length--;
      return removeLast();
    }
    Node prev = head;
    Node temp = head;
    for (int i = 0; i < index - 1; i++) {
      prev = temp;
      temp = temp.next;
    }
    prev.next = temp.next;
    length--;
    return temp;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }
    if (index == 0) {
      prepend(value);
      length++;
      return true;
    }
    if (index == length) {
      append(value);
      length++;
      return true;
    }
    Node newNode = new Node(value);
    Node temp = head;
    for (int i = 0; i < index - 1; i++) {
      temp = temp.next;
    }
    newNode.next = temp.next;
    temp.next = newNode;
    length++;
    return true;

  }

  public void getHead() {
    System.out.println("Head:" + head.value);
  }

  public void getTail() {
    System.out.println("Tail:" + tail.value);
  }

  public void getLength() {
    System.out.println("Length:" + length);
  }

  public static void main(String[] args) {
    LinkedList myLinkedList = new LinkedList();
    // myLinkedList.append(1);
    // myLinkedList.append(2);
    // myLinkedList.append(11);
    // myLinkedList.append(20);
    // myLinkedList.append(16);
    myLinkedList.prepend(5);
    myLinkedList.prepend(10);
    myLinkedList.append(0);
    myLinkedList.append(17);
    myLinkedList.append(30);
    myLinkedList.append(32);
    myLinkedList.append(6);
    myLinkedList.remove(3);
    if (myLinkedList.insert(6, 70) == false) {
      System.out.println("No such index");
    }
    // System.out.println(myLinkedList.removeFirst().value);
    // System.out.println(myLinkedList.removeFirst().value);
    // System.out.println(myLinkedList.removeFirst());
    // int value=myLinkedList.get(5);
    // if(value==-1){
    // System.out.println("No such index");
    // }else{
    // System.out.println("value in given index "+value);
    // }
    myLinkedList.printList();
    myLinkedList.reverse();
    System.out.println("After reverse \n\n\n\n");
    myLinkedList.printList();
    // myLinkedList.getHead();
    // myLinkedList.getTail();
    // myLinkedList.getLength();
    // System.out.println(myLinkedList.removeLast().value);
    // System.out.println(myLinkedList.removeLast().value);
    // System.out.println(myLinkedList.removeLast());
  }

}
