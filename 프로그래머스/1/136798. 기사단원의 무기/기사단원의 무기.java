import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int sword = 0;
            int sqrt = (int)Math.sqrt(i);
            for(int j = 1; j <= sqrt; j++){
                if(i % j == 0){
                      sword++;  
                    if( j != i / j){
                        sword++;
                    }
                }
            }
            if(sword > limit){
                answer += power;
            }else{
                answer += sword;
            }
        }
        return answer;
    }
}