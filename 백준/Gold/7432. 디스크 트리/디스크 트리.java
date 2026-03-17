import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    static class Trie {
        Node root = new Node();

        static class Node {
            TreeMap<String, Node> child = new TreeMap<>();
        }

        void insert(String[] arr) {
            Node node = root;

            for (int i = 0; i < arr.length; i++) {
                String folder = arr[i];

                node.child.putIfAbsent(folder, new Node());
                node = node.child.get(folder);
            }
        }

        void print(Node node, int depth, StringBuilder sb) {
            for (String key : node.child.keySet()) {
                for (int i = 0; i < depth; i++) {
                    sb.append(" ");
                }

                sb.append(key).append("\n");

                print(node.child.get(key), depth + 1, sb);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            String[] path = br.readLine().split("\\\\");
            trie.insert(path);
        }

        StringBuilder sb = new StringBuilder();
        trie.print(trie.root, 0, sb);

        System.out.print(sb);
    }
}