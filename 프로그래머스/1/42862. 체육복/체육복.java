import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        // 여분의 옷과 잃어버린 옷의 중복 제거
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();

        for (int r : reserve) {
            reserveSet.add(r);
        }
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                reserveSet.remove(l); // 본인이 잃어버린 경우 제거
                answer++;
            } else {
                lostSet.add(l);
            }
        }

        // 여분의 옷으로 잃어버린 사람들에게 빌려주기
        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                answer++;
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                answer++;
            }
        }

        return answer;
    }
}


