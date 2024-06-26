import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        if (n == 1) {
            System.out.println(1);
        } else {
            int[] arr = new int[n+1];
            arr[1] = 1; // n이 1일때
            arr[2] = 3; // n이 3일때

            int[] symmetry = new int[n + 1];
            symmetry[1] = 1; // n이 1일때
            symmetry[2] = 3; // n이 3일때
            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i - 1] + 2 * arr[i - 2];
                if (i % 2 == 0) {
                    symmetry[i] = (arr[i] + arr[i / 2] + 2 * arr[(i - 2) / 2]) / 2;
                } else {
                    symmetry[i] = (arr[i] + arr[(i - 1) / 2]) / 2;
                }
            }
            System.out.println(symmetry[n]);
        }
    }
}