import java.util.Scanner;

public class Solution {

    static int power(int n, int m) {
        if (m == 0) {
            return 1;
        }

        return n * power(n, m - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int testCase = sc.nextInt();

            int n = sc.nextInt();
            int m = sc.nextInt();

            int answer = power(n, m);

            System.out.println("#" + testCase + " " + answer);
        }

        sc.close();
    }
}