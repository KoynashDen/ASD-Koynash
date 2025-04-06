package Lab_6;

public class Queue {
    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public String dequeue() {
        if (this.front == null) {
            return null;
        }
        String data = this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return data;
    }

    public void printQueue() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getTotalLength() {
        int totalLength = 0;
        Node temp = front;
        while (temp != null) {
            totalLength += temp.data.length();
            temp = temp.next;
        }
        return totalLength;
    }
}
