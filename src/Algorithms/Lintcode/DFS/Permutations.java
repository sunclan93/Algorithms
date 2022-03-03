package Algorithms.Lintcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;

    }
    public void dfs(List<List<Integer>> list, List<Integer> level, int[] nums, boolean[] visited) {
        if (level.size() == nums.length)
            list.add(new ArrayList<>(level));

        else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                    continue;
                visited[i] = true;
                level.add(nums[i]);
                dfs(list, level, nums, visited);
                level.remove(level.size() - 1);
            }
        }
    }
}
