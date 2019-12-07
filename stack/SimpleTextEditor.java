import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimpleTextEditor {

    static String s = "";
    static Stack<String> stack = new Stack<>();
    static List<Character> result = new ArrayList<>();

    public static void  append(String str){
        s = s+str;
        stack.push(s);
    }

    public static void delete(int k){
            s = s.substring(0,s.length()-k);
            stack.push(s);
    }

    public static void  print(int k){
           result.add(stack.peek().charAt(k-1));
    }

    public static void undo(){
           stack.pop();
           s = stack.peek();
    }



    public static void main(String[] args) throws IOException {

        stack.push(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        while (n > 0) {
            String inp = br.readLine();
            String inpArr[] =  inp.split(" ");
            int choice = Integer.parseInt(inpArr[0]);

            if(choice == 1) {
                String val = inpArr[1];
                //append
                append(val);
            } else if(choice == 2) {
                //delete
                int k = Integer.parseInt(inpArr[1]);
                delete(k);
            } else if(choice == 3) {
                //print
                int k = Integer.parseInt(inpArr[1]);
                print(k);
            }else if(choice == 4) {
                //undo
                undo();
            }else{
                System.out.println("Invalid input");
            }

            n--;
        }
        br.close();

        result.stream().forEach(i -> System.out.println(i));
    }
}
