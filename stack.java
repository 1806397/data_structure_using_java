package dsaUsingJava;

public class stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void Push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;

    }

    public Node Pop() {
        if (height == 0)
            return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public void getTop() {
        System.out.println("TOP: " + top.value);
    }

    public void getHeight() {
        System.out.println("HEIGHT: " + height);
    }

    public void print() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.Stack(5);
        s.Push(3);
        s.Push(7);
        System.out.println("After push");
        s.print();
        s.getTop();
        s.getHeight();
        System.out.println("Poped value: " + s.Pop().value);
        s.print();
        s.getTop();
        s.getHeight();

    }
}
