class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int n = queue1.length;
        long total = 0;
        long currentSum = 0;
        int[] q = new int[n * 2];
        for(int i = 0; i < n; i++){
            total += queue1[i] + queue2[i];
            currentSum += queue1[i];
            q[i] = queue1[i];
            q[n + i] = queue2[i];
        }
        long target = total / 2;

        int left = 0, right = n - 1, maxLength = n * 3;
        int count = 0;
        while(count <= maxLength){
            if(currentSum == target) return count;
            if(currentSum > target){
                currentSum -= q[left++];
            }else{
                right++;
                if(right >= q.length) break;
                currentSum += q[right];
            }
            count++;
        }
        return answer;
    }
}