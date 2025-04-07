import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int row = park.length;
        int col = park[0].length;

        // Step 1: Prefix Sum 배열 생성
        int[][] prefixSum = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = park[i][j].equals("-1") ? 0 : 1;
                prefixSum[i + 1][j + 1] = value + prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j];
            }
        }

        // Step 2: mats 배열 내림차순 정렬
        Arrays.sort(mats);

        // Step 3: 가장 큰 매트부터 배치 가능 여부 확인
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            for (int r = 0; r <= row - size; r++) {
                for (int c = 0; c <= col - size; c++) {
                    int total = prefixSum[r + size][c + size] 
                              - prefixSum[r][c + size] 
                              - prefixSum[r + size][c] 
                              + prefixSum[r][c];
                    if (total == 0) { // 모두 "-1"인 경우
                        return size;
                    }
                }
            }
        }

        return -1;
    }
}
