import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        if(arr.length == 1){
            answer = arr[0];
        }else{
            Arrays.sort(arr);
            for(int i = 1; i < arr.length; i++){
                int a = arr[i];
                int b = arr[i - 1];
                int ab = a * b;
                while(b != 0){
                    int temp = b;
                    b = a % b;
                    a = temp;
                }
                arr[i] = (ab / a);
                answer = (ab / a);
            }
        }
        
        return answer;
    }
}