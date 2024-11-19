import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int S = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            String[] cmd;
            int x = 0;

            if (input.contains(" ")) {
                cmd = input.split(" ");
                x = Integer.parseInt(cmd[1]);
            } else {
                cmd = new String[] { input };
            }

            switch (cmd[0]) {
                case "add":
                    S |= (1 << (x - 1));
                    break;
                case "remove":
                    S &= ~(1 << (x - 1));
                    break;
                case "check":
                    if ((S & (1 << (x - 1))) != 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    S ^= (1 << (x - 1));
                    break;
                case "all":
                    S = (1 << 20) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}
