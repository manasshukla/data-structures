/**
 * This class deals with the basic operations of Linked Lists viz insert, insert at first location, traverse
 */
public class LinkedList {

    public Node head;

    /**
     * insert the node value at the last of list
     * @param node_val
     */
    public void insert(int node_val){

        Node node = new Node(node_val);
        if(head == null){
            head = node;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }

    /**
     * insert the value at the head of linked list.
     * @param node_val
     */
    public void insertFirst(int node_val){
        Node node = new Node(node_val);
        node.next = head;
        head = node;
    }

    /**
     * traverse the linked list and printout all the elements in it.
     */
    public void traverse(){
        Node current = head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void insertAtPosition(int position, int data){
        Node node = new Node(data);
        Node current = head;

        //position = 0, insert the new node as head
        if(position == 0){
            node.next = head;
            head = node;
        }
        for (int i = 0; i < position-1; i++) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;
    }


    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);

        list.insertAtPosition(0, 70);

        list.traverse();
    }

}
