import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M;

    static class Player {
        int level;
        String name;
        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static class Room {
        int min, max;
        PriorityQueue<Player> queue = new PriorityQueue<>(
                Comparator.comparing(p -> p.name)
        );

        public Room(Player first) {
            this.min = first.level - 10;
            this.max = first.level + 10;
            queue.add(first);
        }

        public boolean canEnter(Player p) {
            return queue.size() < M
                    && p.level >= min
                    && p.level <= max;
        }

        public void add(Player p) {
            queue.add(p);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] header = br.readLine().split(" ");
        int N = Integer.parseInt(header[0]);
        M = Integer.parseInt(header[1]);

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            Player player = new Player(Integer.parseInt(s[0]), s[1]);

            boolean entered = false;
            for (Room room : rooms) {
                if (room.canEnter(player)) {
                    room.add(player);
                    entered = true;
                    break;
                }
            }
            if (!entered) {
                rooms.add(new Room(player));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.queue.size() == M) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }
            while (!room.queue.isEmpty()) {
                Player p = room.queue.poll();
                sb.append(p.level)
                        .append(" ")
                        .append(p.name)
                        .append("\n");
            }
        }

        System.out.print(sb);
    }
}
