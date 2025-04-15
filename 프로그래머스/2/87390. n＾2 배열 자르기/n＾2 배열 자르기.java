import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int)(right - left) + 1;
        int[] answer = new int[length];
        long startIndex = left;
        for(int i = 0; i < length; i++){
            int row = (int)(startIndex / n) + 1;
            int col = (int)(startIndex % n) + 1;
            answer[i] = Math.max(row, col);
            startIndex++;
        }
        return answer;
    }
}