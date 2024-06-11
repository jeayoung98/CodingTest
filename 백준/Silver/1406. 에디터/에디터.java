import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> leftStack = new Stack<>();
    static Stack<Character> rightStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        for (char ch : str.toCharArray()) {
            leftStack.push(ch);
        }

        int num = Integer.parseInt(reader.readLine());
        for (int i = 0; i < num; i++) {
            String[] command = reader.readLine().split(" ");
            switch (command[0]) {
                case "L":
                    L();
                    break;
                case "D":
                    D();
                    break;
                case "B":
                    B();
                    break;
                case "P":
                    leftStack.push(command[1].charAt(0));
                    break;
            }
        }

        // 결과 문자열 생성
        StringBuilder result = new StringBuilder();
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }
        System.out.println(result.toString());
    }

    public static void L(){
        if (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
    }

    public static void D() {
        if (!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
    }

    public static void B() {
        if (!leftStack.isEmpty()) {
            leftStack.pop();
        }
    }
}