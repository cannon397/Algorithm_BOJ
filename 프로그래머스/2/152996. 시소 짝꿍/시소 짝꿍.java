import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ratios = {2, 3, 4};

        for (int w : weights) {
            Set<Integer> targets = new HashSet<>();

            for (int a : ratios) {
                for (int b : ratios) {
                    if ((w * b) % a == 0) {
                        int target = (w * b) / a;
                        targets.add(target);
                    }
                }
            }

            for (int target : targets) {
                answer += map.getOrDefault(target, 0);
            }

            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        return answer;
    }
}

