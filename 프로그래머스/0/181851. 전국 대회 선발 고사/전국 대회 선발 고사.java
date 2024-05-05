import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Student> students = new ArrayList<>();
        
        // 학생 리스트
        for (int i = 0; i < rank.length; i++) {
            students.add(new Student(i, rank[i], attendance[i]));
        }
        
        // 순위로 정렬
        Collections.sort(students, (a, b) -> Integer.compare(a.rank, b.rank));
        
        // 선발 가능 학생
        List<Integer> list = new ArrayList<>();
        for (Student student : students) {
            if (student.isAttend) {
                list.add(student.index);
            }
            else if (list.size() == 3) {
                break;
            }
        }
        int result = 10000 * list.get(0) + 100 * list.get(1) + list.get(2);
        return result;
    }

    static class Student {
        int index;
        int rank;
        boolean isAttend;

        public Student(int index, int rank, boolean isAttend) {
            this.index = index;
            this.rank = rank;
            this.isAttend = isAttend;
        }
    }
}