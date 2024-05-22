import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            String[] parts = str.split(" ");

            switch (parts[0]) {
                case "push":
                    push(stack, Integer.parseInt(parts[1]));
                    break;
                case "top":
                    top(stack, bw);
                    break;
                case "size":
                    size(stack, bw);
                    break;
                case "empty":
                    empty(stack, bw);
                    break;
                case "pop":
                    pop(stack, bw);
                    break;
            }
        }
        bw.flush();
    }

    public static void push(Stack<Integer> stack, int value) {
        stack.push(value);
    }

    public static void top(Stack<Integer> stack, BufferedWriter bw) throws IOException {
        if (!stack.isEmpty()) {
            bw.write(stack.peek() + "\n");
        } else {
            bw.write("-1\n");
        }
    }

    public static void size(Stack<Integer> stack, BufferedWriter bw) throws IOException {
        bw.write(stack.size() + "\n");
    }

    public static void empty(Stack<Integer> stack, BufferedWriter bw) throws IOException {
        if (stack.isEmpty()) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }
    }

    public static void pop(Stack<Integer> stack, BufferedWriter bw) throws IOException {
        if (!stack.isEmpty()) {
            bw.write(stack.pop() + "\n");
        } else {
            bw.write("-1\n");
        }
    }
}
