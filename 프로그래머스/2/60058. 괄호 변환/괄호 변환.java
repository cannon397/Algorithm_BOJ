import java.util.*;
import java.util.stream.Stream;
class Solution {
    public String solution(String p) {
        String answer = "";
        
        if(isRightCharacter(p)) return p;

        return recursive(p);
    }
    public String recursive(String p){
        String answer = "";
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
        if(p.length() == 0) return "";
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
        int i = 0;
        Stack<Character> stack = new Stack<>();
        do {
            char c = p.charAt(i);
            i++;
            if(!stack.isEmpty() && stack.peek() != c){
                stack.pop();
                continue;
            }
            stack.push(c);
        } while(!stack.isEmpty());
        String u = p.substring(0, i);
        String v = p.substring(i);
        //3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
        if(isRightCharacter(u)) {
            answer = u + recursive(v);
        }else{
            String temp = recursive(v);
            String empty = temp;
            u = u.substring(1, u.length() - 1);
            String reversedEmpty = "";
            for(char c : u.toCharArray()){
                if(c == '(') reversedEmpty += ")";
               else reversedEmpty += "(";
            }
            answer = "(" + temp + ")" + reversedEmpty;
        }
        
        return answer;
    }
    public boolean isRightCharacter(String p){
    Stack<Character> stack = new Stack<>();
        for(char c : p.toCharArray()){
            if(c == '(') {
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        return (stack.size() == 0) ? true : false;
    }
}