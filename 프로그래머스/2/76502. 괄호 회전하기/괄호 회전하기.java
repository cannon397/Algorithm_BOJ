import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack;
        for(int i = 0; i < s.length(); i++){
            stack = new Stack<>();
            int j;
            for(j = i; j < s.length() + i; j++){
                char c = s.charAt(j % s.length());
                if(c == '[' ||
                  c == '(' ||
                  c == '{'){
                    stack.push(c);
                }else{
                    if(!stack.isEmpty()){
                        if(stack.peek() == '[' && c == ']'){
                            stack.pop();
                            continue;
                        }
                        if(stack.peek() == '(' && c == ')'){
                            stack.pop();
                            continue;
                        }
                        if(stack.peek() == '{' && c == '}'){
                            stack.pop();
                        }
                    }else{
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}