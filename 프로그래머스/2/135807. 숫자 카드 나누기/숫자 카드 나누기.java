class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;
        int a = arrayA[0];
        int b = arrayB[0];
        if(n == 1) return (a % b == 0 || b % a == 0) ? 0 : (a > b) ? a : b;
        for(int i = 1; i < n; i++){
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }
        //System.out.printf("a: %d, b: %d", a, b);
        boolean flag1 = true, flag2 = true;
        for(int i = 0; i < n; i++){
            if(arrayB[i] % a == 0) {
                flag1 = false;
                break;
            }
        }
        for(int i = 0; i < n; i++){
            if(arrayA[i] % b == 0) {
                flag2 = false;
                break;
            }
        }
        if(flag1 && !flag2){
            return (a > 1) ? a : 0;
        }else if(!flag1 && flag2){
            return (b > 1) ? b : 0;
        }else if(flag1 && flag2){
            return (a > b) ? a : b;
        }else if(!flag1 && !flag2){
            return 0;
        }
        
        //answer = (a > b) ? a : b;
        return answer;
    }
    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}