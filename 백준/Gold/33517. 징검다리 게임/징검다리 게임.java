import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] bridge = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        char[] macro = br.readLine().toCharArray();

        int[] nextJ = buildNext(macro, 'J');
        int[] nextA = buildNext(macro, 'A');
        int[] nextD = buildNext(macro, 'D');
        int[] prefixA = buildPrefixA(macro);

        int idx = 0;

        for (int i = 1; i < N; i++) {
            int cell = bridge[i];

            // 빈칸
            if (cell == 0) {
                int j = nextJ[idx];
                if (j == INF) {
                    System.out.println("NO");
                    return;
                }
                idx = (j + 1) % K;
            }
            // 지뢰
            else if (cell == -1) {
                int j = nextJ[idx];
                int a = nextA[idx];
                int d = nextD[idx];

                int first = Math.min(j, Math.min(a, d));

                // 가장 먼저 나오는 명령이 D가 아니면 죽음
                if (first != d) {
                    System.out.println("NO");
                    return;
                }

                // D로 지뢰 제거
                idx = (d + 1) % K;

                int j2 = nextJ[idx];
                if (j2 == INF) {
                    System.out.println("NO");
                    return;
                }
                idx = (j2 + 1) % K;
            }
            // 곰
            else {
                int hp = cell;

                int j = nextJ[idx];
                if (j == INF) {
                    System.out.println("NO");
                    return;
                }

                int attackCount = countABeforeJ(idx, j, K, prefixA);

                if (attackCount < hp) {
                    System.out.println("NO");
                    return;
                }

                idx = (j + 1) % K;
            }
        }

        System.out.println("YES");
    }

    // 시작 위치 i에서 한 바퀴 안에 처음 나오는 target의 절대 위치 반환
    public static int[] buildNext(char[] s, char target) {
        int K = s.length;
        char[] doubled = new char[2 * K];
        for (int i = 0; i < 2 * K; i++) {
            doubled[i] = s[i % K];
        }

        int[] nextPos = new int[2 * K + 1];
        Arrays.fill(nextPos, INF);

        for (int i = 2 * K - 1; i >= 0; i--) {
            nextPos[i] = nextPos[i + 1];
            if (doubled[i] == target) {
                nextPos[i] = i;
            }
        }

        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            int nextIdx = nextPos[i];
            if (nextIdx >= i + K) {
                result[i] = INF;
            } else {
                result[i] = nextIdx;
            }
        }
        return result;
    }

    // A 누적합
    public static int[] buildPrefixA(char[] s) {
        int K = s.length;
        int[] prefix = new int[2 * K + 1];

        for (int i = 0; i < 2 * K; i++) {
            prefix[i + 1] = prefix[i] + (s[i % K] == 'A' ? 1 : 0);
        }
        return prefix;
    }

    public static int countABeforeJ(int p, int j, int K, int[] prefixA) {
        int end = j;
        if (end < p) end += K;
        return prefixA[end] - prefixA[p];
    }
}