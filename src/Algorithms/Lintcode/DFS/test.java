package Algorithms.Lintcode.DFS;

import java.util.ArrayList;
import java.util.List;

public class test {

    public List<String> solution(String s) {
            List<String> res = new ArrayList<>();
            dfs(res, new StringBuffer(), s, 0);
            return res;

    }
    public void dfs(List<String> res, StringBuffer sb, String s, int start) {
        if (start == s.length()) {
            res.add(new StringBuffer(sb).toString());
            return;
        }
        char c= s.charAt(start);
        if (Character.isDigit(c)) {
            sb.append(c);
            dfs(res, sb, s, start + 1);

        }
        else {
            sb.append(c);
            dfs(res, sb, s, start + 1);
            sb.deleteCharAt(start);
            sb.append(Character.toUpperCase(c));
            dfs(res, sb, s, start + 1);
        }
    }
    static class Test{
        void t() {
            System.out.println("111");
        }
    }
    public static void main(String[] args) {
        Test te = new Test();

    }
}
