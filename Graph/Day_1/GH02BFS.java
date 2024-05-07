// Problem statement
// Given an adjacency list representation of a directed graph with ‘n’ vertices and ‘m’ edges. Your task is to return a list consisting of Breadth-First Traversal (BFS) starting from vertex 0.



// In this traversal, one can move from vertex 'u' to vertex 'v' only if there is an edge from 'u' to 'v'. The BFS traversal should include all nodes directly or indirectly connected to vertex 0.



// Note:
// The traversal should proceed from left to right according to the input adjacency list.


// Example:
// Adjacency list: { {1,2,3},{4}, {5}, {},{},{}}

// The interpretation of this adjacency list is as follows:
// Vertex 0 has directed edges towards vertices 1, 2, and 3.
// Vertex 1 has a directed edge towards vertex 4.
// Vertex 2 has a directed edge towards vertex 5.
// Vertices 3, 4, and 5 have no outgoing edges.

// We can also see this in the diagram below.

// BFS traversal: 0 1 2 3 4 5

// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 8 7
// 0 1
// 0 2
// 0 3
// 1 4
// 1 7
// 2 5
// 3 6
// Sample Output 1:
// 0 1 2 3 4 7 5 6


import java.util.List;
import java.util.Queue;
import java.util.*;
public class BFS {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        // Write your code here

        Queue<Integer> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        q.add(0);
        boolean vis[] = new boolean[n];

        while(!q.isEmpty()){
            int node=q.poll();
            if(!vis[node]){
                vis[node]= true;
                list.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                q.add(adj.get(node).get(i));
            }
        }
        }
        return list;
    }
}

