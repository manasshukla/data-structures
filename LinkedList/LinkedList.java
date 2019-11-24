public class LinkedList {

    public Node head;

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

    public void insertFirst(int node_val){
        Node node = new Node(node_val);
        node.next = head;
        head = node;
    }

    public void traverse(){
        Node current = head;
        while(current.next != null){
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println(current.value);


    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.traverse();
    }
}
