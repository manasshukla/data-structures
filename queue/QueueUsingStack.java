import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class QueueUsingStack {

    static Stack <Integer> stack1 = new Stack<>();
    static Stack <Integer> stack2 = new Stack<>();

    public static void enqueue(int n){
        stack1.push(n);
    }

    public static int dequeue(){
        if(stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void print(){
        if(stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println(stack2.peek());
    }


    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());




        while (n > 0) {
            String inp = br.readLine();
            String inpArr[] =  inp.split(" ");
            int choice = Integer.parseInt(inpArr[0]);

            if(choice == 1) {
                int val = Integer.parseInt(inpArr[1]);
                //enqueue
                enqueue(val);
            } else if(choice == 2) {
                //dequeue
                dequeue();
            } else if(choice == 3) {
                //print
                print();
            }else{
                System.out.println("Invalid input");
            }

            n--;
        }
        br.close();

    }

}
