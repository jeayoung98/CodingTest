import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 기둥의 개수

        // 기둥들을 저장할 리스트
        List<int[]> xyArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt(); // 기둥의 왼쪽 면의 위치
            int y = scanner.nextInt(); // 기둥의 높이
            xyArr.add(new int[]{x, y});
        }

        // x좌표 기준 기둥 정렬
        Collections.sort(xyArr, Comparator.comparingInt(i -> i[0]));

        // 좌우에서 볼 수 있는 리스트 합침
        List<int[]> mergedList = new ArrayList<>();
        mergedList.addAll(left(xyArr));
        mergedList.addAll(right(xyArr));

        // 창고 다각형의 면적을 계산
        int area = calculateArea(mergedList);
        
        System.out.println(area);
    }

    // 왼쪽에서 볼수있는 기둥
    public static List<int[]> left(List<int[]> xyArr) {
        List<int[]> leftList = new ArrayList<>();
        int maxHeight = 0;

        for (int[] xy : xyArr) {
            if (xy[1] > maxHeight) {
                maxHeight = xy[1];
                leftList.add(xy);
            }
        }
        return leftList;
    }
    
    //오른쪽에서 볼 수 있는 기둥
    public static List<int[]> right(List<int[]> xyArr) {
        List<int[]> rightList = new ArrayList<>();
        int maxHeight = 0;

        for (int i = xyArr.size() - 1; i >= 0; i--) {
            if (xyArr.get(i)[1] > maxHeight) {
                maxHeight = xyArr.get(i)[1];
                rightList.add(xyArr.get(i));
            }
        }
        Collections.reverse(rightList);
        return rightList;
    }

    // 넓이 계산
    public static int calculateArea(List<int[]> mergedArr) {
        int area = 0;
        for (int i = 0; i < mergedArr.size() - 1; i++) {
            int height = Math.min(mergedArr.get(i)[1], mergedArr.get(i + 1)[1]);
            int width = mergedArr.get(i + 1)[0] - mergedArr.get(i)[0];
            area += height * width ;
        }
        return area + maxHeight(mergedArr);
    }

    // 가장 높은 기둥
    public static int maxHeight(List<int[]> xyArr) {
        int maxHeight = 0;
        for (int[] xy : xyArr) {
            maxHeight = Math.max(maxHeight, xy[1]);
        }
        return maxHeight;
    }
}