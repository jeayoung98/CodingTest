import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            System.out.println(countZeros(N));
        }

        scanner.close();
    }

    private static int countZeros(int N) {
        int count = 0;
        while (N >= 5) {
            N /= 5;
            count += N;
        }
        return count;
    }
}