import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int n = storey % 10;
            if (n > 5) {
                answer += 10 - n;
                storey += 10 - n;
            } else if (n < 5) {
                answer += n;
            } else { // n == 5
                // 윗자리수가 5 이상이면 올림, 아니면 내림
                if ((storey / 10) % 10 >= 5) {
                    answer += 10 - n;
                    storey += 10 - n;
                } else {
                    answer += n;
                }
            }
            storey /= 10;
        }
        return answer;
    }
}