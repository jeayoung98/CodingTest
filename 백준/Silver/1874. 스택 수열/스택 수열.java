import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        boolean isComplete = true;
        int j = 0;
        for (int i = 0; i < num; i++) {
            int number = Integer.parseInt(reader.readLine());
            if (j < number) {
                while (j < number ) {
                    ++j;
                    stack.push(j);
                    list.add("+");
                }
            }
            if (stack.peek() == number) {
                stack.pop();
                list.add("-");
            }
            else if (j > number) {
                isComplete = false;
                break;
            }
        }
        reader.close();
        if (isComplete) {
            for (String str : list) {
                System.out.println(str);
            }
        }
        else System.out.println("NO");

    }
}