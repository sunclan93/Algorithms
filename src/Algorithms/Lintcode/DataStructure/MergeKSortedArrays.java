package Algorithms.Lintcode.DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * @param arrays: k sorted integer arrays
 * @return: a sorted array
 */
public class MergeKSortedArrays {

     class Node{
        int val;
        int arrayIndex;
        int index;
        public Node(int val, int arrayIndex, int index) {
            this.val = val;
            this.arrayIndex = arrayIndex;
            this.index = index;
        }
    }
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });
        int len = arrays.length;
        int total = 0;
        for (int i = 0; i < len; i++) {
            if (arrays[i].length == 0)
                continue;
            pq.add(new Node(arrays[i][0], i, 0));
            total = total + arrays[i].length;
        }
        int[] res = new int[total];

        int ind = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            res[ind] = cur.val;
            ind++;
            if (cur.index + 1 < arrays[cur.arrayIndex].length)
                pq.add(new Node(arrays[cur.arrayIndex][cur.index + 1], cur.arrayIndex, cur.index + 1));

        }
        return res;

    }
}
