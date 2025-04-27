import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;
        long total = sum1 + sum2;
        if (total % 2 != 0) return -1; // 불가능

        long target = total / 2;
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) arr[i] = queue1[i];
        for (int i = 0; i < n; i++) arr[n + i] = queue2[i];

        int left = 0, right = n - 1;
        long currSum = sum1;
        int maxOps = n * 3; // 제한: 왼쪽, 오른쪽 모두 2n까지 이동 가능
        int ops = 0;

        while (ops <= maxOps) {
            if (currSum == target) return ops;
            if (currSum > target) {
                currSum -= arr[left++];
            } else {
                right++;
                if (right >= arr.length) break;
                currSum += arr[right];
            }
            ops++;
        }
        return -1;
    }
}
