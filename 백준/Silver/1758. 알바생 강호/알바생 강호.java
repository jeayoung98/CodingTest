import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] tipArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int tip = sc.nextInt();
            tipArr[i] = tip;
        }
        Arrays.sort(tipArr, (a, b) -> b - a);

        long sum = IntStream.range(0, n)
                        .mapToLong(i -> tipArr[i]-i)
                        .filter(tip -> tip>=0)
                        .sum();
        System.out.println(sum);
    }
}