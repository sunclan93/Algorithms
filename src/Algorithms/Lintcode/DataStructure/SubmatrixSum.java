package Algorithms.Lintcode.DataStructure;

import java.util.HashMap;

public class SubmatrixSum {
    public int[][] submatrixSum(int[][] matrix) {
        int[][] result = new int[2][2];
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] pre = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            pre[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            pre[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] + matrix[i][j] - pre[i][j];

            }
        }
        for (int y1 = 0; y1 < n; y1++) {
            for (int y2 = y1 + 1; y2 <= n; y2++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i <= m; i++) {
                    int diff = pre[y2][i] - pre[y1][i];
                    if (map.containsKey(diff)) {
                        int key = map.get(diff);
                        result[0][0] = y1;
                        result[0][1] = key;
                        result[1][0] = y2 - 1;
                        result[1][1] = i - 1;
                        return result;
                    }
                    else {
                        map.put(diff, i);
                    }
                }
            }
        }
        return result;



    }

    public int[][] submatrixSumTemplate1(int[][] matrix) {
        // write your code here
        int[][] res = new int[2][2];
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m][n];
        pre[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            pre[i][0] = pre[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            pre[0][i] = pre[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + matrix[i][j] - pre[i - 1][j - 1];
            }
        }

        for(int i = 0; i < m; i++) {
            for (int j = i; j <m; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int d = 0; d < n; d++) {
                    int val = pre[j][d] - pre[i][d];
                    if (map.containsKey(val)){
                        res[0][0] = i;
                        res[1][0] = j;
                        res[0][1] = map.get(val);
                        res[1][1] = d;
                        return res;
                    }
                    else {
                        map.put(val, d);
                    }
                }
            }

        }
        return res;
    }
}
