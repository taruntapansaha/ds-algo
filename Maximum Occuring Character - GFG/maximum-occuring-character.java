//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        
        int[] freq = new int[26];
        
        for(int i =0; i<line.length(); i++){
            freq[line.charAt(i) - 'a']++;
        }
        
        int max = 0;
        char res = 'a';
        
        for(int i = 25; i >= 0; i--){
            if(freq[i] != 0 && freq[i] >= max){
                max = freq[i];
                res = (char)(i+'a');
            }
        }
        
        return res;
    }
    
}