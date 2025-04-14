import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int j = people.length - 1;
        for(int i = 0; i <= j; j--){
            if(people[i] + people[j] <= limit){
                i++;
                answer++;
            }else{
                answer++;
            }
        }
        return answer;
    }
}