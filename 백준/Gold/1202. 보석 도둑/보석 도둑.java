import java.io.*;
import java.util.*;

public class Main {
    static class Dia {
        int size, price;
        Dia(int size, int price) {
            this.size = size;
            this.price = price;
        }
    }

    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = read();
        int K = read();

        Dia[] dias = new Dia[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = read();
            int price = read();
            dias[i] = new Dia(size, price);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = read();
        }

        Arrays.sort(dias, (a, b) -> Integer.compare(a.size, b.size)); // 무게 오름차순
        Arrays.sort(bags); // 가방 무게 오름차순

        PriorityQueue<Integer> maxPricePQ = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        int idx = 0;
        for (int bag : bags) {
            while (idx < N && dias[idx].size <= bag) {
                maxPricePQ.add(dias[idx].price);
                idx++;
            }

            if (!maxPricePQ.isEmpty()) {
                sum += maxPricePQ.poll();
            }
        }

        System.out.println(sum);
    }

    static int read() {
        return Integer.parseInt(st.nextToken());
    }
}