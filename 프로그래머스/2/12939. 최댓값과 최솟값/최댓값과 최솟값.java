import java.util.*;
class Solution {
    public String solution(String str) {
        String answer = "";
        int[] numbers = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        answer = numbers[0] + " ";
        answer += numbers[numbers.length - 1];
        return answer;
    }
}