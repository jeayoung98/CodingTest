import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Trie{
        Node root = new Node();
        class Node{
            Node[] child = new Node[26];
            boolean endOfWord = false;
        }

        void insert(String str) {
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - 'a';
                if (node.child[c] == null) node.child[c] = new Node();
                node = node.child[c];
            }

            node.endOfWord = true;
        }

        boolean startsWith(String str) {
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - 'a';
                if (node.child[c] == null) return false;
                node = node.child[c];
            }
            return node.child.length != 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            trie.insert(word);
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            String prefix = br.readLine();
            if (trie.startsWith(prefix)) result++;
        }
        System.out.println(result);
    }
}