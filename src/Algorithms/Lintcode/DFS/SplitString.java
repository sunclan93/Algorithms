package Algorithms.Lintcode.DFS;

import java.util.ArrayList;
import java.util.List;

public class SplitString {
    public List<List<String>> splitString(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, s);
        return res;
    }
    public void dfs(List<List<String>> res, List<String> level, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<>(level));
            return;
        }
        level.add(s.substring(start, start + 1));
        dfs(res, level, start + 1, s);
        level.remove(level.size() - 1);
        if (start + 1 < s.length()) {
            level.add(s.substring(start, start + 2));
            dfs(res, level, start + 2, s);
//            level.remove(level.size() - 1);

        }

    }

    public static void main(String[] args) {
        SplitString obj = new SplitString();

        List<List<String>> list = obj.splitString("123");
        for (List<String> l1: list) {
            for (String s: l1) {
                System.out.println(s);
            }
            System.out.println("---");
        }
    }
}
