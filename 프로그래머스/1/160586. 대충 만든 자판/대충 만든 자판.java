import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++){
            for(int j = 0; j < targets[i].length(); j++){
                int temp = Integer.MAX_VALUE;
                for(int k = 0; k < keymap.length; k++){
                    for(int l = 0; l < keymap[k].length(); l++){
                        if(keymap[k].charAt(l) == targets[i].charAt(j)){
                            temp = Math.min(l + 1, temp);
                            break;
                        }
                    }
                }
                if(temp == Integer.MAX_VALUE){
                    answer[i] = -1;
                } else if(answer[i] != -1){
                    answer[i] += temp;
                }
            }
        }
        return answer;
    }
}