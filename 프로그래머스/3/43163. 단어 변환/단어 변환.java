import java.util.*;

class Solution {
    class Node {
        String str;
        int count;

        public Node(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }

    Map<String, List<String>> map = new HashMap<>();

    public int solution(String begin, String target, String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];

            for (int j = i + 1; j < words.length; j++) {
                String b = words[j];

                if (compare(a, b)) {
                    map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                    map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
                }
            }
        }

        for (String word : words) {
            if (compare(begin, word)) {
                map.computeIfAbsent(begin, k -> new ArrayList<>()).add(word);
                map.computeIfAbsent(word, k -> new ArrayList<>()).add(begin);
            }
        }

        return bfs(begin, target);
    }

    public boolean compare(String a, String b) {
        int count = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;

                if (count > 1) {
                    return false;
                }
            }
        }

        return count == 1;
    }

    public int bfs(String begin, String target) {
        Queue<Node> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Node(begin, 0));
        visited.add(begin);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.str.equals(target)) {
                return current.count;
            }

            List<String> list = map.getOrDefault(current.str, new ArrayList<>());

            for (String next : list) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(new Node(next, current.count + 1));
                }
            }
        }

        return 0;
    }
}