import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (num == 0) {
                if (heap.isEmpty()) {
                    writer.write(0 + "\n");
                }else writer.write(heap.poll()+"\n");
            }else heap.add(num);
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
