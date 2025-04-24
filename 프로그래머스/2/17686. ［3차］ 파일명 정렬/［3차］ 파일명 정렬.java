import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File> list = new ArrayList<>();
        for(String file : files){
            String head = file.replaceFirst("\\d.*", "");
            String number = file.replaceFirst(".*?(\\d+).*", "$1");
            String tail = file.replaceFirst(".*?\\d+", "");
            File f = new File();
            f.setHead(head);
            f.setNumber(number);
            f.setTail(tail);
            list.add(f);
        }
        list.sort((o1, o2) -> {
            String head1 = o1.getHead().toLowerCase();
            String head2 = o2.getHead().toLowerCase();
            int num1 = Integer.parseInt(o1.getNumber());
            int num2 = Integer.parseInt(o2.getNumber());
            if(head1.equals(head2) && num1 == num2){
                return 0;
            }else if(head1.equals(head2)){
                return num1 - num2;
            }else{
                return head1.compareTo(head2);
            }
        });
        for(int i = 0; i < files.length; i++){
            File f = list.get(i);
            answer[i] = f.getHead() + f.getNumber() + f.getTail();
            //System.out.printf("%s%s%s\n", f.getHead(), f.getNumber() ,f.getTail());
        }
        return answer;
    }
    static class File {
        String head;
        String number;
        String tail;
        public void setHead(String head){
            this.head = head;
        }
        public void setNumber(String number){
            this.number = number;
        }
        public void setTail(String tail){
            this.tail = tail;
        }
        public String getHead(){
            return this.head;
        }
        public String getNumber(){
            return this.number;
        }
        public String getTail(){
            return this.tail;
        }
    }
}