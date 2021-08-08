/*
@Author: Anmol Kumar Sharma

Problem: Rank Transform of a Matrix
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3874/
Reference Link: https://leetcode.libaoj.in/rank-transform-of-a-matrix.html
*/

class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // link row to col, and link col to row
        Map<Integer, Map<Integer, List<Integer>>> graphs = new HashMap<>();
        // graphs.get(v): the connection graph of value v
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];
                // if not initialized, initial it
                if (!graphs.containsKey(v)) {
                    graphs.put(v, new HashMap<Integer, List<Integer>>());
                }
                Map<Integer, List<Integer>> graph = graphs.get(v);
                if (!graph.containsKey(i)) {
                    graph.put(i, new ArrayList<Integer>());
                }
                if (!graph.containsKey(~j)) {
                    graph.put(~j, new ArrayList<Integer>());
                }
                // link i to j, and link j to i
                graph.get(i).add(~j);
                graph.get(~j).add(i);
            }
        }

        // put points into `value2index` dict, grouped by connection
        // use TreeMap to help us sort the key automatically
        SortedMap<Integer, List<List<int[]>>> value2index = new TreeMap<>();
        int[][] seen = new int[m][n]; // mark whether put into `value2index` or not
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seen[i][j] == 1) {
                    continue;
                }
                seen[i][j] = 1;
                int v = matrix[i][j];
                Map<Integer, List<Integer>> graph = graphs.get(v);
                // store visited row and col
                Set<Integer> rowcols = new HashSet<Integer>();
                rowcols.add(i);
                rowcols.add(~j);
                // start bfs
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                q.offer(~j);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int rowcol : graph.get(node)) {
                        if (!rowcols.contains(rowcol)) {
                            rowcols.add(rowcol);
                            q.offer(rowcol);
                        }
                    }
                }
                // transform rowcols into points
                List<int[]> points = new ArrayList<>();
                for (int rowcol : rowcols) {
                    for (int k : graph.get(rowcol)) {
                        if (k >= 0) {
                            points.add(new int[] { k, ~rowcol });
                            seen[k][~rowcol] = 1;
                        } else {
                            points.add(new int[] { rowcol, ~k });
                            seen[rowcol][~k] = 1;
                        }
                    }
                }
                if (!value2index.containsKey(v)) {
                    value2index.put(v, new ArrayList<List<int[]>>());
                }
                value2index.get(v).add(points);
            }
        }
        int[][] answer = new int[m][n]; // the required rank matrix
        int[] rowMax = new int[m]; // rowMax[i]: the max rank in i row
        int[] colMax = new int[n]; // colMax[j]: the max rank in j col
        for (int v : value2index.keySet()) {
            // update by connected points with same value
            for (List<int[]> points : value2index.get(v)) {
                int rank = 1;
                for (int[] point : points) {
                    rank = Math.max(rank, Math.max(rowMax[point[0]], colMax[point[1]]) + 1);
                }
                for (int[] point : points) {
                    answer[point[0]][point[1]] = rank;
                    // update rowMax and colMax
                    rowMax[point[0]] = Math.max(rowMax[point[0]], rank);
                    colMax[point[1]] = Math.max(colMax[point[1]], rank);
                }
            }
        }
        return answer;
    }
}
