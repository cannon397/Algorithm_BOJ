class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] data = new long[n + 1];

        if(n == 1 || n == 2){
            return n;
        }
        data[1] = 1;
        data[2] = 2;
        for(int i = 3; i <= n; i++){
            data[i] = (data[i - 2] + data[i - 1]) % 1234567L;
        }
        answer = data[n];
        return answer;
    }
}