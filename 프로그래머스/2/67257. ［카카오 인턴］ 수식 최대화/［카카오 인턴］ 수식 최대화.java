import java.util.*;

class Solution {
    char[] op = {'*', '+', '-'};
    long answer;
    boolean[] visited = new boolean[3];
    
    public long solution(String expression) {
        answer = 0;
        dfs(0, new char[3], expression);
        return answer;
    }

    public void dfs(int depth, char[] order, String expression) {
        if (depth == 3) {
            long val = Math.abs(evaluate(expression, order));
            answer = Math.max(answer, val);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = op[i];
                dfs(depth + 1, order, expression);
                visited[i] = false;
            }
        }
    }

    private long evaluate(String expr, char[] precedence) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        parseExpression(expr, numbers, operators);

        for (char op : precedence) {
            for (int i = 0; i < operators.size();) {
                if (operators.get(i) == op) {
                    long a = numbers.get(i);
                    long b = numbers.get(i + 1);
                    long res = calculate(a, b, op);
                    numbers.set(i, res);
                    numbers.remove(i + 1);
                    operators.remove(i);
                } else {
                    i++;
                }
            }
        }
        return numbers.get(0);
    }

    private void parseExpression(String expr, List<Long> numbers, List<Character> operators) {
        int idx = 0;
        StringBuilder num = new StringBuilder();
        while (idx < expr.length()) {
            char c = expr.charAt(idx);
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                numbers.add(Long.parseLong(num.toString()));
                operators.add(c);
                num.setLength(0);
            }
            idx++;
        }
        numbers.add(Long.parseLong(num.toString()));
    }

    private long calculate(long a, long b, char op) {
        long result = 0;
        switch (op) {
            case '*': 
                result = a * b;
                break;
            case '+': 
                result = a + b;
                break;
            case '-': 
                result = a - b;
                break;
        }
        return result;
    }
}
