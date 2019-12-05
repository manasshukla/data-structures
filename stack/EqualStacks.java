import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.
 *
 * Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.
 *
 * Note: An empty stack is still a stack.
 *
 * Sample Input
 *
 * 5 3 4
 * 3 2 1 1 1
 * 4 3 2
 * 1 1 4 1
 * Sample Output
 *
 * 5
 *
 */
public class EqualStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        int height1 = Arrays.stream(h1).sum();
        int height2 = Arrays.stream(h2).sum();
        int height3 = Arrays.stream(h3).sum();

        populateStacksWithReverseArray(stack1, h1);

        populateStacksWithReverseArray(stack2, h2);

        populateStacksWithReverseArray(stack3, h3);


        while (!(height1 == height2 && height2 == height3)){
            if(height1 ==0 || height2 ==0 || height3 ==0){
                return 0;
            }
            if(height1 > minHeight(height1, height2, height3)){
                height1 = height1 - stack1.pop();
            }
            if(height2 >minHeight(height1, height2, height3)){
                height2 = height2 - stack2.pop();
            }

            if(height3 >minHeight(height1, height2, height3)){
                height3 = height3 - stack3.pop();
            }
        }

        return height1;
    }

    private static void populateStacksWithReverseArray(Stack<Integer> stack, int[] h) {
        for (int i = h.length-1; i >= 0; i--) {
            stack.push(h[i]);
        }
    }

    private static int minHeight(int height1, int height2, int height3){
        return Math.min(Math.min(height1, height2), height3);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
