import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N;
	static int[] operator;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int depth, int num) {
		if (depth == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		if (operator[0] > 0) {
			operator[0]--;
			dfs(depth + 1, num + arr[depth]);
			operator[0]++;
		}

		if (operator[1] > 0) {
			operator[1]--;
			dfs(depth + 1, num - arr[depth]);
			operator[1]++;
		}

		if (operator[2] > 0) {
			operator[2]--;
			dfs(depth + 1, num * arr[depth]);
			operator[2]++;
		}

		if (operator[3] > 0) {
			operator[3]--;
			dfs(depth + 1, num / arr[depth]);
			operator[3]++;
		}

	}

}
