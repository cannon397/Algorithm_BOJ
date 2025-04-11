import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i : ingredient){
            sb.append(i);
        }
        while(sb.indexOf("1231") != -1){
            int index = sb.indexOf("1231");
            sb.replace(index, index + 4, "");
            answer++;
        }
        return answer;
    }
}