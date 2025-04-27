import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int count = Integer.MAX_VALUE;
        int[] dp = new int[sequence.length + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length;i++){
            dp[i] = dp[i - 1] + sequence[i - 1];
        }
        int j = 0;
        //stem.out.println(Arrays.toString(dp));
        for(int i = 1; i < dp.length; i++){
            //if(i < 0 || j < 0 || i >= dp.length || j >= dp.length) continue;
            if(i == j && sequence[i - 1] == k){
                answer[0] = i - 1;
                answer[1] = i - 1;
                break;
            }
            if(dp[i] - dp[j] == k && count > i - j){
                count = Math.min(count, i - j);
                //stem.out.printf("j:%d, i:%d\n",j, i - 1);
                answer[0] = j;
                answer[1] = i - 1;
            }else if(dp[i] - dp[j] > k){
                i--;
                j++;
            }
        }
        return answer;
    }
}