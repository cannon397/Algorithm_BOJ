import java.util.*;
class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n, k);
        String[] numbers = number.split("0+");
        for(String num : numbers){
            if(isPrime(Long.parseLong(num))) answer++;
        }
        return answer;
    }
    public boolean isPrime(long number){
        if(number <= 1) return false;
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}