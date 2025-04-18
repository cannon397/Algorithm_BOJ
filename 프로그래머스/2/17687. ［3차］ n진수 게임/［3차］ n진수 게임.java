class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int number = 0;
        while(count < t * m){
            
            String temp = toBaseN(number, n);
            sb.append(temp);
            count = sb.length();
            number++;
        }
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < t * m; i++){
            if((i % m == p - 1)){
                sb2.append(sb.charAt(i));
            }
        }
        answer = sb2.toString();
        return answer;
    }
    public String toBaseN(int number,int n){
        if(number == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(number > 0){
            int remainder = number % n;
            if(remainder >= 10){
                sb.append((char)('A' + remainder - 10));
            }else{
                sb.append(remainder);
            }
            number /= n;
        }
        return sb.reverse().toString();
    }
}