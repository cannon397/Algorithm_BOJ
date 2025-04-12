import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        //45,46,95
        StringBuilder sb = new StringBuilder();
        new_id = new_id.toLowerCase();
        System.out.println(new_id);
        for(int i = 0; i < new_id.length(); i++){
            char c = new_id.charAt(i);
            if(c >= 48 && c <= 57){
                sb.append(c);
            }
            if(c >= 97 && c <= 122){
                sb.append(c);
            }
            if(c == 45 || c == 46 || c == 95){
                sb.append(c);
            }
        }
        System.out.println(sb);
        //마침표 치환코드 start
        boolean dotFlag = false;
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < sb.length(); i++){
            if(dotFlag && sb.charAt(i) == '.') continue;
            
            if(!dotFlag && sb.charAt(i) == '.'){
                dotFlag = true;
            }else if(dotFlag && sb.charAt(i) != '.'){
                dotFlag = false;
            }
            sb2.append(sb.charAt(i));
        }
        sb = sb2;
        //마침표 치환코드 end
        System.out.println(sb);
        if(sb.charAt(0) == '.') sb.delete(0, 1);
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
        if(sb.length() == 0) sb.append('a');
        System.out.println(sb);
        if(sb.length() >= 16){
            sb.delete(15, sb.length());
            if(sb.charAt(sb.length() - 1) == '.') sb.delete(sb.length() - 1, sb.length());

        }
        System.out.println(sb);
        if(sb.length() <= 2){
            while(sb.length() < 3){
                sb.append(sb.charAt(sb.length() - 1));
            }
        }
        System.out.println(sb);
        answer = sb.toString(); 
        return answer;
    }
}