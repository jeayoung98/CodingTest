import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num; i++) {
            deque.add(i+1);
        }
        while (deque.size() > 1) {
            shuffle(deque);
        }
        System.out.println(deque.peek());
    }

    public static void shuffle(Deque<Integer> deque) {
        deque.removeFirst();
        deque.add(deque.removeFirst());

    }
}