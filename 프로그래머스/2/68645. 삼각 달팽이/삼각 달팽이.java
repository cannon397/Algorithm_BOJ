import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int num = 1;
        int x = -1, y = 0; // 시작 위치
        int direction = 0; // 0: 아래, 1: 오른쪽, 2: 위-왼쪽

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (direction == 0) { // 아래로
                    x++;
                } else if (direction == 1) { // 오른쪽
                    y++;
                } else if (direction == 2) { // 위-왼쪽 대각선
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
            direction = (direction + 1) % 3; // 방향 전환
        }

        // 결과 배열 크기: 1 + 2 + ... + n = n*(n+1)/2
        int[] answer = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }
        return answer;
    }
}

