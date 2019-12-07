import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a stack using 1 queue
 *
 *Approach :
 * 1. Get the size of the queue before inserting the element.
 * 2. Now insert the element
 * 3. Loop the queue for the size of the queue before inserting the element(found in step1)
 *      4. Dequeue the elelemt (head)
 *      5. enqueue the element (now head element will become tail)
 *
 *
 * Example :
 *
 * Element : 1,2,3
 *
 * Iter 1 : Push 1
 * Size = 0
 * Queue : 1
 *
 * Iter 2: Push 2
 * Size = 1
 * Queue = 1, 2
 * Now for size 1 do dequeue and enqueue
 * Dequeue :
 * Queue : 2 , element = 1
 *
 * Enqueue :
 * Queue : 2, 1
 *
 *
 */

public class StackUsingQueue {

    Queue<Integer> queue1 = new LinkedList<>();

    public void push(int n){
        int size = queue1.size();
        queue1.add(n);
        for (int i = 0; i < size ; i++) {
            queue1.add(queue1.remove());
        }
    }

    public int pop(){
        return queue1.remove();
    }


    public static void main(String[] args) {
        StackUsingQueue scq = new StackUsingQueue();
        scq.push(1);
        scq.push(2);
        scq.push(3);
        scq.push(4);
        scq.push(5);
        scq.push(6);
        System.out.println(scq.pop());
        System.out.println(scq.pop());
        System.out.println(scq.pop());
        System.out.println(scq.pop());
        System.out.println(scq.pop());
        System.out.println(scq.pop());
    }
}
