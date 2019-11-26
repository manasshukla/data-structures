import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * Merge two sorted linked list to form one sorted linked list
 *
 * You’re given the pointer to the head nodes of two sorted linked lists.
 * The data in both lists will be sorted in ascending order.
 * Change the next pointers to obtain a single, merged linked list which also has data in ascending order.
 * Either head pointer given may be null meaning that the corresponding list is empty.
 *
 *
 *
 * <b>Sample Input<b/>
 * 1
 * 3
 * 1
 * 2
 * 3
 * 2
 * 3
 * 4
 *
 *
 * <b>Sample Output</b>
 * 1 2 3 3 4
 *
 *
 * <b>Explanation</b>
 * The first linked list is: 1 -> 2 -> 3 -> NULL
 *
 * The second linked list is: 3 -> 4 -> NULL
 *
 * Hence, the merged linked list is: 1 -> 2 -> 3 -> 3 -> 4 -> NULL
 *
 */

public class MergeTwoSortedLinkedLists {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode dummy = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode head = dummy;

        while(head1 != null && head2!=null ){
            if(head1.data <= head2.data){
                dummy.next = head1;
                head1 = head1.next;

            }else{
                dummy.next = head2;
                head2 = head2.next;
            }

            dummy = dummy.next;

        }

        if(head1 != null){
            dummy.next = head1;
        }else{
            dummy.next = head2;
        }

        return head.next;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

            printSinglyLinkedList(llist3, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}