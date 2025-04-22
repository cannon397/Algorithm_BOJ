class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = 2;
        for(int i = 3; i <= n; i++){
            sum[i] = (sum[i - 1] + sum[i - 2]) % 1000000007;
        }
        answer = sum[n];
        return answer;
    }
}