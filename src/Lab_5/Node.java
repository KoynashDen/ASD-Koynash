package Lab_5;

public class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}