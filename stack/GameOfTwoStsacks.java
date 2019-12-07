import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class GameOfTwoStsacks {

    /*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */
        Stack<Integer> stack1 = populateStacksWithReverseArray(a);
        Stack<Integer> stack2 = populateStacksWithReverseArray(b);
        Stack<Integer> stack3 = populateStacksWithReverseArray(b);

        int count = 0, sum = 0;
//        while ((sum += stack1.peek()) <= x) {
//           stack3.push(stack1.pop());
//           count++;
//        }
//        while(! stack2.isEmpty()){
//            sum += stack2.pop();
//            count++;
//
//            while(sum>x){
//                sum-=
//            }
//        }
//        while(sum > x ){
//            sum-=stack3.pop();
//            count --;
//        }

        return count;
    }


    private static Stack<Integer> populateStacksWithReverseArray(int[] h) {
        Stack<Integer> stack = new Stack<>();
        for (int i = h.length - 1; i >= 0; i--) {
            stack.push(h[i]);
        }

        return stack;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
