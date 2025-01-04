import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[] knowTruth;
    static List<List<Integer>> parties;
    static List<List<Integer>> inParties;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        String[] s1 = br.readLine().split(" ");
        knowTruth = new boolean[N + 1];
        if (!s1[0].equals("0")) {
            for (int i = 1; i < s1.length; i++) {
                int person = Integer.parseInt(s1[i]);
                knowTruth[person] = true;
            }
        }

        parties = new ArrayList<>();
        inParties = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            inParties.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] s2 = br.readLine().split(" ");
            int size = Integer.parseInt(s2[0]);
            List<Integer> list = new ArrayList<>();
            for(int j = 1; j <= size; j++) {
                int person = Integer.parseInt(s2[j]);
                list.add(person);
                inParties.get(person).add(i);
            }
            parties.add(list);
        }

        bfs();

        int count =0;
        for(List<Integer> party : parties) {
            boolean isPossible = true;
            for(int person : party) {
                if(knowTruth[person]) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N +1];
        for(int i =1; i <=N; i++) {
            if(knowTruth[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }

        while(!queue.isEmpty()) {
            int currentPerson = queue.poll();
            for(int partyIndex : inParties.get(currentPerson)) {
                List<Integer> current = parties.get(partyIndex);
                boolean hasKnow = false;
                for(int person : current) {
                    if(knowTruth[person]) {
                        hasKnow = true;
                        break;
                    }
                }
                if(hasKnow) {
                    for(int person : current) {
                        if(!knowTruth[person]) {
                            knowTruth[person] = true;
                            if(!visited[person]) {
                                queue.add(person);
                                visited[person] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
