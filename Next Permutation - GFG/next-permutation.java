//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here 
        
        List<Integer> list = new ArrayList<>();
        
        int pivot = -1;
        
        for(int i = 1; i < N; i++){
            if(arr[i] > arr[i-1]) pivot = i;
        }
        
        if(pivot == -1){
            Arrays.sort(arr);
            for(int n: arr){
                list.add(n);
            }
            return list;
        }
        
        
        
        int lastIdx = pivot;
        
        for(int i=lastIdx; i<N; i++){
            if(arr[pivot-1] < arr[i] && arr[i] < arr[pivot]){
                lastIdx = i;
            }
        }
        
        swap(pivot-1, lastIdx, arr);
        Arrays.sort(arr, pivot, N);
       
        for(int n: arr){
            list.add(n);
        }
        return list;
        
    }
    
    static void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}