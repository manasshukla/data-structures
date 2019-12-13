import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


/**
 * Given bars of a unit width, calculate the largest rectangle in a histogram
 *
 * Sample Input
 * 5
 * 1 2 3 4 5
 *
 * Sample Output
 * 9
 *
 */
public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        Stack<Integer> s1 = new Stack<>();
        int max_area = 0, i=0;

        while(i < h.length){
            if(s1.empty() || h[s1.peek()] < h[i]){
                s1.push(i);
                i++;
            }else{
                int area = 0;
                int currentHeight = h[s1.pop()];
                if(s1.empty()){
                    area = currentHeight*i;
                }else{
                    area = currentHeight*(i-s1.peek()-1);
                }
                if(max_area < area) {
                    max_area = area;
                }
            }
        }

        while(!s1.empty()){
            int area = 0;
            int currentHeight = h[s1.pop()];
            if(s1.empty()){
                area = currentHeight*i;
            }else{
                area = currentHeight*(i-s1.peek()-1);
            }
            if(max_area < area) {
                max_area = area;
            }
        }

        return max_area;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
