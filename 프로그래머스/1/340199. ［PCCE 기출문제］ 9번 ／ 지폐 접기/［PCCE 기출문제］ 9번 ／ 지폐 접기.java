class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = cal(wallet[0], wallet[1], bill[0], bill[1], 0);
        return answer;
    }
    public int cal(int walletRow,int walletCol,int billRow,int billCol, int result){
        if((walletRow >= billRow && walletCol >= billCol) || (walletRow >= billCol && walletCol >= billRow)){
            return result;
        }
        if(billRow > billCol){
            billRow /= 2;
        }else{
            billCol /= 2;
        }
        return cal(walletRow, walletCol, billRow, billCol, result + 1);
    }
}