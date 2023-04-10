
package dsaUsingJava;

public class doublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public doublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;

    }

    public void getHead() {
        System.out.println("head " + head.value);
    }

    public void getTail() {
        System.out.println("tail " + tail.value);
    }

    public void getLength() {
        System.out.println("Length " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        Node temp = tail;
        tail = temp.prev;
        tail.next = null;
        temp.prev = null;
        if (length == 0) {
            head = null;
            tail = null;
        }
        length--;
        return temp;
    }

    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
        }
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        head.prev = null;
        if (length == 0) {
            head = null;
            tail = null;
        }
        length--;
        return temp;

    }

    public boolean insert(int index, int value) {
        if (index < 0 || index >= length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
        }
        if (index == length - 1) {
            append(value);
        } else {
            Node temp = head;
            Node newNode = new Node(value);
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node after = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            after.prev = newNode;
        }
        length++;
        return true;

    }

    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;
        if (index == 0) {
            length--;
            return removeFirst();

        }
        if (index == length - 1) {
            length--;
            return removeLast();
        }
        Node temp = head;
        // Node before = head;
        for (int i = 0; i < index - 1; i++) {
            // before = temp;
            temp = temp.next;
        }
        // Node after = temp.next;
        // temp.prev = after.prev;
        // before.next = after;
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp.next;
        while (temp != null) {
            after = temp.next;
            temp.next = before;
            temp.prev = after;
            before = temp;
            temp = after;
        }
    }

    public static void main(String[] args) {
        doublyLinkedList dll = new doublyLinkedList(8);
        // dll.getHead();
        // dll.getTail();
        // dll.getLength();
        dll.append(10);
        dll.append(13);
        dll.append(20);
        dll.append(22);
        dll.printAll();
        System.out.println("Value of last removed node " + dll.removeLast().value);
        dll.printAll();
        System.out.println("After prepend");
        dll.prepend(17);

        dll.printAll();

        System.out.println("After removing first");
        dll.removeFirst();
        dll.printAll();
        System.out.println("Printing after insert");
        dll.insert(2, 5);
        dll.insert(dll.length - 1, 99);
        dll.insert(4, 89);
        dll.printAll();
        System.out.println("After removing ");
        System.out.println("Removed node :" + dll.remove(3).value);
        dll.printAll();
        System.out.println("After reverse ");
        dll.reverse();
        dll.printAll();

    }
}
