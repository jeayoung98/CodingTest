import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static int N;
    static List<int[]> candidateList;
    static int result = 0;
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        map = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int currentStd = Integer.parseInt(st.nextToken());

            List<Integer> likes = new ArrayList<>(4);
            for (int j = 0; j < 4; j++) {
                likes.add(Integer.parseInt(st.nextToken()));
            }
            map.put(currentStd, likes);

            setSeat(currentStd);
        }

        sumSatisfied();
        System.out.println(result);
    }

    private static void sumSatisfied() {
        result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int currentStd = arr[i][j];
                List<Integer> likes = map.get(currentStd);

                int likeCnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (valid(nx, ny) && likes.contains(arr[nx][ny])) likeCnt++;
                }

                if (likeCnt == 1) result += 1;
                else if (likeCnt == 2) result += 10;
                else if (likeCnt == 3) result += 100;
                else if (likeCnt == 4) result += 1000;
            }
        }
    }

    private static void setSeat(int std) {
        // 후보군 정하기 좋아하는 학생 인접 최대
        candidates(std);

        // 후보가 여러개면 인접 빈칸 최대
        if (candidateList.size() > 1) countBlank();

        // 후보가 여러개면 행 번호 최소
        if (candidateList.size() > 1) countRow();

        // 후보가 여러개면 열 번호 최소
        if (candidateList.size() > 1) {
            int[] currentSeat = countCol();
            arr[currentSeat[0]][currentSeat[1]] = std;
        } else {
            int[] currentSeat = candidateList.get(0);
            arr[currentSeat[0]][currentSeat[1]] = std;
        }
    }

    private static int[] countCol() {
        candidateList.sort((a, b) -> a[1] - b[1]);
        return candidateList.get(0);
    }

    private static void countRow() {
        candidateList.sort((a, b) -> a[0] - b[0]);
        int minRow = candidateList.get(0)[0];
        candidateList.removeIf(i -> i[0] != minRow);
    }

    private static void countBlank() {
        int size = candidateList.size();
        int[] counts = new int[size];
        int[][] stds = new int[size][2];

        int max = -1;
        int idx = 0;

        for (int[] i : candidateList) {
            stds[idx] = new int[]{i[0], i[1]};
            int count = 0;

            for (int j = 0; j < 4; j++) {
                int nx = i[0] + dx[j];
                int ny = i[1] + dy[j];
                if (valid(nx, ny) && arr[nx][ny] == 0) count++;
            }

            max = Math.max(count, max);
            counts[idx++] = count;
        }

        candidateList.clear();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max) candidateList.add(stds[i]);
        }
    }

    private static void candidates(int std) {
        candidateList = new ArrayList<>();
        List<Integer> likes = map.get(std);

        int maxLike = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) continue;

                int likeCnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (valid(nx, ny) && likes.contains(arr[nx][ny])) likeCnt++;
                }

                if (likeCnt > maxLike) {
                    maxLike = likeCnt;
                    candidateList.clear();
                    candidateList.add(new int[]{i, j});
                } else if (likeCnt == maxLike) {
                    candidateList.add(new int[]{i, j});
                }
            }
        }
    }

    private static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
