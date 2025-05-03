import java.util.*;
class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        int n = arr.length;
        int[][] position = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        Queue<int[]> q = new LinkedList<>();

        if (n == 1) {
            answer[arr[0][0]]++;
            return answer;
        } else {
            q.add(new int[]{0, 0, n});
        }

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1], length = pos[2];
            int count = 0;


            for (int i = x; i < x + length; i++) {
                for (int j = y; j < y + length; j++) {
                    if (arr[i][j] == 1) count++;
                }
            }

            if (count == 0) {
                answer[0]++;
            } else if (count == length * length) {
                answer[1]++;
            } else {

                if (length > 1) {
                    int newLen = length / 2;
                    for (int[] p : position) {
                        int nx = x + p[0] * newLen;
                        int ny = y + p[1] * newLen;
                        q.add(new int[]{nx, ny, newLen});
                    }
                }
            }
        }
        return answer;
    }
}
