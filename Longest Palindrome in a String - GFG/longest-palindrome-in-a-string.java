//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        
        if(S.length() < 2) return S;
        int start = 0, end = 0, len = 0;

        for(int i=0; i<S.length(); i++){
            len = Math.max(isPlaimdrom(S, i, i), isPlaimdrom(S, i, i+1));
            
            if(len > (end - start + 1)){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
            
        }
        
        return S.substring(start, end+1);
    }
    
    static int isPlaimdrom(String s, int i, int j){
        
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        
        return j - i -1;
        
    }
}