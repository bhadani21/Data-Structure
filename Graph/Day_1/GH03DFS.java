// Problem statement
// Given an undirected and disconnected graph G(V, E), containing 'V' vertices and 'E' edges, the information about edges is given using 'GRAPH' matrix, where i-th edge is between GRAPH[i][0] and GRAPH[i][1]. print its DFS traversal.

// V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 

// E is the number of edges present in graph G.
// Note :
// The Graph may not be connected i.e there may exist multiple components in a graph.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 2 <= V <= 10^3
// 1 <= E <= (5 * (10^3))

// Time Limit: 1sec
// Sample Input 1:
// 5 4
// 0 2
// 0 1
// 1 2
// 3 4
// Sample Output 1:
// 2
// 0 1 2
// 3 4
// Explanation For Sample Input 1:
// If we do a DFS traversal from vertex 0 we will get a component with vertices [0, 2, 1]. If we do a DFS traversal from 3 we will get another component with vertices [3, 4]

// Hence,  we have two disconnected components so on the first line, print 2. Now, print each component in increasing order. On the first line print 0 1 2 and on the second line, print 3 4.

// [0 1 2] comes before [3 4] as the first vertex 0 from the first component is smaller than the first vertex 3 from the second component.

import java.util.*;

public class DFS {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        boolean vis[] = new boolean[v];
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            int a =edges.get(i).get(0);
            int b =edges.get(i).get(1);
            adjList.get(a).add(b);
            adjList.get(b).add(a);

        }
        for(int i=0;i<v;i++){
            ArrayList<Integer> list=new ArrayList<>();
            if(!vis[i]){
                dfsUtil(i,vis,adjList,list);
                result.add(list);
            }   
        }
        return result;
    }

    public static void dfsUtil(int v, boolean vis[], ArrayList<ArrayList<Integer>> adjList,ArrayList<Integer> list){
         vis[v] = true;
        list.add(v);
        for(Integer node: adjList.get(v)){
            if(!vis[node]){
                dfsUtil(node,vis,adjList,list);
            }
        }
    }
}
