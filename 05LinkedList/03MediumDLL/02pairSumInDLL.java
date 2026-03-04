import java.util.*;

//Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}


class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        
        Node low = head;
        Node high = head;
        
        while(high.next != null)
            high = high.next;
        
        while (low != null && high != null && low != high && low.prev != high){
            ArrayList<Integer> num = new ArrayList<>();
            int n1 = low.data;
            int n2 = high.data;
            
            if((n1 + n2) < target)
               low = low.next;
            else if((n1 + n2) > target)
                high = high.prev;
            else{
                num.add(n1);
                num.add(n2);
                pairs.add(num);
                low = low.next;
                high = high.prev;
            }
        }
        
        return pairs;
    }
}