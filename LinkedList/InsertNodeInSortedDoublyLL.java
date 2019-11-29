import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * Insert a node in a sorted doubly linked list
 * This took me most time. I probably underestimated this problem.
 * Also my solution is far from ideal.
 * <p>
 * Given a reference to the head of a doubly-linked list and an integer, data ,
 * create a new DoublyLinkedListNode object having data value 'data'
 * and insert it into a sorted linked list while maintaining the sort.
 *
 *
 *
 * <b>Sample Input</b>
 * <p>
 * 1
 * 4
 * 1
 * 3
 * 4
 * 10
 * 5
 *
 *
 * <b>Sample Output</b>
 * <p>
 * 1 3 4 5 10
 *
 * <b>Explanation</b>
 * <p>
 * The initial doubly linked list is:  1<->3<->4<->10
 * <p>
 * The doubly linked list after insertion is: 1<->3<->4<->5<->10
 *
 * <b>Approach</b>
 * This problem looks very easy if the simple case if considered, i.e. inserting a node between two nodes.
 * However it becomes complex when we consider the other edge cases :
 * 1. Inserting the node in the first place
 * 2. Inserting the node at last
 * 3. Inserting the node just before last.
 * <p>
 * Created three functions for it. This was necessary since the next, prev pointers will have different values in case of firstNode and lastNode
 * <p>
 * Algo :
 * <p>
 * 1. If the head is null, list is empty , hence create the new node and return it simply
 * 2. Compare the element with the head, if it is less than head, insert it before head and return the new node
 * 3. Traverse the list until either the end of the list or the listnode which is greater than newNode.
 * 4. If the listnode is the last node and the newNode is greater than listNode, insert the newNode as the last node
 * 5. If the listnode is NOT the last node, insert the newNode in between
 */

public class InsertNodeInSortedDoublyLL {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        // 1. If the head is null, list is empty , hence create the new node and return it simply
        if (head == null) {
            return newNode;
        }

        //2. Compare the element with the head, if it is less than head, insert it before head and return the new node
        if (head.data >= data) {
            insertFirstNode(head, newNode);
            return newNode;
        }


        //3. Traverse the list until either the end of the list or the listnode which is greater than newNode.
        while (current.next != null && current.data <= data) {
            current = current.next;
        }

        //4. If the listnode is the last node and the newNode is greater than listNode, insert the newNode as the last node
        if (current.next == null && current.data <= data) {
            insertLastNode(current, newNode);
        } else { //5. If the listnode is NOT the last node, insert the newNode in between
            insertNodeInBetween(current, newNode);
        }

        return head;


    }


    private static void insertNodeInBetween(DoublyLinkedListNode current, DoublyLinkedListNode newNode) {
        //Make the new node point to next and previous
        newNode.next = current;
        newNode.prev = current.prev;

        //Tinker with current and current's previous
        current.prev.next = newNode;
        current.prev = newNode;

    }


    private static void insertFirstNode(DoublyLinkedListNode current, DoublyLinkedListNode newNode) {
        //Make the new node point to next and previous
        newNode.next = current;
        current.prev = newNode;
    }

    private static void insertLastNode(DoublyLinkedListNode current, DoublyLinkedListNode newNode) {
        //Make the new node point to next and previous
        newNode.prev = current;
        current.next = newNode;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
