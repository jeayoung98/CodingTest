import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> primes = getPrime(N);

        int result = 0;
        int left = 0;
        int right = 0;
        int currentSum = 0;

        while (left <= right && right <= primes.size()) {
            if (currentSum >= N) {
                if (currentSum == N) {
                    result++;
                }
                if (left < primes.size()) {
                    currentSum -= primes.get(left++);
                }
            } else {
                if (right < primes.size()) {
                    currentSum += primes.get(right++);
                } else {
                    break;
                }
            }
        }

        System.out.println(result);
    }

    public static ArrayList<Integer> getPrime(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        if (N >= 0) isPrime[0] = false;
        if (N >= 1) isPrime[1] = false;

        for(int i = 2; i * i <= N; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
