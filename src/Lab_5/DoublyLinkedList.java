package Lab_5;

public class DoublyLinkedList {
    Node head, tail;

    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    Node findNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    Node[] moveBetween(Node px, Node py) {
        if (px == null || py == null || px == py) {
            return new Node[]{head, null};
        }

        Node current = px.next;
        DoublyLinkedList newList = new DoublyLinkedList();

        while (current != null && current != py) {
            newList.append(current.data);
            current = current.next;
        }

        if (px.next != py) {
            px.next = py;
            py.prev = px;
        }

        return new Node[]{head, newList.head};
    }
}
