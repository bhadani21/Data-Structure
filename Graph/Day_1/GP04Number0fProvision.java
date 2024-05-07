
// Problem statement
// You are given ‘n’ cities, some of which are connected by bidirectional roads. You are also given an ‘n x n’ matrix i.e. ‘roads’, where if city ‘i’ and ‘j’ are connected by a road then ‘roads[i][j]'= 1, otherwise ‘roads[i][j]' = 0.



// A province is a group of cities that are either directly or indirectly connected to each other through roads.



// The goal is to count and return the total number of such provinces in the given matrix.



// Example:
// n = 4, roads = [ [1, 1, 1, 0],
//                  [1, 1, 1, 0],
//                  [1, 1, 1, 0],
//                  [0, 0, 0, 1] ]

// So, there are ‘2’ provinces.
// Note:
// 1. A city is connected to itself. So, for every city ‘i’, ‘roads[i][i] = 1’.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample input 1:
// 3
// 1 0 0 
// 0 1 0 
// 0 0 1 
// Sample output 1:
// 3
// Explanation of sample input 1:
// Test Case 1:
// n = 3, roads = [ [1, 0, 0],
//                  [0, 1, 0],
//                  [0, 0, 1] ]

// So, there are ‘3’ provinces.


import java.util.*;
public class GP04Number0fProvision {
    public static int findNumOfProvinces(int[][] roads, int n) {
        // Write your code here.

        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(roads[i][j]==1 && i!=j){
                    list.get(i).add(j);
                }
            }
        }

        boolean vis[] =new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfsUtil(i,vis,list);
                count++;
            }
        }
        return count;
    }

    public static void dfsUtil(int node, boolean vis[], List<List<Integer>> list){

        vis[node]=true;
        for(Integer data: list.get(node)){
        if(!vis[data]){
            dfsUtil(data,vis,list);
        }
        }
    }
}
