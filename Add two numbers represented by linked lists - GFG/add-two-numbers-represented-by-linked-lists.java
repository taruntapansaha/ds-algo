//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        
        Node prev = null;
        
        while(first != null){
            Node temp = first.next;
            first.next = prev;
            prev = first;
            first = temp;
        }
        
        first = prev;
        prev = null;
        
        while(second != null){
            Node temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        
        second = prev;
        
        int carry = 0;
        Node result = null;
        
        while(first != null || second != null){
            int n1 = first == null ? 0 : first.data;
            int n2 = second == null ? 0 : second.data;
            
            int sum = n1+n2+carry;
            
            carry = sum / 10;
            
            Node node = new Node(sum%10);
            node.next = result;
            
            result = node;
            if(first != null) first = first.next;
            if(second != null) second = second.next;
        }
        
        if(carry == 1){
            Node node = new Node(1);
            node.next = result;
            result = node;
        }
        
        return result;
    }
}