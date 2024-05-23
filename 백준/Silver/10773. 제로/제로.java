import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        
        for (int i = 0; i < num; i++) {
            int j = Integer.parseInt(br.readLine()); 
            if (j == 0) {
                stack.pop();
            }else stack.push(j);
        }
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}