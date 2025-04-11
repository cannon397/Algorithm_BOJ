class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int emptyBottle = n;
        while(emptyBottle / a > 0){
            if(emptyBottle < a) break;
            answer += (emptyBottle / a) * b;
            emptyBottle = (emptyBottle % a) + (emptyBottle / a) * b;
            
        }
        return answer;
    }
}