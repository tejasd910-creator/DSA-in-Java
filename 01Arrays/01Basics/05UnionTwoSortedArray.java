import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnionI(int a[], int b[]) {
        // code here
        ArrayList<Integer> union = new ArrayList<>();
        
        int c1 = 0, c2 = 0;
        
        while(c1 < a.length && c2 < b.length){
            int val;
            
            if(a[c1] < b[c2])
               val = a[c1++];
            else if(a[c1] > b[c2])
               val = b[c2++];
            else{
               val = a[c1++];
               c2++;
            }
            
            if(union.isEmpty() || union.get(union.size() - 1) != val)
               union.add(val);
        }
        
        while(c1 < a.length){
            if(union.isEmpty() || union.get(union.size() - 1) != a[c1])
               union.add(a[c1]);
            c1++;
        }
        
        while(c2 < b.length){
            if(union.isEmpty() || union.get(union.size() - 1) != b[c2])
               union.add(b[c2]);
            c2++;
        }
        
        
        
        return union;
    }


    public static ArrayList<Integer> findUnionII(int a[], int b[]) {
        // code here
        ArrayList<Integer> union = new ArrayList<>();
        
        int c1 = 0, c2 = 0;
        
        while(c1 < a.length && c2 < b.length){
            if(a[c1] < b[c2])
                union.add(a[c1++]);
            else if (a[c1] > b[c2])
                union.add(b[c2++]);
            else{
                union.add(a[c1++]);
                c2++;
            }
        }
        
        while(c1 < a.length) union.add(a[c1++]);
        
        while(c2 < b.length) union.add(b[c2++]);
        
        union = new ArrayList<>(new LinkedHashSet<>(union));
        
        return union;
    }
}

