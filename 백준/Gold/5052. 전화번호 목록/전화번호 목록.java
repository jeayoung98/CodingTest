import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Trie{
        Node root = new Node();
        class Node{
            Node[] child = new Node[10];
            boolean isEnd = false;
        }

        void insert(String str) {
            Node node = this.root;

            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - '0';

                if(node.child[c] == null) node.child[c] = new Node();
                node = node.child[c];
            }
            node.isEnd = true;
        }

        boolean startsWith(String str) {
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - '0';

                if (node.child[c] == null) return false;
                node = node.child[c];
            }

            for (int i = 0; i < 10; i++) {
                if (node.child[i] != null) return true;
            }
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] arr;
        for (int i = 0; i < N; i++) {
            Trie trie = new Trie();
            int M = Integer.parseInt(br.readLine());
            arr = new String[M];
            for (int j = 0; j < M; j++) {
                String current = br.readLine();
                arr[j] = current;
                trie.insert(current);
            }

            boolean flag = false;
            for (int j = 0; j < M; j++) {
                if (trie.startsWith(arr[j])) {
                    flag = true;
                    break;
                }
            }
            sb.append(flag ? "NO" : "YES").append("\n");
        }
        System.out.println(sb);
    }
}