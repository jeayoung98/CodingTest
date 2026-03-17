import java.io.*;
import java.util.*;

public class Main {
    static class Trie{
        Node root = new Node();

        static class Node {
            Node[] child = new Node[26];
            String word;
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

        void dfs(int x, int y, Node node) {
            char c = board[x][y];
            Node next = node.child[c - 'A'];

            if (next == null) return;

            if (next.word != null) {
                found.add(next.word);
            }

            visited[x][y] = true;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx,ny)) dfs(nx, ny, next);
            }

            visited[x][y] = false;
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < 4 && y < 4 && !visited[x][y];
    }


    static char[][] board;
    static boolean[][] visited;
    static Set<String> found;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int getScore(String str) {
        int length = str.length();
        if (length <= 2) return 0;
        if (length <= 4) return 1;
        if (length == 5) return 2;
        if (length == 6) return 3;
        if (length == 7) return 5;
        return 11;
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

            found = new HashSet<>();
            visited = new boolean[4][4];

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    trie.dfs(j, k, trie.root);
                }
            }

            int max = 0;
            String longest = "";

            for (String word : found) {
                max += getScore(word);

                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length()) {
                    if (word.compareTo(longest) < 0) {
                        longest = word;
                    }
                }
            }

            sb.append(max).append(" ").append(longest).append(" ").append(found.size()).append("\n");

            if (i < M - 1) br.readLine();
        }

        System.out.print(sb);
    }
}