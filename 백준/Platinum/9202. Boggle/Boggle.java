import java.io.*;

public class Main {

    static class Trie {
        Node root = new Node();

        static class Node {
            Node[] child = new Node[26];
            String word;
            boolean isFound;
        }

        void insert(String str) {
            Node node = root;

            for (char c : str.toCharArray()) {
                int idx = c - 'A';
                if (node.child[idx] == null) node.child[idx] = new Node();
                node = node.child[idx];
            }

            node.word = str;
        }
    }

    static char[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int max;
    static int count;
    static String longest;

    static int getScore(int length) {
        if (length <= 2) return 0;
        if (length <= 4) return 1;
        if (length == 5) return 2;
        if (length == 6) return 3;
        if (length == 7) return 5;
        return 11;
    }

    static void dfs(int x, int y, Trie.Node node, int depth) {
        if (depth > 8) return;

        char c = board[x][y];
        Trie.Node next = node.child[c - 'A'];

        if (next == null) return;

        if (next.word != null && !next.isFound) {
            next.isFound = true;

            count++;
            max += getScore(next.word.length());

            if (next.word.length() > longest.length() ||
                    (next.word.length() == longest.length() && next.word.compareTo(longest) < 0)) {
                longest = next.word;
            }
        }

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && !visited[nx][ny]) {
                dfs(nx, ny, next, depth + 1);
            }
        }

        visited[x][y] = false;
    }

    static void reset(Trie.Node node) {
        if (node == null) return;

        node.isFound = false;

        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                reset(node.child[i]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        br.readLine();

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            board = new char[4][4];
            for (int j = 0; j < 4; j++) {
                board[j] = br.readLine().toCharArray();
            }

            visited = new boolean[4][4];

            max = 0;
            count = 0;
            longest = "";

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    dfs(j, k, trie.root, 1);
                }
            }

            sb.append(max).append(" ").append(longest).append(" ").append(count).append("\n");

            reset(trie.root);

            if (i < M - 1) br.readLine();
        }

        System.out.print(sb);
    }
}