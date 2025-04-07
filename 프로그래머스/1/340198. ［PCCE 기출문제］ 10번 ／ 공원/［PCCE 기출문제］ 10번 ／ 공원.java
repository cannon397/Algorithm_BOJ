import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int row = park.length;
        int col = park[0].length;
         Arrays.sort(mats);
        for(int i = mats.length - 1; i >= 0; i--){
            boolean allowedMat = false;
            for(int j = 0; j <= row - mats[i]; j++){
                for(int k = 0; k <= col - mats[i]; k++){
                    for(int y = j; y < mats[i] + j; y++){
                        boolean flag = true;
                        for(int x = k; x < mats[i] + k; x++){
                            if(!park[y][x].equals("-1")){
                                flag = false;
                                break;
                            }
                            if(y - j + 1 == mats[i] && x - k + 1 == mats[i]) allowedMat = true;
                        }
                        if(!flag){
                            break;
                        }
                     }
                }
            }
            if(allowedMat) return mats[i];
            
        }
        return answer;
    }
}