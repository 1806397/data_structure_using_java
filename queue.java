package dsaUsingJava;

public class queue {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void getFirst() {
        System.out.println("First: " + first.value);
    }

    public void getLast() {
        System.out.println("Last: " + last.value);
    }

    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        length = 1;
    }

    public void Enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        length++;
    }

    public Node Dequeue() {
        if (length == 0)
            return null;
        Node temp = first;
        while (temp.next != last) {
            temp = temp.next;
        }
        last = temp;
        temp = temp.next;
        last.next = null;
        temp.next = null;
        length--;
        if (length == 0) {
            first = null;
            last = null;
        }
        return temp;
    }

    public static void main(String[] args) {
        queue q = new queue(5);
        q.print();
        q.getLength();
        q.getFirst();
        q.getLast();
        System.out.println("After Enqueue");
        q.Enqueue(10);
        q.Enqueue(8);
        q.Enqueue(3);
        q.print();
        System.out.println("After Dequeue " + q.Dequeue().value);
        System.out.println("After Dequeue " + q.Dequeue().value);

        q.print();
    }
}
