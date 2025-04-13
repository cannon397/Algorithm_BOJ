import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int nextN = n;
        int binaryNzero = Integer.toBinaryString(n).replace("0","").length();
        while(answer == 0){
            nextN++;
            if(Integer.toBinaryString(nextN).replace("0","").length() == binaryNzero){
                answer = nextN;
            }
        }
        return answer;
    }
}