import java.io.*;
import java.util.*;

public class Main {
    static class Trie {
        Node root;

        class Node {
            Map<String, Node> child;
            boolean endOfWord;

            public Node() {
                child = new TreeMap<>();
                endOfWord = false;
            }
        }

        public Trie() {
            root = new Node();
        }

        void insert(String[] arr) {
            Node node = this.root;
            for (String s : arr) {
                node.child.putIfAbsent(s, new Node());
                node = node.child.get(s);
            }
            node.endOfWord = true;
        }

        void dfs(Node node, int depth) {
            for (Map.Entry<String, Node> entry : node.child.entrySet()) {
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }
                sb.append(entry.getKey()).append("\n");
                dfs(entry.getValue(), depth + 1);
            }
        }
    }

    static Trie trie;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        trie = new Trie();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            String[] arr = new String[M];
            for (int j = 0; j < M; j++) {
                arr[j] = st.nextToken();
            }

            trie.insert(arr);
        }

        trie.dfs(trie.root, 0);
        System.out.print(sb);
    }
}