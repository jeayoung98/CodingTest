import java.io.*;
import java.util.*;

public class Main {
    static class Flower implements Comparable<Flower> {
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower flower) {
            if (this.start == flower.start) {
                return flower.end - this.end;
            }
            return this.start - flower.start;
        }
    }
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int cal(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr[0]; i++) {
            sum += days[i];
        }
        return sum + arr[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int start = cal(new int[] {arr[0],arr[1]});
            int end = cal(new int[]{arr[2],arr[3]}) - 1;
            flowers.add(new Flower(start, end));
        }

        Collections.sort(flowers);

        int startDay = cal(new int[] {3,1});
        int endDay = cal(new int[] {11,30});

        int count = 0;
        int index = 0;
        int maxEnd = 0;

        while (startDay <= endDay) {
            boolean isUpdate = false;

            while (index < N && flowers.get(index).start <= startDay) {
                if (flowers.get(index).end > maxEnd) {
                    maxEnd = flowers.get(index).end;
                }
                index++;
                isUpdate = true;
            }

            if (!isUpdate && maxEnd < startDay) {
                System.out.println(0);
                return;
            }

            if (maxEnd < startDay) {
                System.out.println(0);
                return;
            }
            startDay = maxEnd + 1;
            count++;

            if (startDay > endDay) break;
        }

        System.out.println(count);
    }
}
