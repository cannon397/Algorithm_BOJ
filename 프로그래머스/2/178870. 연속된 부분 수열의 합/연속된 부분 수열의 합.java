import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0, right = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;
        while(right < sequence.length){
            sum += sequence[right++];
            while(sum > k && left < right){
                sum -= sequence[left++];
            }
            if(sum == k && count > right - left) {
                count = Math.min(count, right - left);
                answer[0] = left; 
                answer[1] = right - 1;
            }

        }
        return answer;
    }
}