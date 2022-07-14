## BFS通用模板
```
// 计算从起点start 到终点target 的距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路

    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数

    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散*/
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点*/
            if (cur is target) 
                return step;
            /* 将cur 的相邻接点加入队列*/
            for (Node x: cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
        }
        /* 划重点：更新步数在这里*/
        step++;
    }
}
```

## 双向BFS
从起点和终点同时开始扩散，当两边有交集的时候停止
```
word ladder
public int ladderLength(String beginWord, String endWord, List<String> wordListInput) {
    Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
    Set<String> wordList = new HashSet<>(wordListInput);
    Set<String> visited = new HashSet<>();
    if (!wordList.contains(endWord)) return 0;
    int step = 1, N = beginWord.length;
    beginSet.add(beginWord);
    endSet.add(endWord);
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
        Set<String> nextSet = new HashSet<>();
        for (String word: beginSet) { // 
            char[] chs = word.toCharArray();
            for (int i = 0; i < N; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char pre = chs[i];
                    chs[i] = c;
                    String nextWord = new String(chs);
                    if (endSet.contains(nextWord)) return step + 1;
                    if (visited.add(nextWord) && wordList.contains(nextWord))
                        nextSet.add(nextWord);
                    chs[i] = pre;
                }
            }
            
        }
        if (endSet.size() < nextSet.size()) {
            beginSet = endSet;
            endSet = nextSet;

        }
        else beginSet = nextSet;
        step++;
    }
    return 0;
}
```

## Dijkstra 模板
505. The Maze II
```
class Solution {
    int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dijstra(maze, start, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1: distance[destination[0]][destination[1]];
    }
    public void dijkstra(int[][] maze, int[] start, int[][] distance) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        q.offer(new int[]{start[0], start[1], 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir: dirs) {
                int x = cur[0], y = cur[1], count = 0;
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                count--;
                if (distance[cur[0]][cur[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[cur[0]][cur[1]] + count;
                    q.add(new int[]{x, y, distance[x][y]});
                }
            }
        }
    }
}
```

## 拓扑排序
public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList();
        Map<DirectedGraphNode, Integer> indegree = new HashMap();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode nei : node.neighbors) {
                indegree.putIfAbsent(node, 0); // note: need to add node itself to start
                indegree.put(nei, indegree.getOrDefault(nei, 0) + 1);
            }
        }

        Queue<DirectedGraphNode> q = new LinkedList();
        for(DirectedGraphNode key : indegree.keySet()) {
            if(indegree.get(key) == 0) q.add(key);
        }

        while(q.size() > 0) {
            DirectedGraphNode node = q.poll();
            res.add(node);
            for(DirectedGraphNode nei : node.neighbors) {
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0) q.add(nei);
            }
        }
        return res;
    }

