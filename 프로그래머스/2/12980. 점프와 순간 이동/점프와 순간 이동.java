import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;
        int sum = n;
        while(true){
            if(sum / 2 > 0){
                ans += sum % 2;
                sum /= 2;
            }else{
                break;
            }
        }
        return ans;
    }
}