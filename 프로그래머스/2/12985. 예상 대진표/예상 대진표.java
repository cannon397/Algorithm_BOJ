import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(true){
            if(Math.abs(a - b) == 1 && Math.abs(a / 2 - b / 2) == 1){
                break;
            }else{
                if(a % 2 > 0){
                    a++;
                }
                a /= 2;
                if(b % 2 > 0){
                    b++;
                }
                b /= 2;
            }

            if(n / 2 >= 2){
                n /= 2;
                answer++;
            }else{
                break;
            }
        }
    

        return answer;
    }
}