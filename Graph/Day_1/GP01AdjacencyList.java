// Problem statement
// You are given an undirected graph of 'N' nodes and 'M' edges. Your task is to create the graph and print the adjacency list of the graph. It is guaranteed that all the edges are unique, i.e., if there is an edge from 'X' to 'Y', then there is no edge present from 'Y' to 'X' and vice versa. Also, there are no self-loops present in the graph.
// In graph theory, an adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a vertex in the graph.

// For Example:
// If 'N' = 3 and edges = {{2,1}, {2,0}}.

// So, the adjacency list of the graph is stated below.
// 0 → 2
// 1 → 2
// 2 → 0 → 1

// Sample Input 1:
// 4 3
// 1 2
// 0 3
// 2 3
// Sample Output 1:
// 0 3
// 1 2
// 2 1 3
// 3 0 2
// Explanation For Sample Input 1:
// The graph is shown in the below figure.

// So, the neighbour of node 0 is 3. So, in the first line, the first integer is 0 followed by its neighbour 3. Similarly in the second line, 1 is followed by its neighbour 2. 

// In the third line, 2 is followed by its neighbours 1 and 3. And in the fourth line, 3 is followed by its neighbours 0 and 2.


import java.util.*;
public class GP01AdjacencyList{
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        // Write your code here.

        HashMap<Integer, ArrayList<Integer>> ans=new HashMap<>();
        
        for(int i=0;i<n;i++){
            ans.put(i,new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
             int a =edges[i][0];
             int b = edges[i][1];

             if(ans.containsKey(a)){
                 ArrayList<Integer> d = ans.get(a);
                 d.add(b);
                 ans.put(a,d);
             }
              if(ans.containsKey(b)){
                 ArrayList<Integer> d = ans.get(b);
                 d.add(a);
                 ans.put(b,d);
             }
        }
        int [][] result= new int [n][];
        for(int i=0;i<ans.size();i++){
            ArrayList<Integer> temp = ans.get(i);

            int temparr[] = new int[temp.size()+1];
            temparr[0] = i;

            for(int j=0;j<temp.size();j++){
                temparr[j+1]= temp.get(j);
            }

            result[i]= temparr;
        }
         return result;
    }
}
