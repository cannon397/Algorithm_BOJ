import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        boolean[][] map = new boolean[n][n];
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        System.out.println(Arrays.deepToString(result));
        for(int i = 0; i < n; i++){
            StringBuilder sb1 = new StringBuilder(Integer.toString(arr1[i], 2));
            StringBuilder sb2 = new StringBuilder(Integer.toString(arr2[i], 2));
            if(sb1.length() < n){
                int length = n - sb1.length();
                for(int j = 0; j < length; j++){
                    sb1.insert(0, 0);
                }
            }
            if(sb2.length() < n){
                int length = n - sb2.length();
                for(int j = 0; j < length; j++){
                    sb2.insert(0, 0);
                }
            }
            for(int j = 0; j < n; j++){
                if(sb1.charAt(j) == '1'){
                    map[i][j] = true;
                }
                if(sb2.charAt(j) == '1'){
                    map[i][j] = true;
                }
            }

        }

        for(int i = 0; i < n; i++){
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(!map[i][j]){
                    temp.append(" ");
                }else{
                    temp.append("#");
                }
            }
            answer[i] = temp.toString();
        }
        return answer;
    }
}