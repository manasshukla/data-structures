import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    static String s = "";
    static Stack<String> stack = new Stack<>();

    public static void append(String str){
        s = s+str;
        stack.push(s);
    }

    public static void delete(int k){
        if(!stack.isEmpty()){
            String currentString = stack.peek();
            stack.push(currentString.substring(0,currentString.length()-k));
        }
    }

    public static void print(int k){
        if(!stack.isEmpty()){
            System.out.println(stack.peek().charAt(k-1));
        }
    }

    public static void undo(){
        if(!stack.isEmpty()){
            stack.pop();
        }
    }



    public static void main(String[] args) {
        stack.push(s);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int choice = sc.nextInt();
            if(choice == 1) {
                String val = sc.nextLine().trim();
                //append
                append(val);
            } else if(choice == 2) {
                //delete
                int k = sc.nextInt();
                delete(k);
            } else if(choice == 3) {
                //print
                int k = sc.nextInt();
                print(k);
            }else if(choice == 4) {
                //undo
                undo();
            }else{
                System.out.println("Invalid input");
            }

            n--;
        }
        sc.close();
    }
}
