public class CircularLinkedList {

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node tail;


    public void traverse(Node tail){
        Node current = tail.next;
        while(current != tail){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

    public void insert(int data){
        Node node = new Node(data);
        if (tail == null){
            tail = node;
            tail.next = tail;
        }else {
            Node tmp = tail.next;
            node.next = tmp;
            tail.next = node;
            tail = node;

        }
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insert(10);
        circularLinkedList.insert(20);
        circularLinkedList.insert(30);
        circularLinkedList.insert(40);

        circularLinkedList.traverse(circularLinkedList.tail);


    }
}
