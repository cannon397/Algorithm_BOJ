import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] split1 = new int[topping.length];
        int[] split2 = new int[topping.length];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < topping.length; i++){
            set1.add(topping[i]);
            split1[i] = set1.size();
            set2.add(topping[topping.length - i - 1]);
            split2[topping.length - i - 1] = set2.size();
        }
        for(int i = 0; i < topping.length - 1; i++){
            if(split1[i] - split2[i + 1] == 0) answer++;
        }
        return answer;
    }
}