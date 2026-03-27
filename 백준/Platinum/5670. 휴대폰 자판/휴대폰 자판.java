import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Trie{
        Node root = new Node();
        class Node{
            Node[] child = new Node[26];
            int count = 0;
            boolean endOfWord = false;
        }

        void insert(String str) {
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - 'a';
                if (node.child[c] == null) {
                    node.child[c] = new Node();
                    node.count++;
                }
                node = node.child[c];
            }

            node.endOfWord = true;
        }

        int search(String str) {
            Node node = this.root.child[str.charAt(0) - 'a'];
            int count = 1;
            for (int i = 1; i < str.length(); i++) {
                int c = str.charAt(i) - 'a';
                if (node.child[c] == null) return -1;
                if (node.count > 1 || node.endOfWord) count++;
                node = node.child[c];
            }
            return node.endOfWord ? count : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
//        line = br.readLine();
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);

            String[] words = new String[N];
            Trie trie = new Trie();
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                trie.insert(word);
                words[i] = word;
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                String word = words[i];
                sum += trie.search(word);
            }
            sb.append(String.format("%.2f\n", (double) sum / N));
        }
        System.out.println(sb);
    }
}