import java.util.*;

class Solution {
    boolean[] visited;
    int[] arr;
    
    public int solution(int[] cards) {
        visited = new boolean[cards.length + 1];
        arr = cards;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : cards) {
            if (!visited[i]) {
                int len = func(i).size();
                if (len > 0) queue.add(len);
            }
        }

        return queue.size() >= 2 ? queue.poll() * queue.poll() : 0;
    }

    public List<Integer> func(int num) {
        List<Integer> list = new ArrayList<>();
        while (!visited[num]) {
            visited[num] = true;
            list.add(num);
            num = arr[num - 1];
        }
        return list;
    }
}
