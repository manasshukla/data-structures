import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Given two singly linked list, find their merge point
 * Given pointers to the head nodes of  linked lists that merge together at some point, find the Node where the two lists merge.
 * It is guaranteed that the two head Nodes will be different, and neither will be NULL.
 *
 * In the diagram below, the two lists converge at Node x:
 *
 * [List #1] a--->b--->c
 *                      \
 *                       x--->y--->z--->NULL
 *                      /
 *      [List #2] p--->q
 *
 *
 *<b>Sample Input</b>
 * The diagrams below are graphical representations of the lists that input Nodes  and  are connected to. Recall that this is a method-only challenge; the method only has initial visibility to those  Nodes and must explore the rest of the Nodes using some algorithm of your own design.
 *
 * Test Case 0
 *
 *  1
 *   \
 *    2--->3--->NULL
 *   /
 *  1
 * Test Case 1
 *
 * 1--->2
 *       \
 *        3--->Null
 *       /
 *      1
 *
 *
 * <b>Sample Output</b>
 * 2
 * 3
 *
 *
 * <b>Explanation</b>
 * Test Case 0: As demonstrated in the diagram above, the merge Node's data field contains the integer .
 * Test Case 1: As demonstrated in the diagram above, the merge Node's data field contains the integer .
 *
 *<b>Approach</b>
 * 1. Find the length of both the lists
 * 2. Find their difference, call it d
 * 3. Now traverse 'd' nodes from the larger list to make both the lists are equal
 * 4. Compare the current node of both the lists , if they are equal this is the merge point.
 * 5. If the current node of both the lists are not equal, move to the next node in both the list
 * 6. Repeat step 5 until a merge point is found.
 */

public class FindMergePointOfTwoList {

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

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int length1 = findLength(head1);
        int length2 = findLength(head2);

        if(length1>length2){
            head1 = traverse(head1, length1-length2);
        }else{
            head2 = traverse(head2, length2-length1);
        }

        while(head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1.data;

    }

    private static int findLength(SinglyLinkedListNode head){
        int length = 0;

        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    private static SinglyLinkedListNode traverse(SinglyLinkedListNode head, int count){
        while(count != 0){
            head = head.next;
            count --;
        }
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

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

            SinglyLinkedListNode ptr1 = llist1.head;
            SinglyLinkedListNode ptr2 = llist2.head;

            for (int i = 0; i < llist1Count; i++) {
                if (i < index) {
                    ptr1 = ptr1.next;
                }
            }

            for (int i = 0; i < llist2Count; i++) {
                if (i != llist2Count-1) {
                    ptr2 = ptr2.next;
                }
            }

            ptr2.next = ptr1;

            int result = findMergeNode(llist1.head, llist2.head);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
