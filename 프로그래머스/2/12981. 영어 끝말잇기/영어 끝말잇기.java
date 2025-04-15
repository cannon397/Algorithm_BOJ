import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        char lastChar = '0';
        for(int i = 0; i < words.length; i++){
            
            if(i == 0 || lastChar == words[i].charAt(0) && !set.contains(words[i])){
                lastChar = words[i].charAt(words[i].length() - 1);
                set.add(words[i]);
            }
            else{
                answer[0] = i % n + 1; //번호
                answer[1] = (i + 1) / n + (((i + 1) % n > 0) ? 1: 0); // 차례
                System.out.println(words[i]);
                break;
            }
        }
        return answer;
    }
}