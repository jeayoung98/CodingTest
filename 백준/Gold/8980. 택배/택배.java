import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Package {
        int from, to, weight;

        public Package(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int K = Integer.parseInt(br.readLine());

        List<Package> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            String[] s1 = br.readLine().split(" ");
            int from = Integer.parseInt(s1[0]);
            int to = Integer.parseInt(s1[1]);
            int weight = Integer.parseInt(s1[2]);
            list.add(new Package(from, to, weight));
        }

        list.sort((a, b) -> {
            if (a.to == b.to) {
                return a.from - b.from;
            }
            return a.to - b.to;
        });

        int[] truckLoad = new int[N + 1];
        int result = 0;

        for (Package aPackage : list) {
            int currentWeight = 0;

            for (int i = aPackage.from; i < aPackage.to; i++) {
                currentWeight = Math.max(currentWeight, truckLoad[i]);
            }

            int remainSpace = Math.min(M - currentWeight, aPackage.weight);

            for (int i = aPackage.from; i < aPackage.to; i++) {
                truckLoad[i] += remainSpace;
            }

            result += remainSpace;
        }

        System.out.println(result);
    }
}
