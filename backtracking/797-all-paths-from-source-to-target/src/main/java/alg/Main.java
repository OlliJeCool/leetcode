package alg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        int[][] graph = new int[][]{
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        };

        allPathsSourceTarget(graph);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(0, res, path, graph, graph.length-1);
        return res;
    }

    public static void backtrack(int node, List<List<Integer>> res, List<Integer> current, int[][] graph, int target){
        if(node == target){
            res.add(new ArrayList<>(current));
            return;
        }


        for(int neigbor : graph[node]){
            current.add(neigbor);
            backtrack(neigbor, res, current, graph, target);
            current.removeLast();
        }
    }
}
