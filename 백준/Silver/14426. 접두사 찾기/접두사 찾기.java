import java.io.*;
import java.util.*;

public class Main {
    static class Trie{
        Node root = new Node();

        static class Node{
            HashMap<Character, Node> child = new HashMap<>();
            boolean endOfWord = false;
        }

        void insert(String str){
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                node.child.putIfAbsent(c, new Node());

                node = node.child.get(c);
            }
            node.endOfWord = true;
        }

        boolean startsWith(String str) {
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!node.child.containsKey(c)) return false;

                node = node.child.get(c);
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