import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * Reverse a doubly linked list
 * Given the pointer to the head node of a doubly linked list.
 * Reverse the order of the nodes in the list.
 * The head node might be NULL to indicate that the list is empty.
 * Change the next and prev pointers of all the nodes so that the direction of the list is reversed.
 * Return a reference to the head node of the reversed list.
 *
 *
 *<b>Sample Input</b>
 * 1
 * 4
 * 1
 * 2
 * 3
 * 4
 *
 *
 * <b>Sample Output</b>
 * 4 3 2 1
 *
 *
 * <b>Explanation</b>
 * The initial doubly linked list is:  1<->2<->3<->4->NULL
 *
 * The reversed doubly linked list is: 4<->3<->2<->1->NULL
 *
 * <b>Approach</b>
 * This was a simple problem to solve. The idea is to swap the next and previous pointers in a node.
 * If we swap the next and previous pointers of every node in a doubly linked list, the linked list would be reversed
 *
 * <b>Algo</b>
 * 1. Traverse the list, while (current != null)
 * 2. for each node in the list :
 *      a) keep a copy of the node,
 *      b) reverse the next and previous of the node
 *      c) move to the next node
 *
 * It is essential that we create a copy of the node before swapping since at the last iteration the current node would be null
 * hence if we just return the null current node, it would not be possible to traverse the reversed list
 *
 * Since, "current", being the iterator variable, has a value of "null" when the loop ends (hence newHead being assigned temp's value before temp is updated).
 *
 */

public class ReverseDoublyLinkedList {

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

    // Complete the reverse function below.

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
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode onebeforeCurrent = head;

        // * 1. Traverse the list, while (current != null)
        while(current != null){
            // a) keep a copy of the node,
            // This is necessary because "current", being the iterator variable, has a value of "null" when the loop ends (hence newHead being assigned temp's value before temp is updated).
            onebeforeCurrent = current;
            // b) reverse the next and previous of the node
            DoublyLinkedListNode tmp = current.next;
            current.next = current.prev;
            current.prev = tmp;
            // c) move to the next node
            current = tmp;
        }

        return onebeforeCurrent;

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

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
