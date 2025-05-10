class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;
        int a = arrayA[0];
        int b = arrayB[0];
        for(int i = 1; i < n; i++){
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }
        int candidateA = isValid(a, arrayB) ? a : 0;
        int candidateB = isValid(b, arrayA) ? b : 0;
        return Math.max(candidateA, candidateB);
    }
    public boolean isValid(int gcd, int[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] % gcd == 0) {
                return false;
            }
        }
        return true;
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