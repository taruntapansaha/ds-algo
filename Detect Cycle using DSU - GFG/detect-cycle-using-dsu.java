//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    
    int[] rank;
    int[] parent;
    
    public void intiDisjointSet(int V){
        rank = new int[V];
        parent = new int[V];
        
        for(int i=0; i<V; i++){
            parent[i] = i;
        }
    }
    
    public int find(int v){
        
        if(parent[v] == v){
            return v;
        }
        
        return parent[v] = find(parent[v]);
    }
    
    public void union(int a, int b){
        
        int parentA = find(a); 
        int parentB = find(b);
        
        if(rank[parentA] > rank[parentB]){
            parent[parentB] = parentA;
        } else if (rank[parentA] < rank[parentB]){
            parent[parentA] = parentB;
        } else{
            parent[parentB] = parentA;
            rank[parentA]++;
        }

    }
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        if(V == 2) return 0;
        
        intiDisjointSet(V);
        
        for(int u = 0; u < adj.size(); u++){
            for(int i = 0; i < adj.get(u).size(); i++){
                int v = adj.get(u).get(i);
                
                if(u < v){
                    if(find(v) == find(v)){
                      return 1;  
                    } else {
                        union(u, v);
                    }
                }
            }
        }
        
        
        return 0;
        
    }
}