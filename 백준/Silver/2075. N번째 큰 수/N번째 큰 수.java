import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < count; i++) {
            String[] str = reader.readLine().split(" ");
            for (int j = 0; j < count; j++) {
                int num = Integer.parseInt(str[j]);
                if (heap.size() < count) {
                    heap.add(num);
                } else if (num > heap.peek()) {
                    heap.poll();
                    heap.add(num);
                }
            }
        }

        System.out.println(heap.peek());
    }
}