package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * There is an undirected star graph consisting of n nodes labeled from 1 to n.
 * A star graph is a graph where there is one center node and exactly n - 1 edges
 * that connect the center node with every other node.
 *
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates
 * that there is an edge between the nodes ui and vi.
 * Return the center of the given star graph.
 */
public class CenterOfStar {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{5,1},{1,3},{1,4}};
        System.out.println(findCenterStar(edges));
    }

    public static int findCenterStar(int[][] edges){
        int n = edges.length + 1; // this is the total number of nodes. Always 1 unit higher than graph array length
//        create a hashmap to store the degree of each node

        Map<Integer, Integer> map = new HashMap<>();
//        iterate over teh each edge in the array edges

        for (int[] e : edges){
            int u = e[0];
            int v = e[1];
//        increase the degree of nodes u and v on each encounter on i
            map.put(u, map.getOrDefault(u, 0) + 1);
            map.put(v, map.getOrDefault(v, 0) + 1);

        }

//        iterate through the hashmap k, v pair to find k
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int node = entry.getKey();
            int degree = entry.getValue();
            if(degree == n - 1){
                return node;
            }
        }
        return -1;

    }

}
