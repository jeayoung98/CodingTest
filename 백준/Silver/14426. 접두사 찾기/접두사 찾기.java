import java.io.*;
import java.util.*;

public class Main {

    static class Trie {
        Node root = new Node();

        static class Node {
            Node[] child = new Node[26];
            boolean endOfWord;
        }

        void insert(String str) {
            Node node = root;

            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';

                if (node.child[idx] == null) {
                    node.child[idx] = new Node();
                }

                node = node.child[idx];
            }

            node.endOfWord = true;
        }

        boolean startsWith(String str) {
            Node node = root;

            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';

                if (node.child[idx] == null) {
                    return false;
                }

                node = node.child[idx];
            }

            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            if (trie.startsWith(br.readLine())) result++;
        }

        System.out.println(result);
    }
}