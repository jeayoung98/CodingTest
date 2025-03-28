import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        recursion(0);
        System.out.println(sb.toString());
    }

    public static void recursion(int depth) {
        addStr("\"재귀함수가 뭔가요?\"",depth);
        if (depth == N) {
            addStr("\"재귀함수는 자기 자신을 호출하는 함수라네\"", depth);
        } else {
            addStr("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",depth);
            addStr("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", depth);
            addStr("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"", depth);
            recursion(depth + 1);
        }
        addStr("라고 답변하였지.",depth);
    }

    public static void addStr(String str,int depth) {
        for (int i = 0; i < depth; i++) {
            sb.append("____");
        }
        sb.append(str).append("\n");
    }
}